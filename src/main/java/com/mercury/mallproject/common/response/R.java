package com.mercury.mallproject.common.response;

import com.mercury.mallproject.common.enumresource.ResultCodeEnum;

/**
 * 通用返回对象
 */
public class R<T> {
    private long code;
    private String message;
    private T data;

    protected R() {
    }

    protected R(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> R<T> ok() {
        return new R<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getDescription(), null);
    }


    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> R<T> ok(T data) {
        return new R<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getDescription(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> R<T> ok(T data, String message) {
        return new R<T>(ResultCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> R<T> error() {
        return new R<T>(ResultCodeEnum.UNKNOWN_SERVER_ERROR.getCode(), ResultCodeEnum.UNKNOWN_SERVER_ERROR.getDescription(), null);
    }


    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
//    public static <T> R<T> error(ErrorCode errorCode) {
//        return new R<T>(errorCode.getCode(), errorCode.getDescription(), null);
//    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> R<T> error(String message) {
        return new R<T>(ResultCodeEnum.FAILED.getCode(), message, null);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> R<T> validateFailed() {
        return error(ResultCodeEnum.VALIDATE_FAILED.getDescription());
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> R<T> validateFailed(String message) {
        return new R<T>(ResultCodeEnum.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> R<T> unauthorized(T data) {
        return new R<T>(ResultCodeEnum.UNAUTHORIZED.getCode(), ResultCodeEnum.UNAUTHORIZED.getDescription(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> R<T> forbidden(T data) {
        return new R<T>(ResultCodeEnum.FORBIDDEN.getCode(), ResultCodeEnum.FORBIDDEN.getDescription(), data);
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
