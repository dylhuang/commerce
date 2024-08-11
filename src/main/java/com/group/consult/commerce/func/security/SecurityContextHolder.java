package com.group.consult.commerce.func.security;

import org.apache.poi.ss.formula.functions.T;

/**
 * @title: 安全上下文持有者
 * @description: 持有上下文，负责管理上下文生命周期，仅拥有一个默认实现，不支持扩展
 * @author: zl
 * @date: 2024-08-11
 */
public class SecurityContextHolder {

    private static final ThreadLocal<SecurityContext> securityContextThreadLocal = new ThreadLocal<>();

    public static void clearContext() {
        securityContextThreadLocal.remove();
    }

    public static SecurityContext getContext() {
        SecurityContext securityContext = securityContextThreadLocal.get();
        if (securityContext == null) {
            //始终保持有一个上下文
            securityContext = new SecurityContext();
            securityContextThreadLocal.set(securityContext);
        }
        return securityContext;
    }

    public static void setContext(SecurityContext context) {
        securityContextThreadLocal.set(context);
    }

}
