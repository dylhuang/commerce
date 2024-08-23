package com.group.consult.commerce.configuration;


import com.group.consult.commerce.configuration.interceptors.SecurityAppInterceptor;
import com.group.consult.commerce.configuration.interceptors.SecurityInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @title: web配置
 * @description: 添加web mvc相关配置
 * @author: zl
 * @date: 2024-08-07
 */
@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SecurityInterceptor securityInterceptor;

    @Autowired
    private SecurityAppInterceptor appInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //安全拦截-后台接口
        registry.addInterceptor(securityInterceptor)
                .addPathPatterns("/api/sys/**")
                .excludePathPatterns("/api/sys/login","/api/sys/captcha/img");

        //安全拦截-移动端接口
        registry.addInterceptor(appInterceptor)
                .addPathPatterns("/app/**")
                .excludePathPatterns("/app/login","/app/register");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // 支持域
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
