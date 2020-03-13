package com.iot.common;

import lombok.Data;

/**
 * @author weiyunyun
 * @date 2020/2/13 12:57
 */
@Data
public class Result<T> {

    private String code;

    private String msg;

    private T data;

    private Result() {
    }

    private Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public static Result success() {
        return new Result(ResultCode.SUCCESS);
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result failure(ResultCode resultCode) {
        return new Result(resultCode);
    }

    public static Result<String> failure(ResultCode resultCode, String paramMsg) {
        Result<String> result = new Result<>(resultCode);
        result.setData(paramMsg);
        return result;
    }

    public static Result<String> failure(String code, String msg, String paramMsg) {
        Result<String> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(paramMsg);
        return result;
    }
}

