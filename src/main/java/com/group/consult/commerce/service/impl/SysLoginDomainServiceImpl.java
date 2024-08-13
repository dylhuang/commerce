package com.group.consult.commerce.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.group.consult.commerce.configuration.Constants;
import com.group.consult.commerce.dao.entity.SysCaptchaCode;
import com.group.consult.commerce.dao.entity.SysMenu;
import com.group.consult.commerce.dao.entity.SysRole;
import com.group.consult.commerce.dao.entity.SysUser;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.dto.CaptchDTO;
import com.group.consult.commerce.model.dto.LoginDTO;
import com.group.consult.commerce.model.dto.SysUpdateUserPwdDTO;
import com.group.consult.commerce.model.vo.RoutersVO;
import com.group.consult.commerce.model.vo.UpdatePersonInfoDTO;
import com.group.consult.commerce.model.vo.UserInfoVO;
import com.group.consult.commerce.persist.ISysCaptchaCodeService;
import com.group.consult.commerce.persist.ISysMenuService;
import com.group.consult.commerce.persist.ISysRoleService;
import com.group.consult.commerce.persist.ISysUserService;
import com.group.consult.commerce.service.ISysLoginDomainService;
import com.group.consult.commerce.utils.GerneralUtil;
import com.group.consult.commerce.utils.JwtUtil;
import com.group.consult.commerce.utils.PasswordSaltGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @title: 系统登录
 * @description: 系统登录
 * @author: zl
 * @date: 2024-08-08
 */
@Service
public class SysLoginDomainServiceImpl implements ISysLoginDomainService {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysCaptchaCodeService captchaCodeService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String login(LoginDTO dto) {

        //1、校验验证码
        SysCaptchaCode captchaCode = captchaCodeService.queryByUuid(dto.getUuid());
        //验证码已过期
        GerneralUtil.assertCheck(captchaCode != null, ApiCodeEnum.CAPTCHA_EXPIRED);
        //验证码错误
        GerneralUtil.assertCheck(dto.getCode().equals(captchaCode.getCode()), ApiCodeEnum.CAPTCHA_EXPIRED);

        //2、校验用户密码
        SysUser sysUser = userService.findByUserName(dto.getUsername());
        GerneralUtil.assertCheck(sysUser != null, ApiCodeEnum.USER_PWD_ERROR);
        GerneralUtil.assertCheck(Constants.ZERO.equals(sysUser.getStatus()), ApiCodeEnum.USER_STATUS_ERROR);
        //用户密码校验
        Boolean checkRes = PasswordSaltGeneratorUtil.match(dto.getPassword(), sysUser.getPassword());
        GerneralUtil.assertCheck(checkRes, ApiCodeEnum.USER_PWD_ERROR);
        //3、生成token
        String token = jwtUtil.generateToken(sysUser.getUserName());
        return token;
    }

    @Override
    public void saveAndClearCaptchaCode(CaptchDTO captchDTO) {
        SysCaptchaCode captchaCode = new SysCaptchaCode();
        BeanUtil.copyProperties(captchDTO, captchaCode);
        captchaCodeService.saveAndClearCaptchaCode(captchaCode);
    }

    @Override
    public UserInfoVO getUserInfo(String userName) {

        UserInfoVO userInfoVO = new UserInfoVO();
        //1、获取用户基础信息
        SysUser sysUser = userService.findByUserName(userName);
        GerneralUtil.assertCheck(sysUser != null, ApiCodeEnum.NOT_FIND_ERROR);
        BeanUtil.copyProperties(sysUser, userInfoVO);
        userInfoVO.setId(sysUser.getId());

        //2、获取用户拥有的角色列表
        List<SysRole> sysRoles = roleService.listByUserId(sysUser.getId());
        List<String> roldIds = sysRoles.stream().map(item -> {
            return item.getId().toString();
        }).collect(Collectors.toList());
        userInfoVO.setRoleIds(roldIds);

        //3、获取用户拥有的权限码列表
        List<String> permissionCodes = getPermissionCodes(sysUser.getId());
        userInfoVO.setPermissionCodes(permissionCodes);

        return userInfoVO;
    }

    @Override
    public List<String> getPermissionCodes(Long userId) {
        List<SysMenu> sysMenus = menuService.findByUserId(userId);
        return sysMenus.stream().map(SysMenu::getCode).collect(Collectors.toList());
    }

    @Override
    public List<RoutersVO> getRouters(String userName) {

        //1、获取用户基础信息
        SysUser sysUser = userService.findByUserName(userName);
        GerneralUtil.assertCheck(sysUser != null, ApiCodeEnum.NOT_FIND_ERROR);

        //2、获取用户权限菜单,只查目录和菜单
        List<SysMenu> sysMenus = menuService.findRoutersByUserId(sysUser.getId());

        //3、组装树形结构
        return buildRoutes(0L, sysMenus);
    }

    /**
     * 递归构造路由菜单为树形
     * @param parentId
     * @param menus
     * @return
     */
    public List<RoutersVO> buildRoutes(Long parentId, List<SysMenu> menus) {
        List<RoutersVO> routersVOS = menus.stream().filter(item -> parentId.equals(item.getParentId())).map(item -> {
            RoutersVO routersVO = new RoutersVO();
            BeanUtil.copyProperties(item, routersVO);
            routersVO.setId(item.getId().toString());
            List<RoutersVO> children = buildRoutes(item.getId(), menus);
            routersVO.setChildren(children);
            return routersVO;
        }).collect(Collectors.toList());
        return routersVOS;
    }

    @Override
    public Boolean updatePersonInfo(UpdatePersonInfoDTO dto) {
        return userService.updatePersonInfo(dto);
    }

    @Override
    public Boolean updatePwd(SysUpdateUserPwdDTO dto) {
        return userService.updatePwd(dto);
    }
}
