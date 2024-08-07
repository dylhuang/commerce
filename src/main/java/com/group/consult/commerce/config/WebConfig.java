package com.group.consult.commerce.config;


import com.group.consult.commerce.config.interceptors.SecurityInterceptor;
import com.group.consult.commerce.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  @title: web配置
 *  @description: 添加web mvc相关配置
 *  @author: zl
 *  @date: 2024-08-07
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SecurityInterceptor securityInterceptor;

    @Value("${commerce.jwt.key:}")
    private String jwtKey;

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil(jwtKey);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //拦截所有，排除静态资源以及测试资源
        registry.addInterceptor(securityInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**","/test/**","/login");
    }
}
