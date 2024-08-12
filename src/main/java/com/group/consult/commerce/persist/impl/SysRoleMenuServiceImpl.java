package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.SysMenu;
import com.group.consult.commerce.dao.entity.SysRoleMenu;
import com.group.consult.commerce.dao.mapper.SysRoleMenuMapper;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.persist.ISysRoleMenuService;
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
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {
    @Override
    public Long countUsedMenu(List<Long> menuIds) {
        QueryWrapper<SysRoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(SysRoleMenu::getMenuId, menuIds);
        return this.count(queryWrapper);
    }

    @Override
    public void bindRoleMenu(Long roleId, List<Long> menuIds) {
        GerneralUtil.check(roleId == null, ApiCodeEnum.ROLE_ID_NOT);
        if (menuIds != null && menuIds.size() > 0) {
            List<SysRoleMenu> roleMenus = new ArrayList<>();
            for (Long menuId : menuIds) {
                SysRoleMenu roleMenu = new SysRoleMenu();
                roleMenu.setRoleId(roleId);
                roleMenu.setMenuId(menuId);
                roleMenus.add(roleMenu);
            }
            Boolean res = this.saveBatch(roleMenus, Integer.MAX_VALUE);
            GerneralUtil.assertCheck(res, ApiCodeEnum.ROLE_MENU_BIND_ERROR);
        }
    }

    @Override
    public int removeBatchRoleMenu(List<Long> roleIds) {
        QueryWrapper<SysRoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(SysRoleMenu::getRoleId, roleIds);
        return this.getBaseMapper().delete(queryWrapper);
    }

    @Override
    public List<SysMenu> listMenuByRoleId(Long roleId) {
        return this.getBaseMapper().queryMenuByRoleId(roleId);
    }
}
