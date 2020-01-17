/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-01-16 18:36
 */
package com.example.validate.service;

import com.alibaba.fastjson.JSON;
import com.example.validate.annotion.CheckParam;
import com.example.validate.entity.AccountVO;
import org.springframework.stereotype.Service;

/**
 * @author LYH
 * @date 2020/01/16 18:36
 */
@Service
public class TestService {

    @CheckParam("name:名字不能为空")
    public void testAccountVO(AccountVO accountVO) {
        System.out.println("参数校验通过" + JSON.toJSONString(accountVO));
    }
}