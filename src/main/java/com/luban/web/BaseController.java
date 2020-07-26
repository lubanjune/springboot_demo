package com.luban.web;

public interface BaseController {

    default WebResult ok() {
        return new WebResult().setMsg("success");
    }

    default WebResult ok(Object data) {
        return new WebResult().setData(data);
    }

    default WebResult defaultErr() {
        return new WebResult().setCode(-1);
    }

    default WebResult defalutErr(String msg) {
        return new WebResult().setData(-1).setMsg(msg);
    }
}
