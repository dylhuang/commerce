package com.group.consult.commerce.configuration.interceptors;

import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.func.security.SecurityContextHolder;
import com.group.consult.commerce.model.ApiCodeEnum;
import lombok.Data;

/**
 * @title: 登录用户信息
 * @description: 登录用户信息，移动端
 * @author: zl
 * @date: 2024-08-11
 */
@Data
public class AppUser {

    /**
     * 会员编号
     */
    private Long customerNo;

    /**
     * 获取当前登录对象
     * @return
     */
    public static AppUser getLoginSubject() {
        Object obj = SecurityContextHolder.getContext().getAuth();
        if (obj instanceof AppUser) {
            return (AppUser) obj;
        }

        throw new BusinessException(ApiCodeEnum.NO_LOGIN_ERROR);
    }

}
