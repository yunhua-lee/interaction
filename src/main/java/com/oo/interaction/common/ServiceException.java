package com.oo.interaction.common;

/**
 * Service通过异常抛出各种错误码
 */
public class ServiceException extends Exception {
    private String errorCode;

    public ServiceException(String errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(ResultPair pair){
        super(pair.getMessage());
        this.errorCode = pair.getCode();
    }

    public String getErrorCode() {
        return errorCode;
    }
}
