package com.group.consult.commerce.service;

import com.group.consult.commerce.model.dto.UserAddDTO;
import com.group.consult.commerce.model.dto.UserEditDTO;

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
}
