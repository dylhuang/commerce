package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.consult.commerce.dao.entity.SysRoleMenu;
import com.group.consult.commerce.dao.mapper.SysRoleMenuMapper;
import com.group.consult.commerce.persist.ISysRoleMenuService;
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
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {
    @Override
    public Long countUsedMenu(List<Long> menuIds) {
        QueryWrapper<SysRoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(SysRoleMenu::getMenuId, menuIds);
        return this.count(queryWrapper);
    }
}
