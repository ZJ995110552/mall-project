package com.mercury.mallproject.common.enums;

public enum SexEnum implements EnumCode<String> {

    MEN("1", "男"),
    WOMEN("2", "女"),
    UNKNOWN("0", "保密");
    private final String code;
    private final String description;

    private SexEnum(String code, String description) {
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