package com.group.consult.commerce.service;

import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.*;
import com.group.consult.commerce.model.vo.SysMenuDetailVO;
import com.group.consult.commerce.model.vo.SysMenuListVO;
import com.group.consult.commerce.model.vo.SysMenuPageListVO;
import com.group.consult.commerce.model.vo.SysMenuTreeListVO;

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

    /**
     * 详情
     * @param id
     * @return
     */
    SysMenuDetailVO fetchDetail(Long id);

    /**
     * 列表，不分页
     * @param dto
     * @return
     */
    List<SysMenuListVO> list(SysMenuListDTO dto);

    /**
     * 列表，分页
     * @param dto
     * @return
     */
    PageResult<SysMenuPageListVO> pageList(SysMenuPageListDTO dto);

    /**
     * 菜单树
     * @param dto
     * @return
     */
    List<SysMenuTreeListVO> treeList(SysMenuTreeListDTO dto);
}
