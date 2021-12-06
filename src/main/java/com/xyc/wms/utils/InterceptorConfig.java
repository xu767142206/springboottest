package com.xyc.wms.utils;

import com.xyc.wms.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor()).addPathPatterns("/**")//全部路径
                .excludePathPatterns("/login")//排除不需要Token的路径
                .excludePathPatterns("/register");//排除不需要Token的路径
//                .excludePathPatterns("/v1/Login/Login");//开放登录路径
    }
}