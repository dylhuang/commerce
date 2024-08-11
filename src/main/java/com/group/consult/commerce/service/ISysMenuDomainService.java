package com.group.consult.commerce.service;

import com.group.consult.commerce.model.dto.MenuAddDTO;
import com.group.consult.commerce.model.dto.MenuEditDTO;

import java.util.List;

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

    /**
     * 删除菜单
     * @param ids
     * @return
     */
    Boolean remove(List<Long> ids);
}
