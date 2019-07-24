package com.mercury.mallproject.common.enumresource;

public enum IsInitEnum implements EnumMessage {

    YES("1", "是"),
    NO("0", "否");

    private final String code;
    private final String value;

    private IsInitEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getValue() {
        return value;
    }
}
