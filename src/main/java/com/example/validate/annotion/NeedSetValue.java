package com.example.validate.annotion;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lyh
 * @ClassName: NeedSetValue
 * @Description: 利用注解+aop实现关联查询
 * @date 2020/01/07 16:13
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedSetValue {
    // 调用的类
    Class<?> beanClass();

    // 传入的参数
    String params();

    // 调用类中的方法
    String method();

    // 返回的参数值
    String targetFiled();
}
