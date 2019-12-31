package com.example.validate.annotion;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author LYH
 * @date 2019/12/31 14:30
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckTimeIntervalValidator.class)
@Documented
@Repeatable(CheckTimeInterval.List.class)
public @interface CheckTimeInterval {
    String startTime() default "from";

    String endTime() default "to";

    String message() default "{org.hibernate.validator.referenceguide.chapter06.checkCase.}" + "message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        CheckTimeInterval[] value();
    }
}
