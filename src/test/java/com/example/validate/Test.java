/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-11-12 12:31
 */
package com.example.validate;

import com.example.validate.entity.UserDTO;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author LYH
 * @date 2019/11/12 12:31
 */
public class Test {
    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("123");
        userDTO.setName("hahh");

        UserDTO userDTO1 = null;
        String str = Optional.ofNullable(userDTO).map(UserDTO::getEmail).orElse("hhhh");
        System.out.println(str);

      /*  String str = Optional.ofNullable(userDTO).map(u -> u.getEmail()).orElse("哈哈");
        BigDecimal value = BigDecimal.valueOf(0.0).add(BigDecimal.valueOf(3.2));
        System.out.println(value);
        System.out.println(str);

        BigDecimal a = BigDecimal.valueOf(14);
        BigDecimal b = BigDecimal.valueOf(13);

        System.out.println(a.compareTo(b));*/
    }
}