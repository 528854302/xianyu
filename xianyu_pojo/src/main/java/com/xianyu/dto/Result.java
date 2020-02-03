package com.xianyu.dto;

import java.io.Serializable;
import java.util.List;

public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private List<T> data;

    public Result(Integer code) {
        this.code = code;
    }


    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
