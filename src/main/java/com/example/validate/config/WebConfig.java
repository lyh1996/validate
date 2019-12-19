/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-04 9:49
 */
package com.example.validate.config;

import com.example.validate.handler.ResponseResultInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *添加拦截器
 * @author LYH
 * @date 2019/12/04 9:49
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private ResponseResultInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，配置拦截地址
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }
}