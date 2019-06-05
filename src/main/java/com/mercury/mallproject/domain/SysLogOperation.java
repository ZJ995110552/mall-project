package com.mercury.mallproject.domain;

import java.util.Date;

public class SysLogOperation {
    private Long id;

    private String operation;

    private String requestUri;

    private String requestMethod;

    private Integer requestTime;

    private String userAgent;

    private String ip;

    private Integer status;

    private String creatorName;

    private Long creator;

    private Date createDate;

    private String requestParams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri == null ? null : requestUri.trim();
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod == null ? null : requestMethod.trim();
    }

    public Integer getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Integer requestTime) {
        this.requestTime = requestTime;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams == null ? null : requestParams.trim();
    }
}