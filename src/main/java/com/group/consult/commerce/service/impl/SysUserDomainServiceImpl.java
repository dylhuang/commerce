package com.group.consult.commerce.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.group.consult.commerce.dao.entity.SysUser;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.dto.UserAddDTO;
import com.group.consult.commerce.model.dto.UserEditDTO;
import com.group.consult.commerce.persist.ISysUserRoleService;
import com.group.consult.commerce.persist.ISysUserService;
import com.group.consult.commerce.service.ISysUserDomainService;
import com.group.consult.commerce.utils.GerneralUtil;
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
}
