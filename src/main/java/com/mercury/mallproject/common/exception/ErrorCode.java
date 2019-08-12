package com.mercury.mallproject.common.exception;

import com.mercury.mallproject.common.enums.EnumCode;

public interface ErrorCode extends EnumCode<String> {

    ErrorModule getErrorModule();

}
