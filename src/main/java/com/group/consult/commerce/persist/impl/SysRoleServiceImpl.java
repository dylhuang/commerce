package com.group.consult.commerce.persist.impl;

import com.group.consult.commerce.dao.entity.SysRole;
import com.group.consult.commerce.dao.mapper.SysRoleMapper;
import com.group.consult.commerce.persist.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Override
    public List<SysRole> listByUserId(Long userId) {
        return this.getBaseMapper().findByUserId(userId);
    }
}
