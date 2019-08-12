package com.mercury.mallproject.common.enums;

public enum OperationStatusEnum implements EnumCode<Integer> {

    FAIL(0, "失败"), SUCCESS(1, "成功");


    private Integer code;
    private String description;

    OperationStatusEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
