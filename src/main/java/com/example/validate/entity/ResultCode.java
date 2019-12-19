/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-03 17:22
 */
package com.example.validate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 返回状态码
 *
 * @author LYH
 * @date 2019/12/03 17:22
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    /*成功状态码*/
    SUCCESS(1, "成功"),
    /**
     * 失败.
     */
    FAIL(0, "失败"),

    /*参数错误1001-1999*/
    PARAM_IS_INVALID(1001, "参数无效"),

    PARAM_IS_BLANK(1002, "参数为空"),

    PARAM_TYPE_BIND_ERROR(1003, "参数类型错误"),

    PARAM_NOT_COMPLETE(1004, "参数缺失"),

    /*用户错误:2001-2999*/
    USER_NOT_LOGGED_IN(2001, "用户未登录，访问的路径需要验证，请登录"),

    USER_LOGIN_ERROR(2002, "账号不存在或密码错误"),

    USER_ACCOUNT_FORBIDDEN(2003, "账号已被禁用"),

    USER_NOT_EXIST(2004, "用户不存在"),

    USER_HAS_EXISTED(2005, "用户已存在");

    private final Integer code;
    private final String message;

    private static Map<Integer, ResultCode> enumMap = Stream.of(ResultCode.values()).collect(Collectors.toMap(ResultCode::getCode, Function.identity()));


    public static String getDesc(Integer code) {
        return enumMap.get(code).message;
    }

}