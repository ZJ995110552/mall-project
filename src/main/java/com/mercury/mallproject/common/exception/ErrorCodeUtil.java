package com.mercury.mallproject.common.exception;

public class ErrorCodeUtil {

    public static String getErrorCode(ErrorModule module, String moduleErrorCode) {
        return new StringBuffer().append(module.getModuleId()).append(moduleErrorCode).toString();
    }
}
