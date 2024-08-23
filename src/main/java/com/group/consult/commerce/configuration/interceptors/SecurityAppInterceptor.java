package com.group.consult.commerce.configuration.interceptors;

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
 *  @title: App端安全拦截器
 *  @description: 处理权限校验，token校验,处理App端
 *  @author: zl
 *  @date: 2024-08-07
 */
@Slf4j
@Component
public class SecurityAppInterceptor implements HandlerInterceptor {

    @Value("${commerce.jwt.app.key:}")
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
        String customerNo = jwtUtil.extractUsername(token);
        log.info("jwt [app] ===> customerNo={}", customerNo);
        if (customerNo == null || !jwtUtil.validateToken(token, customerNo)) {
            //401 JWT Token is invalid or expired
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        //2、填充登录用户信息
        AppUser appUser = new AppUser();
        appUser.setCustomerNo(Long.valueOf(customerNo));

        //3、存储登录信息
        SecurityContextHolder.getContext().setAuth(appUser);

        return true;
    }

}
