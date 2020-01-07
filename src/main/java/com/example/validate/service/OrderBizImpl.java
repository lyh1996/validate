/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-01-07 16:31
 */
package com.example.validate.service;

import com.example.validate.annotion.NeedSetFiledValue;
import com.example.validate.entity.OrderDO;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LYH
 * @date 2020/01/07 16:31
 */
@Service
public class OrderBizImpl implements OrderBiz {


    @Override
    @NeedSetFiledValue
    public List<OrderDO> getOrderInfo() {
        List<OrderDO> list = Lists.newArrayList();

        OrderDO orderDO = new OrderDO();
        orderDO.setOrderId("lyh001");
        orderDO.setOrderName("牛头");
        orderDO.setOrderUserId(1);
        list.add(orderDO);

        OrderDO orderDO2 = new OrderDO();
        orderDO2.setOrderId("lyh002");
        orderDO2.setOrderName("牛肉");
        orderDO2.setOrderUserId(2);

        list.add(orderDO2);


        return list;
    }
}