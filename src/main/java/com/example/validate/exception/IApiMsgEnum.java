package com.example.validate.exception;

/**
 * @author LYH
 * @date 2020/01/17 10:02
 */
public interface IApiMsgEnum {

    /**
     * 获取code.
     *
     * @return
     */
    int getResCode();


    /**
     * 获取消息体.
     *
     * @return
     */
    String getResDes();

}