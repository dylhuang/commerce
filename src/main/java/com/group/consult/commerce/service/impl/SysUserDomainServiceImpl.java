package com.group.consult.commerce.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group.consult.commerce.configuration.interceptors.LoginUser;
import com.group.consult.commerce.dao.entity.SysRole;
import com.group.consult.commerce.dao.entity.SysUser;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.UserAddDTO;
import com.group.consult.commerce.model.dto.UserEditDTO;
import com.group.consult.commerce.model.dto.UserListDTO;
import com.group.consult.commerce.model.vo.UserDetailVO;
import com.group.consult.commerce.model.vo.UserListVO;
import com.group.consult.commerce.persist.ISysRoleService;
import com.group.consult.commerce.persist.ISysUserRoleService;
import com.group.consult.commerce.persist.ISysUserService;
import com.group.consult.commerce.service.ISysUserDomainService;
import com.group.consult.commerce.utils.GerneralUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @title: 用户管理
 * @description: 用户管理
 * @author: zl
 * @date: 2024-08-12
 */
@Service
public class SysUserDomainServiceImpl implements ISysUserDomainService {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysUserRoleService userRoleService;

    @Autowired
    private ISysRoleService roleService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean add(UserAddDTO userAddDTO) {
        SysUser userInfo = userService.findByUserName(userAddDTO.getUserName());
        GerneralUtil.assertCheck(userInfo == null, ApiCodeEnum.USER_EXIST);
        SysUser user = new SysUser();
        BeanUtil.copyProperties(userAddDTO, user);
        //todo 密码处理
        //user.setPassword(SecurityUtils.encryptPassword(sysUserDto.getPassword()));
        Boolean isRes = userService.save(user);
        if (isRes) {
            List<Long> roleIds = userAddDTO.getRoleIds().stream().map(item -> Long.valueOf(item)).collect(
                    Collectors.toList());
            userRoleService.bindUserRole(user.getId(), roleIds);
        }
        return Boolean.TRUE;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean edit(UserEditDTO userEditDTO) {
        Long id = Long.valueOf(userEditDTO.getId());
        SysUser user = new SysUser();
        BeanUtil.copyProperties(userEditDTO, user);
        user.setId(id);
        Boolean resSave = this.userService.updateById(user);
        GerneralUtil.assertCheck(resSave, ApiCodeEnum.DB_EXE_FAIL);
        userRoleService.removeUserRole(user.getId());
        List<Long> roleIds = userEditDTO.getRoleIds().stream().map(item -> Long.valueOf(item)).collect(
                Collectors.toList());
        userRoleService.bindUserRole(user.getId(), roleIds);
        return Boolean.TRUE;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean remove(List<Long> ids) {
        Long loginUserId = LoginUser.getLoginSubject().getUserId();
        GerneralUtil.assertCheck(!ids.contains(loginUserId), ApiCodeEnum.NO_DEL_SELF);
        GerneralUtil.assertCheck(CollectionUtil.isNotEmpty(ids), ApiCodeEnum.VALIDATE_ERROR);

        //删除用户角色关系
        userRoleService.removeBatchUserRole(ids);

        //删除用户
        return userService.removeByIds(ids);
    }

    @Override
    public UserDetailVO fetchDetail(Long id) {
        SysUser sysUser = userService.getById(id);
        if (sysUser == null) {
            return null;
        }

        UserDetailVO userDetailVO = new UserDetailVO();
        BeanUtil.copyProperties(sysUser, userDetailVO);
        List<SysRole> roles = roleService.listByUserId(id);
        List<String> roleIds = roles.stream().map(item -> item.getId().toString()).collect(Collectors.toList());
        userDetailVO.setRoleIds(roleIds);
        return userDetailVO;
    }

    @Override
    public PageResult<UserListVO> pageList(UserListDTO dto) {
        dto.initWithUpdateTimeSort();
        Page<SysUser> page = Page.of(dto.getPageNum(), dto.getPageSize());

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByDesc(SysUser::getCreateTime);
        if (StringUtils.isNotBlank(dto.getNickName())) {
            queryWrapper.lambda().like(SysUser::getNickName, dto.getNickName());
        }
        if (StringUtils.isNotBlank(dto.getPhone())) {
            queryWrapper.lambda().like(SysUser::getPhone, dto.getPhone());
        }
        if (StringUtils.isNotBlank(dto.getUserName())) {
            queryWrapper.lambda().like(SysUser::getUserName, dto.getUserName());
        }
        if (dto.getStatus() != null) {
            queryWrapper.lambda().eq(SysUser::getStatus, dto.getStatus());
        }
        IPage<SysUser> pageResult = userService.page(page, queryWrapper);
        List<UserListVO> list = pageResult.getRecords().stream().map(item -> {
            UserListVO resultDto = new UserListVO();
            BeanUtil.copyProperties(item, resultDto);
            return resultDto;
        }).collect(Collectors.toList());

        return PageResult.of(list, pageResult);
    }
}
