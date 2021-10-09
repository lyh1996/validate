/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-01-07 16:10
 */
package com.example.validate.controller;

import com.example.validate.entity.OrderDO;
import com.example.validate.service.OrderBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LYH
 * @date 2020/01/07 16:10
 */
@Validated
@RestController
public class OrderController extends AbstractController {

    @Autowired
    OrderBiz orderBiz;

    @RequestMapping("/getOrderInfo")
    public List<OrderDO> getOrderInfo() {
        return orderBiz.getOrderInfo();
    }
}