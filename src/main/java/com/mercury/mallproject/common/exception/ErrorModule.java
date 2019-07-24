package com.mercury.mallproject.common.exception;

public enum ErrorModule {

    CORE("01"),
    BASE_SERVICE("02"),
    MMALL("03"),
    ;

    private String moduleId;

    private ErrorModule(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

}
