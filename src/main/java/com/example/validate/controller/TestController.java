/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-11-11 10:30
 */
package com.example.validate.controller;

import com.example.validate.entity.DateTimeDTO;
import com.example.validate.entity.DateTimeDTO2;
import com.example.validate.entity.ResponseResult;
import com.example.validate.entity.UserDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author LYH
 * @date 2019/11/11 10:30
 */
@RestController
@Validated
@ResponseResult
public class TestController {

    @RequestMapping(value = "/validate")
    public void test(@Validated @RequestBody UserDTO user) {
        System.out.println(user);

        System.out.println("校验通过");
    }

    @RequestMapping(value = "/getInfo")
    @ResponseResult
    public UserDTO getInfo() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("1134388790");
        userDTO.setName("hahhah");
        userDTO.setAge(0);
       return userDTO;
    }

    @RequestMapping("/test")
    public void test(@NotBlank(message = "用户名称不能为空") String uname) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(111111);
    }

    @ApiOperation("测试参数")
    @RequestMapping("/testDate")
    public DateTimeDTO2 testDate(@RequestBody DateTimeDTO dateTimeDTO) {
        System.out.println("传入的时间:"+dateTimeDTO.getAddTime());
        DateTimeDTO2 dateTimeDTO1 = new DateTimeDTO2();
        dateTimeDTO1.setAddTime(LocalDate.now());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateTimeDTO1;
    }

}