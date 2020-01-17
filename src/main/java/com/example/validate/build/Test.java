/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-01-17 10:22
 */
package com.example.validate.build;

import com.example.validate.entity.AccountVO;


/**
 * @author LYH
 * @date 2020/01/17 10:22
 */
public class Test {
    public static void main(String[] args) {
        AccountVO accountVO = Builder.of(AccountVO::new).with(AccountVO::setAge, 12).with(AccountVO::setName, "lyh").build();

        System.out.println(accountVO);
    }
}