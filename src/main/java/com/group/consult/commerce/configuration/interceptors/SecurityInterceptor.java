package com.group.consult.commerce.configuration.interceptors;

import com.group.consult.commerce.dao.entity.SysUser;
import com.group.consult.commerce.func.security.SecurityContextHolder;
import com.group.consult.commerce.persist.ISysUserService;
import com.group.consult.commerce.service.ISysLoginDomainService;
import com.group.consult.commerce.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 *  @title: 安全拦截器
 *  @description: 处理权限校验，token校验,处理pc端
 *  @author: zl
 *  @date: 2024-08-07
 */
@Slf4j
@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Value("${commerce.jwt.pc.key:}")
    private String jwtKey;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysLoginDomainService loginDomainService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        JwtUtil jwtUtil = new JwtUtil(jwtKey);

        //1、token校验
        if (token == null || !token.startsWith("Bearer ")) {
            //401 token未传入
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        token = token.substring(7);
        String username = jwtUtil.extractUsername(token);
        log.info("jwt [manage]===> username={}", username);
        if (username == null || !jwtUtil.validateToken(token, username)) {
            //401 JWT Token is invalid or expired
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        //2、填充登录用户信息
        SysUser sysUser = userService.findByUserName(username);
        if (sysUser == null) {
            //401 无登录用户信息
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setUserName(username);
        loginUser.setUserId(sysUser.getId());
        loginUser.setPermissionCodes(loginDomainService.getPermissionCodes(sysUser.getId()));

        //3、存储登录信息
        SecurityContextHolder.getContext().setAuth(loginUser);

        return true;
    }

}
