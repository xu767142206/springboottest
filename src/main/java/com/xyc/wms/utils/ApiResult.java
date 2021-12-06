package com.xyc.wms.utils;


public class ApiResult<T> {
    public Integer code;

    public String message;

    public T data;

    public ApiResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResult(Code code, T data) {
        this.code = code.getCode();
        this.message = code.getMsg();
        this.data = data;
    }

    public static <T> ApiResult<T> getInstance(Code code, T data) {
        return new ApiResult<T>(code, data);
    }

    public ApiResult(T data) {
        this(1000, "success", data);
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return data;
    }
}
