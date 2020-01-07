/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-01-07 16:08
 */
package com.example.validate.entity;

import com.example.validate.annotion.NeedSetValue;
import com.example.validate.service.UserBiz;
import lombok.Data;

import java.io.Serializable;

/**
 * 订单详情
 *
 * @author LYH
 * @date 2020/01/07 16:08
 */
@Data
public class OrderDO implements Serializable {

    private static final long serialVersionUID = 7732082304665622295L;

    private String orderId;

    private String orderName;

    private Integer orderUserId;

    @NeedSetValue(beanClass = UserBiz.class, params = "orderUserId", method = "getUserInfoById", targetFiled = "OrderUserName")
    private String orderUserName;
}