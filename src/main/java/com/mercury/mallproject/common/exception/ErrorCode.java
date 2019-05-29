package com.mercury.mallproject.common.exception;

import com.mercury.mallproject.common.enumresource.EnumCode;

public interface ErrorCode extends EnumCode<String> {

	ErrorModule getErrorModule();

}
