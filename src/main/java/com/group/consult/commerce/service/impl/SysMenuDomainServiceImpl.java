package com.group.consult.commerce.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.group.consult.commerce.dao.entity.SysMenu;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.*;
import com.group.consult.commerce.model.vo.SysMenuDetailVO;
import com.group.consult.commerce.model.vo.SysMenuListVO;
import com.group.consult.commerce.model.vo.SysMenuPageListVO;
import com.group.consult.commerce.model.vo.SysMenuTreeListVO;
import com.group.consult.commerce.persist.ISysMenuService;
import com.group.consult.commerce.persist.ISysRoleMenuService;
import com.group.consult.commerce.service.ISysMenuDomainService;
import com.group.consult.commerce.utils.GerneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: 标题
 * @description: 描述
 * @author: zl
 * @date: 2024-08-09
 */
@Service
public class SysMenuDomainServiceImpl implements ISysMenuDomainService {

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private ISysRoleMenuService roleMenuService;

    @Override
    public Boolean addMenu(MenuAddDTO menuAddDTO) {
        SysMenu menu = new SysMenu();
        BeanUtil.copyProperties(menuAddDTO, menu);
        return menuService.save(menu);
    }

    @Override
    public Boolean editMenu(MenuEditDTO menuEditDTO) {
        SysMenu menu = new SysMenu();
        BeanUtil.copyProperties(menuEditDTO, menu);
        menu.setId(Long.valueOf(menuEditDTO.getId()));
        return menuService.updateById(menu);
    }

    @Override
    public Boolean remove(List<Long> ids) {
        long childsNum = menuService.countChilds(ids);
        GerneralUtil.check(childsNum > 0, ApiCodeEnum.HAS_CHILD_MENU);
        long useNum = roleMenuService.countUsedMenu(ids);
        GerneralUtil.check(useNum > 0, ApiCodeEnum.USING_MENU);

        return menuService.removeByIds(ids);
    }

    @Override
    public SysMenuDetailVO fetchDetail(Long id) {
        SysMenu menu = menuService.getById(id);
        if (menu == null) {
            return null;
        }
        SysMenuDetailVO menuDetailVO = new SysMenuDetailVO();
        BeanUtil.copyProperties(menu, menuDetailVO);

        return menuDetailVO;

    }

    @Override
    public List<SysMenuListVO> list(SysMenuListDTO dto) {
        return menuService.listNoPage(dto);
    }

    @Override
    public PageResult<SysMenuPageListVO> pageList(SysMenuPageListDTO dto) {
        return menuService.pageList(dto);
    }

    @Override
    public List<SysMenuTreeListVO> treeList(SysMenuTreeListDTO dto) {
        return menuService.treeList(dto);
    }
}
