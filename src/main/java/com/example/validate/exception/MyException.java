package com.example.validate.exception;

/**
 * @author LYH
 * @date 2020/01/17 9:59
 */
public interface MyException {
    int getCode();

    String getMessage();

    Throwable getThrowable();
}