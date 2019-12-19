/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-03 17:40
 */
package com.example.validate.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LYH
 * @date 2019/12/03 17:40
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = -1961975713360512011L;
    protected int code;
    protected String message;
    protected Object data;

    public Result() {
    }

    public Result(ResultCode resultCode, String message, Object data) {
        this.code = resultCode.getCode();
        this.message = message;
        this.data = data;
    }

    public Result(ResultCode resultCode, String message) {
        this.code = resultCode.getCode();
        this.message = message;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(int code, Exception e) {
        this.code = code;
        this.message = e.getMessage();
    }

    public Result(int code, String message, Exception e) {
        this.code = code;
        this.message = message;
    }

    public Result(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMessage();
        this.data = data;
    }



    public Result(ResultCode msgEnum) {
        this.code = msgEnum.getCode();
        this.message = msgEnum.getMessage();
    }

    public static Result success() {
        return new Result(ResultCode.SUCCESS);
    }

    public static Result failure() {
        return new Result(ResultCode.FAIL);
    }

    public static Result success(Object data) {
        return new Result(data);
    }

    public static Result failure(String message) {
        return new Result(ResultCode.FAIL, message);
    }
}