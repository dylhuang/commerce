package com.group.consult.commerce.persist.impl;

import com.group.consult.commerce.dao.entity.SysMenu;
import com.group.consult.commerce.dao.mapper.SysMenuMapper;
import com.group.consult.commerce.persist.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    @Override
    public List<SysMenu> findByUserId(Long userId) {
        return getBaseMapper().findByUserId(userId);
    }

    @Override
    public List<SysMenu> findRoutersByUserId(Long userId) {
        return getBaseMapper().findRouterByUserId(userId);
    }
}
