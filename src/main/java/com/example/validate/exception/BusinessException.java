package com.example.validate.exception;

/**
 * 业务逻辑异常。
 * <p>处理自身业务逻辑判断/捕获的异常.</p>
 *
 * @author Administrator
 */
public class BusinessException extends RuntimeException implements MyException {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2332608236621015982L;
    private int code;
    private Throwable throwable;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Throwable cause) {
        super(cause);
        this.throwable = cause;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.throwable = cause;
    }

    public BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.throwable = cause;
    }


    public BusinessException(IApiMsgEnum apiMsgEnum, String message) {
        super(message);
        this.code = apiMsgEnum.getResCode();
    }

    public BusinessException(IApiMsgEnum apiMsgEnum) {
        super(apiMsgEnum.getResDes());
        this.code = apiMsgEnum.getResCode();
    }


    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public Throwable getThrowable() {
        return throwable;
    }
}

