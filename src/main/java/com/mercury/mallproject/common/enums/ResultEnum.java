package com.mercury.mallproject.common.enums;

/**
 * 常用API操作码
 */
public enum ResultEnum implements EnumCode<Integer> {
    SUCCESS(0, "操作成功"),
    FAILED(1, "操作失败"),
    VALIDATE_FAILED(400, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    UNKNOWN_SERVER_ERROR(500, "未知服务器异常"),
    CAPTCHA_ERROR(500, "验证码错误"),
    PASSWORD_ERROR(500, "登陆密码错误"),
    USER_NOT_FOUNT(500, "用户不存在");
    private int key;
    private String description;

    private ResultEnum(int code, String description) {
        this.key = code;
        this.description = description;
    }


    @Override
    public Integer getCode() {
        return key;
    }

    public String getDescription() {
        return description;
    }
}
