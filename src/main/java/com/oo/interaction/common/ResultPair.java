package com.oo.interaction.common;

/**
 * Service方法的结果对象
 */
public class ResultPair {
    private final String code;
    private final String message;

    public ResultPair(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
