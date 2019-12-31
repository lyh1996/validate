/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-31 14:32
 */
package com.example.validate.annotion;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author LYH
 * @date 2019/12/31 14:32
 */
public class CheckTimeIntervalValidator implements ConstraintValidator<CheckTimeInterval, Object> {

    private String startTime;

    private String endTime;

    @Override
    public void initialize(CheckTimeInterval constraint) {
        this.startTime = constraint.startTime();
        this.endTime = constraint.endTime();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(value)) {
            return true;
        }
        BeanWrapper beanWrapper = new BeanWrapperImpl(value);
        Object start = beanWrapper.getPropertyValue(startTime);
        Object end = beanWrapper.getPropertyValue(endTime);

        if (Objects.isNull(start) || Objects.isNull(end)) {
            return true;
        }

        int result = ((LocalDateTime) end).compareTo((LocalDateTime) start);
        if (result >= 0) {
            return true;
        }
        return false;
    }

}