package com.mercury.mallproject.common.enums;

public enum ErrorCodeEnum implements EnumCode<String>{
    UNAUTHORIZED("401","暂未登录或token已经过期"),
    FORBIDDEN("403", "没有相关权限"),
    VALIDATE_FAILED("404", "参数检验失败"),
    USER_NOT_FOUNT("500", "用户不存在"),
    UNKNOWN_SERVER_ERROR("500", "未知服务器异常"),
    NOT_NULL("10001"," NOT_NULL"),
    DB_RECORD_EXISTS("10002","数据已存在"),
    PARAMS_GET_ERROR("10003","参数获取错误"),
    ACCOUNT_PASSWORD_ERROR("10004","账号密码错误"),
    ACCOUNT_DISABLE("10005","账户已禁用"),
    IDENTIFIER_NOT_NULL("10006","身份不存在"),
    CAPTCHA_ERROR("10007","验证码错误"),
    SUB_MENU_EXIST("10008","子菜单已存在"),
    PASSWORD_ERROR("10009","密码错误"),
    ACCOUNT_NOT_EXIST("10010","账户不存在"),
    SUPERIOR_DEPT_ERROR("10011","高级部门错误"),
    SUPERIOR_MENU_ERROR("10012","高级菜单错误"),
    DATA_SCOPE_PARAMS_ERROR("10013","参数取值范围错误"),
    DEPT_SUB_DELETE_ERROR("10014","子部门删除失败"),
    DEPT_USER_DELETE_ERROR("10015","用户部门删除失败"),
    ACT_DEPLOY_ERROR("10016","活动部署错误"),
    ACT_MODEL_IMG_ERROR("10017","活动模板图片错误"),
    ACT_MODEL_EXPORT_ERROR("10018","活动模板导出失败"),
    UPLOAD_FILE_EMPTY("10019","上传文件为空错误"),
    TOKEN_NOT_EMPTY("10020","TOKEN不能为空"),
    TOKEN_INVALID("10021","TOKEN无效"),
    ACCOUNT_LOCK("10022","账户已被锁定"),
    ACT_DEPLOY_FORMAT_ERROR("10023","活动部署格式化失败"),
    OSS_UPLOAD_FILE_ERROR("10024","OSS云存储上传文件失败"),
    SEND_SMS_ERROR("10025","SMS发送失败"),
    MAIL_TEMPLATE_NOT_EXISTS("10026","邮件模板不能为空"),
    REDIS_ERROR("10027","REDIS错误"),
    JOB_ERROR("10028","JOB错误"),
    INVALID_SYMBOL("10029","标记无效"),
    JSON_FORMAT_ERROR("10030","JSON格式化失败"),
    SMS_CONFIG_ERROR("10031","SMS配置错误"),

    TASK_EXISTS("11001","定时任务已存在"),
    TASK_NOT_EXISTS("11002","定时任务不存在"),
    TASK_ALREADY_STARTED("11003","定时任务已启动"),
    TASK_CONFIG_ERROR("11004","定时任务配置错误"),
    TASK_NODE_NOT_AVAILABLE("11005","定时任务节点不可用")





    ;

    private final String code;
    private final String description;

    private ErrorCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
