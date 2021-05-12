/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-11-11 10:33
 */
package com.example.validate.entity;

import com.example.validate.controller.Create;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;

/**
 * @author LYH
 * @date 2019/11/11 10:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    /***
     * TODO
     *
     * @param null
     * @author LYH
     * @date 2019/11/11 10:34
     * @return {@link }
     */
    @NotBlank(message = "为空", groups = Create.class)
    @Email(message = "email格式不正确")
    private String email;

    private String name;

    private Integer age;

/*    @Valid
    @NotNull(message = "省份信息不能为空")
    private Province province;*/

    @Max(value = 100000, message = "最大100000")
    private Short num;

    @NotNull(message = "列表不能为空")
    @Size(min = 1, message = "列表为空")
    private List<Integer> list;
}