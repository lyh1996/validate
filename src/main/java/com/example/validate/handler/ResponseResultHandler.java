/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-03 18:04
 */
package com.example.validate.handler;

import com.example.validate.entity.ResponseResult;
import com.example.validate.entity.Result;
import com.example.validate.entity.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LYH
 * @date 2019/12/03 18:04
 */
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    // 标记名称
    public static final String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";

    //是否请求 包含了包装注解 标记  ，没有的话直接返回 不需要重写返回体
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        // 判断请求 是否包含包装的标记
        ResponseResult responseResult = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANN);
        return responseResult == null ? false : true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
       log.info("进入 返回体  重写格式  处理中，，，，，");
       //处理异常
        //如果body为空，返回默认信息
        if (body == null) {
            return Result.success();
        }
        //匹配ResponseResult
        if (body instanceof ResultBody) {
            return body;
        }

        /**
         * 其他情况直接将返回的信息直接塞在data中
         */
        return Result.success(body);
    }
}