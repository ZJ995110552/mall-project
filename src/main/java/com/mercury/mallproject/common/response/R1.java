package com.mercury.mallproject.common.response;

import com.mercury.mallproject.common.enumresource.ResultCodeEnum;

import java.util.HashMap;

/**
 * 操作消息提醒
 * 
 * @author ruoyi
 */
public class R1 extends HashMap<String, Object>
{
    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 Message 对象
     */
    protected R1()
    {
    }

    /**
     * 返回错误消息
     * 
     * @return 错误消息
     */
    public static R1 error()
    {
        return error(ResultCodeEnum.FAILED.getCode(), ResultCodeEnum.FAILED.getDescription());
    }

    /**
     * 返回错误消息
     * 
     * @param msg 内容
     * @return 错误消息
     */
    public static R1 error(String msg)
    {
        return error(ResultCodeEnum.FAILED.getCode(), msg);
    }

    /**
     * 返回错误消息
     * 
     * @param code 错误码
     * @param msg 内容
     * @return 错误消息
     */
    public static R1 error(Integer code, String msg)
    {
        R1 json = new R1();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }

    /**
     * 返回成功消息
     * 
     * @param msg 内容
     * @return 成功消息
     */
    public static R1 ok(String msg)
    {
        R1 json = new R1();
        json.put("msg", msg);
        json.put("code", ResultCodeEnum.SUCCESS.getCode());
        return json;
    }
    
    /**
     * 返回成功消息
     * 
     * @return 成功消息
     */
    public static R1 ok()
    {
        return R1.ok(ResultCodeEnum.SUCCESS.getDescription());
    }

    /**
     * 返回成功消息
     * 
     * @param key 键值
     * @param value 内容
     * @return 成功消息
     */
    @Override
    public R1 put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }


    /**
     * 参数验证失败返回结果
     */
    public static R1 validateFailed() {
        return error(ResultCodeEnum.VALIDATE_FAILED.getCode(),ResultCodeEnum.VALIDATE_FAILED.getDescription());
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static R1 validateFailed(String message) {
        return error(ResultCodeEnum.VALIDATE_FAILED.getCode(),message);
    }

    /**
     * 未登录返回结果
     */
    public static R1 unauthorized() {
        return error(ResultCodeEnum.UNAUTHORIZED.getCode(),ResultCodeEnum.UNAUTHORIZED.getDescription());
    }

    /**
     * 未登录返回结果
     *
     * @param message 提示信息
     */
    public static R1 unauthorized(String message) {
        return error(ResultCodeEnum.UNAUTHORIZED.getCode(),message);
    }

    /**
     * 未授权返回结果
     */
    public static R1 forbidden() {
        return error(ResultCodeEnum.FORBIDDEN.getCode(),ResultCodeEnum.FORBIDDEN.getDescription());
    }

    /**
     * 未授权返回结果
     *
     * @param message 提示信息
     */
    public static R1 forbidden(String message) {
        return error(ResultCodeEnum.FORBIDDEN.getCode(),message);
    }
    

    public static void main(String[] args) {
        R1 ok = R1.ok();
        ok.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

        R1 error = R1.error();
        error.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

        R1 forbidden = R1.forbidden();
        forbidden.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });



    }
}
