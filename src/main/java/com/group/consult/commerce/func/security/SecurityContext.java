package com.group.consult.commerce.func.security;

/**
 * @title: 安全上下文
 * @description: 安全上下文,持有登录信息
 * @author: zl
 * @date: 2024-08-11
 */
public class SecurityContext {

    /**
     * 已认证信息：如登录用户信息
     */
    private Object auth;

    public Object getAuth() {
        return auth;
    }

    public void setAuth(Object auth) {
        this.auth = auth;
    }
}
