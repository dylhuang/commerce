package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.SysUserRole;
import com.group.consult.commerce.dao.mapper.SysUserRoleMapper;
import com.group.consult.commerce.persist.ISysUserRoleService;
import org.springframework.stereotype.Service;

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
}
