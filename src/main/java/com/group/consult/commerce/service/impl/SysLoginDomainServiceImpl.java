package com.group.consult.commerce.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.MD5;
import com.group.consult.commerce.configuration.Constants;
import com.group.consult.commerce.dao.entity.SysCaptchaCode;
import com.group.consult.commerce.dao.entity.SysMenu;
import com.group.consult.commerce.dao.entity.SysRole;
import com.group.consult.commerce.dao.entity.SysUser;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.dto.CaptchDTO;
import com.group.consult.commerce.model.dto.LoginDTO;
import com.group.consult.commerce.model.vo.UserInfoVO;
import com.group.consult.commerce.persist.ISysCaptchaCodeService;
import com.group.consult.commerce.persist.ISysMenuService;
import com.group.consult.commerce.persist.ISysRoleService;
import com.group.consult.commerce.persist.ISysUserService;
import com.group.consult.commerce.service.ISysLoginDomainService;
import com.group.consult.commerce.utils.GerneralUtil;
import com.group.consult.commerce.utils.JwtUtil;
import org.springframework.beans.BeanUtils;
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
        //todo 用户密码校验
        //todo 生成token
        String token = jwtUtil.generateToken("admin");
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
        List<SysMenu> sysMenus = menuService.findByUserId(sysUser.getId());
        List<String> permissionCodes = sysMenus.stream().map(SysMenu::getCode).collect(Collectors.toList());
        userInfoVO.setPermissionCodes(permissionCodes);

        return userInfoVO;
    }
}
