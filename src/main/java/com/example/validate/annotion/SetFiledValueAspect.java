package com.example.validate.annotion;


import com.example.validate.component.BeanUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author lyh
 * @ClassName: SetFiledValueAspect
 * @Description: 在不实用关联查询时，如果更优雅的实现两个表的查询并组合在一起返回。
 * @date 2020/01/07 16:12
 */
@Component
@Aspect
public class SetFiledValueAspect {

    @Autowired
    private BeanUtil beanUtil;

    /**
     * 利用注解+aop实现关联查询
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@annotation(com.example.validate.annotion.NeedSetFiledValue)")
    public Object doSetFieldValue(ProceedingJoinPoint pjp) throws Throwable {
        Object res = pjp.proceed();
        if (res instanceof Collection) {
            this.beanUtil.setValue((Collection) res);
        }
        return res;
    }
}

