package com.example.validate.entity;

import java.lang.annotation.*;

/**
 * @author LYH
 * @date 2019/12/03 17:54
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
