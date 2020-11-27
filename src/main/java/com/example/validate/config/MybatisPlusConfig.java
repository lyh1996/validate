/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-11-27 11:21
 */
package com.example.validate.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.example.validate.service.BaseSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LYH
 * @date 2020/11/27 11:21
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     *
     * @param
     * @return {@link PaginationInnerInterceptor}
     * @author LYH
     * @date 2020/11/27 11:22
     */
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        return new PaginationInnerInterceptor();
    }

    @Bean
    public BaseSqlInjector baseSqlInjector() {
        return new BaseSqlInjector();
    }
}