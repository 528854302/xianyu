package com.xianyu.dto;

import java.io.Serializable;
import java.util.List;

public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T returnData;

    public Result() {
        this.code = 200;
        this.message = "操作成功";
    }

    public Result(T data) {
        this.code = 200;
        this.returnData = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.returnData = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getReturnData() {
        return returnData;
    }

    public void setReturnData(T returnData) {
        this.returnData = returnData;
    }
}
