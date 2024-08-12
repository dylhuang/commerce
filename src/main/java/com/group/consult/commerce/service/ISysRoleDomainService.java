package com.group.consult.commerce.service;

import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.RoleAddDTO;
import com.group.consult.commerce.model.dto.RoleEditDTO;
import com.group.consult.commerce.model.dto.RolePageListDTO;
import com.group.consult.commerce.model.vo.RoleDetailVO;
import com.group.consult.commerce.model.vo.RoleListVO;

import java.util.List;

public interface ISysRoleDomainService {

    /**
     * 添加角色
     * @param roleAddDTO
     * @return
     */
    Boolean add(RoleAddDTO roleAddDTO);

    /**
     * 编辑
     * @param roleEditDTO
     * @return
     */
    Boolean edit(RoleEditDTO roleEditDTO);

    /**
     * 删除
     * @param ids
     * @return
     */
    Boolean remove(List<Long>ids);

    /**
     * 获取详情
     * @param id
     * @return
     */
    RoleDetailVO fetchDetail(Long id);

    /**
     * 角色分页列表
     * @param dto
     * @return
     */
    PageResult<RoleListVO> pageList(RolePageListDTO dto);
}
