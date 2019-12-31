/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-18 9:36
 */
package com.example.validate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author LYH
 * @date 2019/12/18 9:36
 */
@Data
public class DateTimeDTO2 {

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone = "GMT+8")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate addTime;
}