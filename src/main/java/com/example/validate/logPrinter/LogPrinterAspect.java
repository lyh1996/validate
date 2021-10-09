package com.example.validate.logPrinter;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 日志打印 切面类
 * <p>
 * 用于出入口方法的入参和返回值的标准log打印。
 * 若执行过程抛出异常，则打印入参和异常。
 *
 * @author 【千殇】（【罗玉华】qianshang.luo@tuya.com）
 * @since 2021/5/28 2:49 下午
 */
@Component
@Aspect
@Slf4j
public class LogPrinterAspect {

    // 如果想要 在类上加 然后使得方法全生效 请使用@within(com.tuya.yaochi.common.annotation.LogPrinter) 但是不建议
    @Pointcut("@annotation(com.tuya.chiyou.common.annotation.LogPrinter)")
    public void requestServer() {
    }

    @Around("requestServer()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        LogPrinterInfo logPrinterInfo = new LogPrinterInfo();
        logPrinterInfo.setClassMethod(String.format("[%s.%s]", proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName(),
                proceedingJoinPoint.getSignature().getName()));
        logPrinterInfo.setRequest(getRequestParamsByJoinPoint(proceedingJoinPoint));
        logPrinterInfo.setResponse(result);
        logPrinterInfo.setTimeCost(System.currentTimeMillis() - start);
        log.info(logPrinterInfo.toString());
        return result;
    }


    @AfterThrowing(pointcut = "requestServer()", throwing = "e")
    public void doAfterThrow(JoinPoint joinPoint, RuntimeException e) {
        LogPrinterInfo logPrinterInfo = new LogPrinterInfo();
        logPrinterInfo.setClassMethod(String.format("[%s.%s]", joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName()));
        logPrinterInfo.setRequest(getRequestParamsByJoinPoint(joinPoint));
        log.info(logPrinterInfo.toString(), e);
    }

    /**
     * <p> 获取异常时的参数
     *
     * @param joinPoint
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author [千殇] ([罗玉华]qianshang.luo@tuya.com)
     * @date 2021/5/28 3:18 下午
     */
    private Map<String, Object> getRequestParamsByJoinPoint(JoinPoint joinPoint) {
        //参数名
        String[] paramNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        //参数值
        Object[] paramValues = joinPoint.getArgs();

        return buildRequestParam(paramNames, paramValues);
    }

    /**
     * <p> 处理参数的类型 如果是文件类型只获取文件名称
     *
     * @param paramNames
     * @param paramValues
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author [千殇] ([罗玉华]qianshang.luo@tuya.com)
     * @date 2021/5/28 3:16 下午
     */
    private Map<String, Object> buildRequestParam(String[] paramNames, Object[] paramValues) {
        Map<String, Object> requestParams = new HashMap<>();
        for (int i = 0; i < paramNames.length; i++) {
            Object value = paramValues[i];

            //如果是文件对象
            if (value instanceof MultipartFile) {
                MultipartFile file = (MultipartFile) value;
                //获取文件名
                value = file.getOriginalFilename();
            }

            requestParams.put(paramNames[i], value);
        }

        return requestParams;
    }

}
