/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-09-17 15:46
 */
package com.example.validate.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author LYH
 * @date 2020/09/17 15:46
 */
@Data
public class DataTimeTestDTO {

    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime now;

    //@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date updateTime;
}