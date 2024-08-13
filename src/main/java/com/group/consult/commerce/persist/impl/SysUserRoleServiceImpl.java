package com.group.consult.commerce.persist.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.SysUserRole;
import com.group.consult.commerce.dao.mapper.SysUserRoleMapper;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.persist.ISysUserRoleService;
import com.group.consult.commerce.utils.GerneralUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {
    @Override
    public long countByRoleId(List<Long> roleIds) {
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(SysUserRole::getRoleId, roleIds);
        return this.count(queryWrapper);
    }

    @Override
    public void bindUserRole(Long userId, List<Long> roleIds) {
        GerneralUtil.check(userId == null || CollectionUtil.isEmpty(roleIds), ApiCodeEnum.PARAM_SET_ILLEGAL);
        List<SysUserRole> userRoles = new ArrayList<>();
        for (Long roleId : roleIds) {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRoles.add(userRole);
        }
        this.saveBatch(userRoles, Integer.MAX_VALUE);
    }

    @Override
    public int removeUserRole(Long userId) {
        return this.getBaseMapper().deleteUserRole(userId);
    }

    @Override
    public int removeBatchUserRole(List<Long> userIds) {
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(SysUserRole::getUserId, userIds);
        return this.getBaseMapper().delete(queryWrapper);
    }
}
