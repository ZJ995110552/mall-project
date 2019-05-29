package com.mercury.mallproject.common.utils;

import com.mercury.mallproject.common.exception.ErrorCode;
import com.mercury.mallproject.common.exception.ResultCode;

/**
 * 通用返回对象
 */
public class Result<T> {
    private long code;
    private String message;
    private T data;

    protected Result() {
    }

    protected Result(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> ok() {
        return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDescription(), null);
    }


    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> Result<T> ok(T data) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDescription(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> Result<T> ok(T data, String message) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> error() {
        return new Result<T>(ResultCode.UNKNOWN_SERVER_ERROR.getCode(), ResultCode.UNKNOWN_SERVER_ERROR.getDescription(), null);
    }


    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
//    public static <T> Result<T> error(ErrorCode errorCode) {
//        return new Result<T>(errorCode.getCode(), errorCode.getDescription(), null);
//    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> Result<T> error(String message) {
        return new Result<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> Result<T> validateFailed() {
        return error(ResultCode.VALIDATE_FAILED.getDescription());
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> Result<T> validateFailed(String message) {
        return new Result<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> Result<T> unauthorized(T data) {
        return new Result<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getDescription(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> Result<T> forbidden(T data) {
        return new Result<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getDescription(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
