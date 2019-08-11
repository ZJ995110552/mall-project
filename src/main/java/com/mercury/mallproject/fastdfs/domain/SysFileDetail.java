package com.mercury.mallproject.fastdfs.domain;

import java.util.Date;

public class SysFileDetail {
    private Long id;

    private Long containerId;

    private String fileCategory;

    private String logicalName;

    private String description;

    private String extentionName;

    private String physicalName;

    private Long fileSize;

    private String fileContent;

    private Long docServerId;

    private String docServerAddress;

    private String serverGroup;

    private String serverRootDir;

    private String creator;

    private String creatorIp;

    private Date createTime;

    private String delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContainerId() {
        return containerId;
    }

    public void setContainerId(Long containerId) {
        this.containerId = containerId;
    }

    public String getFileCategory() {
        return fileCategory;
    }

    public void setFileCategory(String fileCategory) {
        this.fileCategory = fileCategory == null ? null : fileCategory.trim();
    }

    public String getLogicalName() {
        return logicalName;
    }

    public void setLogicalName(String logicalName) {
        this.logicalName = logicalName == null ? null : logicalName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getExtentionName() {
        return extentionName;
    }

    public void setExtentionName(String extentionName) {
        this.extentionName = extentionName == null ? null : extentionName.trim();
    }

    public String getPhysicalName() {
        return physicalName;
    }

    public void setPhysicalName(String physicalName) {
        this.physicalName = physicalName == null ? null : physicalName.trim();
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent == null ? null : fileContent.trim();
    }

    public Long getDocServerId() {
        return docServerId;
    }

    public void setDocServerId(Long docServerId) {
        this.docServerId = docServerId;
    }

    public String getDocServerAddress() {
        return docServerAddress;
    }

    public void setDocServerAddress(String docServerAddress) {
        this.docServerAddress = docServerAddress == null ? null : docServerAddress.trim();
    }

    public String getServerGroup() {
        return serverGroup;
    }

    public void setServerGroup(String serverGroup) {
        this.serverGroup = serverGroup == null ? null : serverGroup.trim();
    }

    public String getServerRootDir() {
        return serverRootDir;
    }

    public void setServerRootDir(String serverRootDir) {
        this.serverRootDir = serverRootDir == null ? null : serverRootDir.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getCreatorIp() {
        return creatorIp;
    }

    public void setCreatorIp(String creatorIp) {
        this.creatorIp = creatorIp == null ? null : creatorIp.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}