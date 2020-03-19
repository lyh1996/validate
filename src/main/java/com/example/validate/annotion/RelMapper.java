package com.example.validate.annotion;

import java.lang.annotation.*;

/**
 * @author LYH
 * @date 2020/03/19 9:47
 */
@Target({ElementType.FIELD, ElementType.TYPE}) //Target 注解的使用域，FIELD表示使用在属性上面，TYPE表示使用在类上面
@Retention(RetentionPolicy.RUNTIME) //Retention 设置注解的生命周期 ，这里定义为RetentionPolicy.RUNTIME 非常关键
@Documented
public @interface RelMapper {
    //自定义属性
    String value() default "";

    String type() default "";  // value : status(标记属性值为Y/N的属性) / date(标记属性类型为时间)
}
