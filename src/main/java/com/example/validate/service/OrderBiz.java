package com.example.validate.service;

import com.example.validate.entity.OrderDO;

import java.util.List;

/**
 * @author LYH
 * @date 2020/01/07 16:30
 */
public interface OrderBiz {

    /***
     * 获取订单信息
     *
     * @param
     * @author LYH
     * @date 2020/1/7 16:32
     * @return {@link OrderDO}
     */
    List<OrderDO> getOrderInfo();
}
