/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-31 14:51
 */
package com.example.validate.entity;

import com.example.validate.annotion.CheckTimeInterval;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author LYH
 * @date 2019/12/31 14:51
 */
@Data
@CheckTimeInterval(startTime = "startTime", endTime = "endTime", message = "发放开始时间不能大于发放结束时间")
public class TimeDTO implements Serializable {

    /***
     @JsonFormat 表示的是指定格式返回给前端
     @DateTimeFormat 表示对前端传过来的日期进行格式化
     */

    private static final long serialVersionUID = 2226296721263586955L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
}