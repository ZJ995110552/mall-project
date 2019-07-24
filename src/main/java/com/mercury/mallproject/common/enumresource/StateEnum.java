package com.mercury.mallproject.common.enumresource;


public enum StateEnum implements EnumCode<String>

{
    ENABLE("1", "正常"),
    LIMIT("0", "禁用");
    private final String code;
    private final String description;

    private StateEnum(String code, String value) {
        this.code = code;
        this.description = value;
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