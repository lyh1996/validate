/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-11-11 10:30
 */
package com.example.validate.controller;

import com.alibaba.fastjson.JSON;
import com.example.validate.entity.*;
import com.example.validate.service.TestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * @author LYH
 * @date 2019/11/11 10:30
 */
@RestController
@Validated
@ResponseResult
public class TestController {

    @Autowired
    TestService service;

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
        System.out.println("传入的时间:" + dateTimeDTO.getAddTime());
        DateTimeDTO2 dateTimeDTO1 = new DateTimeDTO2();
        dateTimeDTO1.setAddTime(LocalDate.now());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateTimeDTO1;
    }

    @ApiOperation("自定义校验参数的开始和结束时间的准确性")
    @RequestMapping("/testTime")
    public ResultBody testTime(@Valid @RequestBody TimeDTO timeDTO) {
        System.out.println(timeDTO);

        return ResultBody.success();
    }


    @PostMapping("/custom")
    public Object custom(@RequestBody @Validated CustomDTO customDTO) {
        return customDTO;
    }

    @PostMapping("/testCheckParam")
    public void testCheckParam(AccountVO accountVO) {

        System.out.println("参数校验通过" + JSON.toJSONString(accountVO));
        //AccountVO accountVO = new AccountVO();
        //accountVO.setName("");
        //accountVO.setAge(0);
        service.testAccountVO(accountVO);
    }


}