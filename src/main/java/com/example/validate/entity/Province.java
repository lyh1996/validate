/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-05 9:30
 */
package com.example.validate.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author LYH
 * @date 2019/12/05 9:30
 */
@Data
public class Province {

    @NotBlank(message = "省份名称不能为空")
    private String provinceName;
}