package com.group.consult.commerce.service;

import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.UserAddDTO;
import com.group.consult.commerce.model.dto.UserEditDTO;
import com.group.consult.commerce.model.dto.UserListDTO;
import com.group.consult.commerce.model.vo.UserDetailVO;
import com.group.consult.commerce.model.vo.UserListVO;

import java.util.List;

/**
 * @title: 用户管理
 * @description: 用户管理
 * @author: zl
 * @date: 2024-08-08
 */
public interface ISysUserDomainService {

    /**
     * 添加用户
     * @param userAddDTO
     * @return
     */
    Boolean add(UserAddDTO userAddDTO);

    /**
     * 编辑用户
     * @param userEditDTO
     * @return
     */
    Boolean edit(UserEditDTO userEditDTO);

    /**
     * 删除用户
     * @param ids
     * @return
     */
    Boolean remove(List<Long> ids);

    /**
     * 用户详情
     * @param id
     * @return
     */
    UserDetailVO fetchDetail(Long id);

    /**
     * 用户分页查询
     * @param dto
     * @return
     */
    PageResult<UserListVO> pageList(UserListDTO dto);
}
