/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-03-19 9:55
 */
package com.example.validate.entity;

import com.example.validate.annotion.RelMapper;
import lombok.Data;

/**
 * @author LYH
 * @date 2020/03/19 9:55
 */
@RelMapper
@Data
public class PersonDTO {
    /***
     * 对应注释的value值
     */
    @RelMapper(value = "perId")
    private String personId;

    /**
     * 字段名称相同可以不加注释但类上要有
     */
    private String email;

    /**
     * 字段名称相同可以不加value
     */
    @RelMapper
    private String perPhone;
}