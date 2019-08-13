package com.mercury.mallproject.common.response;

import com.mercury.mallproject.common.enums.ResultEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 操作消息提醒
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 Message 对象
     */
    protected R() {
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static R ok() {
        return R.ok(ResultEnum.SUCCESS.getDescription());
    }

    /**
     * 返回成功消息
     *
     * @param msg 内容
     * @return 成功消息
     */
    public static R ok(String msg) {
        R json = new R();
        json.put("code", ResultEnum.SUCCESS.getCode());
        json.put("msg", msg);
        return json;
    }

    /**
     * 返回成功消息,并传入数据信息
     *
     * @param map
     * @return
     */
    public static R ok(Map<String, Object> map) {
        R json = new R();
        json.put("code", ResultEnum.SUCCESS.getCode());
        json.put("msg", ResultEnum.SUCCESS.getDescription());
        json.putAll(map);
        return json;
    }

    /**
     * 返回错误消息
     *
     * @return 错误消息
     */
    public static R error() {
        return error(ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getDescription());
    }

    /**
     * 返回错误消息
     *
     * @param msg 内容
     * @return 错误消息
     */
    public static R error(String msg) {
        return error(ResultEnum.FAILED.getCode(), msg);
    }

    /**
     * 返回错误消息
     *
     * @param code 错误码
     * @param msg  内容
     * @return 错误消息
     */
    public static R error(Integer code, String msg) {
        R json = new R();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }

    /**
     * 返回成功消息
     *
     * @param key   键值
     * @param value 内容
     * @return 成功消息
     */
    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 返回错误码
     *
     * @param errorcode 错误码
     * @param msg  内容
     * @return 错误消息
     */
    public static R errorCode(Integer errorcode, String msg) {
        R json = new R();
        json.put("code", ResultEnum.FAILED.getCode());
        json.put("errorcode", errorcode);
        json.put("msg", msg);
        return json;
    }

    /**
     * 参数验证失败返回结果
     */
    public static R validateFailed() {
        return errorCode(ResultEnum.VALIDATE_FAILED.getCode(), ResultEnum.VALIDATE_FAILED.getDescription());
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static R validateFailed(String message) {
        return errorCode(ResultEnum.VALIDATE_FAILED.getCode(), message);
    }

    /**
     * 未登录返回结果
     */
    public static R unauthorized() {
        return errorCode(ResultEnum.UNAUTHORIZED.getCode(), ResultEnum.UNAUTHORIZED.getDescription());
    }

    /**
     * 未登录返回结果
     *
     * @param message 提示信息
     */
    public static R unauthorized(String message) {
        return errorCode(ResultEnum.UNAUTHORIZED.getCode(), message);
    }

    /**
     * 未授权返回结果
     */
    public static R forbidden() {
        return errorCode(ResultEnum.FORBIDDEN.getCode(), ResultEnum.FORBIDDEN.getDescription());
    }

    /**
     * 未授权返回结果
     *
     * @param message 提示信息
     */
    public static R forbidden(String message) {
        return errorCode(ResultEnum.FORBIDDEN.getCode(), message);
    }


    public static void main(String[] args) {
        System.out.println("====================================");
        R ok = R.ok();
        ok.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
        System.out.println("====================================");
        R error = R.error();
        error.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
        System.out.println("====================================");
        R forbidden = R.forbidden();
        forbidden.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
        System.out.println("====================================");
        HashMap<String, Object> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("aaa", "111");
        stringStringHashMap.put("bbb", "222");

        R ok1 = R.ok(stringStringHashMap);
        ok1.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

        System.out.println("====================================");
        R put = R.ok().put("AAA", "111").put("BBB", "222");
        put.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

        System.out.println("====================================");
        R r = R.errorCode(ResultEnum.CAPTCHA_ERROR.getCode(), ResultEnum.CAPTCHA_ERROR.getDescription());
        r.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

    }
}
