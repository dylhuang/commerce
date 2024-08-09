package com.group.consult.commerce.service;

import com.group.consult.commerce.model.dto.MenuAddDTO;
import com.group.consult.commerce.model.dto.MenuEditDTO;

public interface ISysMenuDomainService {

    /**
     * 添加菜单
     * @param menuAddDTO
     * @return
     */
    Boolean addMenu(MenuAddDTO menuAddDTO);

    /**
     * 编辑菜单
     * @param menuEditDTO
     * @return
     */
    Boolean editMenu(MenuEditDTO menuEditDTO);
}
