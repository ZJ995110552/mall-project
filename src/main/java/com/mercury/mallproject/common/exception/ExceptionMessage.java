package com.mercury.mallproject.common.exception;

import java.io.Serializable;

public interface ExceptionMessage extends Serializable {

    /**
     * 错误码
     *
     * @return
     */
    String getCode();

    /**
     * 错误描述
     */
    String getDescription();

    /**
     * 解决方案
     */
    String getSuggestion();
}
