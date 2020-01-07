package com.example.validate.annotion;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Lyh
 * @ClassName: NeedSetFiledValue
 * @Description: 利用注解+aop实现关联查询
 * @date 2020/01/07 16:20
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedSetFiledValue {
}

