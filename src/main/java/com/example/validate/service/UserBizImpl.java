/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-01-07 16:13
 */
package com.example.validate.service;

import com.example.validate.entity.OrderUserDO;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author LYH
 * @date 2020/01/07 16:13
 */
@Service
public class UserBizImpl implements UserBiz {

    private static HashMap<Integer, String> userHashMap = Maps.newHashMap();

    static {
        userHashMap.put(1, "lyh");
        userHashMap.put(2, "lyh2");
    }

    @Override
    public OrderUserDO getUserInfoById(Integer userId) {
        OrderUserDO orderUserDO = new OrderUserDO();
        orderUserDO.setUserId(userId);
        orderUserDO.setOrderUserName(userHashMap.get(userId));
        return orderUserDO;
    }
}