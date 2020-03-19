/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-03-19 9:50
 */
package com.example.validate;

import com.example.validate.build.Builder;
import com.example.validate.entity.PersonDTO;
import com.example.validate.entity.PersonEntity;
import com.example.validate.util.RelationMapperUtils;

/**
 * @author LYH
 * @date 2020/03/19 9:50
 */
public class TestDTOtoEntity {

    public static void main(String[] args) throws Exception {
        // entity 转 DTO
        //Entity数据转成Dto数据集
        PersonEntity person = Builder.of(PersonEntity::new).with(PersonEntity::setPerId, "1")
                .with(PersonEntity::setEmail, "1134388790@qq.com")
                .with(PersonEntity::setPerPhone, "15874746591").build();
        PersonDTO p = (PersonDTO) RelationMapperUtils.entryAndDtoMapper(person, new PersonDTO());

        System.out.println(p);
        //Dto数据转成Entity数据
        PersonEntity personEntity = (PersonEntity) RelationMapperUtils.entryAndDtoMapper(new PersonEntity(), p, false);
        personEntity.setPerId("2");

        System.out.println(personEntity);
    }
}