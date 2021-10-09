package com.example.validate.logPrinter;


import java.io.Serializable;
import java.util.StringJoiner;

/**
 * <p> 日志打印参数收集类
 *
 * @author 【千殇】（【罗玉华】qianshang.luo@tuya.com）
 * @since 2021/5/28 2:29 下午
 */
public class LogPrinterInfo implements Serializable {


    private static final long serialVersionUID = -4373613808134701145L;

    /**
     * 调用所处的类方法
     */
    private String classMethod;

    /**
     * 调用请求参数
     */
    private Object request;

    /**
     * 调用结果
     */
    private Object response;

    /**
     * 调用耗时
     */
    private Long timeCost;

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public Object getRequest() {
        return request;
    }

    public void setRequest(Object request) {
        this.request = request;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public Long getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(Long timeCost) {
        this.timeCost = timeCost;
    }

    @Override
    public String toString() {
        return classMethod + new StringJoiner(" ", " [", "]")
                .add("request=" + request)
                .add("response=" + response)
                .add("timeCost=" + timeCost);
    }
}
