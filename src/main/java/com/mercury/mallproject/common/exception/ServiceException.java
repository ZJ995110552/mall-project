package com.mercury.mallproject.common.exception;

import java.util.Arrays;
import java.util.UUID;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String id = UUID.randomUUID().toString();

    public enum ExceptionType {
        INTERNAL,//内部错误
        EXTERNAL,//外部错误
        THIRDPARTY,//其他平台错误
        ;
    }

    public enum ExceptionLevel {
        INFO,
        WRAN,
        ERROR;

        public boolean isInfo() {
            return this == INFO;
        }

        public boolean isWran() {
            return this == WRAN;
        }

        public boolean isError() {
            return this == ERROR;
        }
    }

    private String errorCode;
    private boolean unKonwn = false;
    private ExceptionLevel level = ExceptionLevel.ERROR;
    private ExceptionType excType = ExceptionType.INTERNAL;

    public ServiceException() {
        super();
    }

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(String msg, Throwable t) {
        super(msg, t);
    }

    public ServiceException(String msg, ExceptionType type) {
        super(msg);
        this.excType = type;
    }

    public ServiceException unKonwn(boolean unKonwn) {
        this.unKonwn = unKonwn;
        return this;
    }

    public ServiceException level(ExceptionLevel level) {
        this.level = level;
        return this;
    }

    public boolean isKnown() {
        return unKonwn;
    }

    public ServiceException(ErrorModule module, String moduleErrorCode) {
        this.errorCode = ErrorCodeUtil.getErrorCode(module, moduleErrorCode);
    }

    public ServiceException(ErrorModule module, String moduleErrorCode, ExceptionType excType) {
        this.errorCode = ErrorCodeUtil.getErrorCode(module, moduleErrorCode);
        this.excType = excType;
    }

    public ServiceException(ErrorModule module, String moduleErrorCode, String msg) {
        super(msg);
        this.errorCode = ErrorCodeUtil.getErrorCode(module, moduleErrorCode);
    }

    public ServiceException(ErrorModule module, String moduleErrorCode, String msg, ExceptionType excType) {
        super(msg);
        this.errorCode = ErrorCodeUtil.getErrorCode(module, moduleErrorCode);
        this.excType = excType;
    }

    public ServiceException(ErrorModule module, String moduleErrorCode, String msg, String... args) {
        super(String.format(msg, Arrays.asList(args).toArray(new Object[0])));
        this.errorCode = ErrorCodeUtil.getErrorCode(module, moduleErrorCode);
    }

    public ServiceException(ErrorModule module, String moduleErrorCode, String msg, ExceptionType excType, String... args) {
        super(String.format(msg, Arrays.asList(args).toArray(new Object[0])));
        this.errorCode = ErrorCodeUtil.getErrorCode(module, moduleErrorCode);
        this.excType = excType;
    }

    public ServiceException(ErrorModule module, String moduleErrorCode, String msg, Throwable t) {
        super(msg, t);
        this.errorCode = ErrorCodeUtil.getErrorCode(module, moduleErrorCode);
    }

    public ServiceException(ErrorModule module, String moduleErrorCode, String msg, Throwable t, ExceptionType excType) {
        super(msg, t);
        this.errorCode = ErrorCodeUtil.getErrorCode(module, moduleErrorCode);
        this.excType = excType;
    }

    public ServiceException(ErrorModule module, String moduleErrorCode, String msg, Throwable t, String... args) {
        super(String.format(msg, Arrays.asList(args).toArray(new Object[0])), t);
        this.errorCode = ErrorCodeUtil.getErrorCode(module, moduleErrorCode);
    }

    public ServiceException(ErrorModule module, String moduleErrorCode, String msg, Throwable t, ExceptionType excType, String... args) {
        super(String.format(msg, Arrays.asList(args).toArray(new Object[0])), t);
        this.errorCode = ErrorCodeUtil.getErrorCode(module, moduleErrorCode);
        this.excType = excType;
    }

    public ServiceException(ErrorCode errorCode, Throwable t) {
        super(String.format(errorCode.getDescription()), t);
        this.errorCode = ErrorCodeUtil.getErrorCode(errorCode.getErrorModule(), errorCode.getCode());
    }

    public ServiceException(ErrorCode errorCode, ExceptionType excType) {
        super(String.format(errorCode.getDescription()));
        this.errorCode = ErrorCodeUtil.getErrorCode(errorCode.getErrorModule(), errorCode.getCode());
        this.excType = excType;
    }

    public ServiceException(ErrorCode errorCode, ExceptionType excType, String... args) {
        super(String.format(errorCode.getDescription(), Arrays.asList(args).toArray(new Object[0])));
        this.errorCode = ErrorCodeUtil.getErrorCode(errorCode.getErrorModule(), errorCode.getCode());
        this.excType = excType;
    }

    public ServiceException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getDescription());
        this.errorCode = exceptionMessage.getCode();
        this.excType = ExceptionType.THIRDPARTY;
    }

    public ServiceException(String msg, ExceptionType excType, ExceptionLevel level) {
        this(msg);
        this.excType = excType;
        this.level = level;
    }

    public ServiceException(String msg, ExceptionType excType, Throwable t) {
        super(msg, t);
        this.excType = excType;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ExceptionLevel getLevel() {
        return level;
    }

    public void setLevel(ExceptionLevel level) {
        this.level = level;
    }

    public ExceptionType getExcType() {
        return excType;
    }

    public void setExcType(ExceptionType excType) {
        this.excType = excType;
    }

    @Override
    public String getMessage() {
        if (this.unKonwn) {
            return super.getMessage() + ",错误id:" + id;
        } else {
            return super.getMessage();
        }
    }

    public static ServiceException getWrapper(Exception exception) {
        exception.printStackTrace();
        ServiceException serviceException = null;
        if (exception instanceof IllegalArgumentException) {
            serviceException = new ServiceException(ErrorModule.CORE, "", "校验失败", ExceptionType.EXTERNAL);
            serviceException.setLevel(ExceptionLevel.WRAN);
            serviceException.unKonwn(false);
        } else {
            serviceException = new ServiceException(ErrorModule.CORE, "", "系统异常请联系管理员", ExceptionType.EXTERNAL);
            serviceException.unKonwn(true);
        }
        return serviceException;
    }

    public String getId() {
        return id;
    }
}
