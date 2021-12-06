package com.xyc.wms.utils;

public enum Code {
    Sucess(200, "ok"),
    CLIENT_ERROR(400, "客户端错误"),
    VALID_ERROR(400, "参数验证错误"),
    SEVERICE_ERROR(500, "服务器错误");

    public int code;
    public String msg;

    Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
