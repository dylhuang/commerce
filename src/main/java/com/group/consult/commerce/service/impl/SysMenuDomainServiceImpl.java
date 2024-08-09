package com.group.consult.commerce.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.consult.commerce.dao.entity.SysMenu;
import com.group.consult.commerce.model.dto.MenuAddDTO;
import com.group.consult.commerce.model.dto.MenuEditDTO;
import com.group.consult.commerce.persist.ISysMenuService;
import com.group.consult.commerce.service.ISysMenuDomainService;
import com.group.consult.commerce.utils.GerneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
