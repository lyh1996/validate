/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-01-07 16:15
 */
package com.example.validate.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LYH
 * @date 2020/01/07 16:15
 */
@Data
public class OrderUserDO implements Serializable {


    private static final long serialVersionUID = -8888357380127864268L;

    private Integer UserId;

    private String OrderUserName;
}