package com.group.consult.commerce.configuration.interceptors;

import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.func.security.SecurityContextHolder;
import com.group.consult.commerce.model.ApiCodeEnum;
import lombok.Data;

import java.util.List;

/**
 * @title: 登录用户信息
 * @description: 登录用户信息，pc端用户信息
 * @author: zl
 * @date: 2024-08-11
 */
@Data
public class LoginUser {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 拥有的权限列表
     */
    private List<String> permissionCodes;

    /**
     * 获取当前登录对象
     * @return
     */
    public static LoginUser getLoginSubject() {
        Object obj = SecurityContextHolder.getContext().getAuth();
        if (obj instanceof  LoginUser ) {
            return (LoginUser) obj;
        }

        throw new BusinessException(ApiCodeEnum.NO_LOGIN_ERROR);
    }

}
