package com.example.validate.logPrinter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p> 该注解 用于 收集 调用的请求参数以及返回参数等信息日志的打印
 *
 * @author 【千殇】（【罗玉华】qianshang.luo@tuya.com）
 * @since 2021/5/28 2:14 下午
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LogPrinter {

    /**
     * value : 用于日志方法前缀说明 暂时没有启用
     */
    String logPrefix() default "";

}
