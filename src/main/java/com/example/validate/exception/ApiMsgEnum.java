package com.example.validate.exception;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 0000-0999表示系统级错误代码
 * 1000-1999表示公用体系错误代码
 * 2000-2999表示内容体系错误代码
 * 3000-3999表示用户体系错误代码
 */
public enum ApiMsgEnum implements IApiMsgEnum {

    /**
     * 正确.
     */
    OK(1, "OK"),

    /**
     * 失败.
     */
    FAIL(0, "FAIL"),

    /**
     * 登录失败.
     */
    LOGIN_FAIL(-1, "Login fail"),

    /**
     * 400.
     */
    BAD_REQUEST(400, "Bad Request"),

    /**
     * 404.
     */
    NOT_FOUND(404, "Not Found"),

    /**
     * 401
     */
    UNAUTHORIZED(401, "Unauthorized"),

    /**
     * 403.
     */
    FORBIDDEN(403, "Forbidden"),

    /**
     * 500.
     */
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    /**
     * 502.
     */
    BAD_GATEWAY(502, "Bad Gateway"),

    /**
     * 503.
     */
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),

    /**
     * 504.
     */
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),

    //----------------------------------------------------1000-1999表示公用体系错误代码----------------------------------------------------

    /**
     * 短信验证码过期.
     */
    SMS_CODE_EXPIRE(1000, "短信验证码过期"),

    /**
     * 短信验证码错误.
     */
    SMS_CODE_ERROR(1001, "短信验证码错误"),

    SMS_CODE_NOT_EMPTY(1012, "短信验证码不能为空"),


    IMG_CODE_EXPIRE(1010, "验证码过期"),

    IMG_CODE_ERROR(1011, "验证码错误"),

    IMG_CODE_NOT_EMPTY(1012, "验证码不能为空"),


    /**
     * token 不能为空.
     */
    TOKEN_NOT_EMPTY(1020, "token不能为空"),
    ;


    private int resCode;
    private String resDes;
    public static Map<Integer, String> apiMsgMap = new HashMap<Integer, String>();

    static {
        apiMsgMap = getAll();
    }

    ApiMsgEnum(int code, String msg) {
        this.resCode = code;
        this.resDes = msg;
    }

    private static Map<Integer, String> getAll() {
        Map<Integer, String> retMap = new LinkedHashMap<Integer, String>();
        ApiMsgEnum[] enumArr = ApiMsgEnum.values();
        for (ApiMsgEnum aEnum : enumArr) {
            retMap.put(aEnum.getResCode(), aEnum.getResDes());
        }
        return retMap;
    }

    @Override
    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    @Override
    public String getResDes() {
        return resDes;
    }

    public void setResDes(String resDes) {
        this.resDes = resDes;
    }


}


