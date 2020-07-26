package com.luban.web;

public class WebResult {

    private int code=0;

    private String msg;

    private Object data;

    public int getCode() {
        return code;
    }

    public WebResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public WebResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public WebResult setData(Object data) {
        this.data = data;
        return this;
    }
}
