package com.mercury.mallproject.fastdfs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysFileDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysFileDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andContainerIdIsNull() {
            addCriterion("container_id is null");
            return (Criteria) this;
        }

        public Criteria andContainerIdIsNotNull() {
            addCriterion("container_id is not null");
            return (Criteria) this;
        }

        public Criteria andContainerIdEqualTo(Long value) {
            addCriterion("container_id =", value, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdNotEqualTo(Long value) {
            addCriterion("container_id <>", value, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdGreaterThan(Long value) {
            addCriterion("container_id >", value, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("container_id >=", value, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdLessThan(Long value) {
            addCriterion("container_id <", value, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdLessThanOrEqualTo(Long value) {
            addCriterion("container_id <=", value, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdIn(List<Long> values) {
            addCriterion("container_id in", values, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdNotIn(List<Long> values) {
            addCriterion("container_id not in", values, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdBetween(Long value1, Long value2) {
            addCriterion("container_id between", value1, value2, "containerId");
            return (Criteria) this;
        }

        public Criteria andContainerIdNotBetween(Long value1, Long value2) {
            addCriterion("container_id not between", value1, value2, "containerId");
            return (Criteria) this;
        }

        public Criteria andFileCategoryIsNull() {
            addCriterion("file_category is null");
            return (Criteria) this;
        }

        public Criteria andFileCategoryIsNotNull() {
            addCriterion("file_category is not null");
            return (Criteria) this;
        }

        public Criteria andFileCategoryEqualTo(String value) {
            addCriterion("file_category =", value, "fileCategory");
            return (Criteria) this;
        }

        public Criteria andFileCategoryNotEqualTo(String value) {
            addCriterion("file_category <>", value, "fileCategory");
            return (Criteria) this;
        }

        public Criteria andFileCategoryGreaterThan(String value) {
            addCriterion("file_category >", value, "fileCategory");
            return (Criteria) this;
        }

        public Criteria andFileCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("file_category >=", value, "fileCategory");
            return (Criteria) this;
        }

        public Criteria andFileCategoryLessThan(String value) {
            addCriterion("file_category <", value, "fileCategory");
            return (Criteria) this;
        }

        public Criteria andFileCategoryLessThanOrEqualTo(String value) {
            addCriterion("file_category <=", value, "fileCategory");
            return (Criteria) this;
        }

        public Criteria andFileCategoryLike(String value) {
            addCriterion("file_category like", value, "fileCategory");
            return (Criteria) this;
        }

        public Criteria andFileCategoryNotLike(String value) {
            addCriterion("file_category not like", value, "fileCategory");
            return (Criteria) this;
        }

        public Criteria andFileCategoryIn(List<String> values) {
            addCriterion("file_category in", values, "fileCategory");
            return (Criteria) this;
        }

        public Criteria andFileCategoryNotIn(List<String> values) {
            addCriterion("file_category not in", values, "fileCategory");
            return (Criteria) this;
        }

        public Criteria andFileCategoryBetween(String value1, String value2) {
            addCriterion("file_category between", value1, value2, "fileCategory");
            return (Criteria) this;
        }

        public Criteria andFileCategoryNotBetween(String value1, String value2) {
            addCriterion("file_category not between", value1, value2, "fileCategory");
            return (Criteria) this;
        }

        public Criteria andLogicalNameIsNull() {
            addCriterion("logical_name is null");
            return (Criteria) this;
        }

        public Criteria andLogicalNameIsNotNull() {
            addCriterion("logical_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogicalNameEqualTo(String value) {
            addCriterion("logical_name =", value, "logicalName");
            return (Criteria) this;
        }

        public Criteria andLogicalNameNotEqualTo(String value) {
            addCriterion("logical_name <>", value, "logicalName");
            return (Criteria) this;
        }

        public Criteria andLogicalNameGreaterThan(String value) {
            addCriterion("logical_name >", value, "logicalName");
            return (Criteria) this;
        }

        public Criteria andLogicalNameGreaterThanOrEqualTo(String value) {
            addCriterion("logical_name >=", value, "logicalName");
            return (Criteria) this;
        }

        public Criteria andLogicalNameLessThan(String value) {
            addCriterion("logical_name <", value, "logicalName");
            return (Criteria) this;
        }

        public Criteria andLogicalNameLessThanOrEqualTo(String value) {
            addCriterion("logical_name <=", value, "logicalName");
            return (Criteria) this;
        }

        public Criteria andLogicalNameLike(String value) {
            addCriterion("logical_name like", value, "logicalName");
            return (Criteria) this;
        }

        public Criteria andLogicalNameNotLike(String value) {
            addCriterion("logical_name not like", value, "logicalName");
            return (Criteria) this;
        }

        public Criteria andLogicalNameIn(List<String> values) {
            addCriterion("logical_name in", values, "logicalName");
            return (Criteria) this;
        }

        public Criteria andLogicalNameNotIn(List<String> values) {
            addCriterion("logical_name not in", values, "logicalName");
            return (Criteria) this;
        }

        public Criteria andLogicalNameBetween(String value1, String value2) {
            addCriterion("logical_name between", value1, value2, "logicalName");
            return (Criteria) this;
        }

        public Criteria andLogicalNameNotBetween(String value1, String value2) {
            addCriterion("logical_name not between", value1, value2, "logicalName");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andExtentionNameIsNull() {
            addCriterion("extention_name is null");
            return (Criteria) this;
        }

        public Criteria andExtentionNameIsNotNull() {
            addCriterion("extention_name is not null");
            return (Criteria) this;
        }

        public Criteria andExtentionNameEqualTo(String value) {
            addCriterion("extention_name =", value, "extentionName");
            return (Criteria) this;
        }

        public Criteria andExtentionNameNotEqualTo(String value) {
            addCriterion("extention_name <>", value, "extentionName");
            return (Criteria) this;
        }

        public Criteria andExtentionNameGreaterThan(String value) {
            addCriterion("extention_name >", value, "extentionName");
            return (Criteria) this;
        }

        public Criteria andExtentionNameGreaterThanOrEqualTo(String value) {
            addCriterion("extention_name >=", value, "extentionName");
            return (Criteria) this;
        }

        public Criteria andExtentionNameLessThan(String value) {
            addCriterion("extention_name <", value, "extentionName");
            return (Criteria) this;
        }

        public Criteria andExtentionNameLessThanOrEqualTo(String value) {
            addCriterion("extention_name <=", value, "extentionName");
            return (Criteria) this;
        }

        public Criteria andExtentionNameLike(String value) {
            addCriterion("extention_name like", value, "extentionName");
            return (Criteria) this;
        }

        public Criteria andExtentionNameNotLike(String value) {
            addCriterion("extention_name not like", value, "extentionName");
            return (Criteria) this;
        }

        public Criteria andExtentionNameIn(List<String> values) {
            addCriterion("extention_name in", values, "extentionName");
            return (Criteria) this;
        }

        public Criteria andExtentionNameNotIn(List<String> values) {
            addCriterion("extention_name not in", values, "extentionName");
            return (Criteria) this;
        }

        public Criteria andExtentionNameBetween(String value1, String value2) {
            addCriterion("extention_name between", value1, value2, "extentionName");
            return (Criteria) this;
        }

        public Criteria andExtentionNameNotBetween(String value1, String value2) {
            addCriterion("extention_name not between", value1, value2, "extentionName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameIsNull() {
            addCriterion("physical_name is null");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameIsNotNull() {
            addCriterion("physical_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameEqualTo(String value) {
            addCriterion("physical_name =", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameNotEqualTo(String value) {
            addCriterion("physical_name <>", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameGreaterThan(String value) {
            addCriterion("physical_name >", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameGreaterThanOrEqualTo(String value) {
            addCriterion("physical_name >=", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameLessThan(String value) {
            addCriterion("physical_name <", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameLessThanOrEqualTo(String value) {
            addCriterion("physical_name <=", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameLike(String value) {
            addCriterion("physical_name like", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameNotLike(String value) {
            addCriterion("physical_name not like", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameIn(List<String> values) {
            addCriterion("physical_name in", values, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameNotIn(List<String> values) {
            addCriterion("physical_name not in", values, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameBetween(String value1, String value2) {
            addCriterion("physical_name between", value1, value2, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameNotBetween(String value1, String value2) {
            addCriterion("physical_name not between", value1, value2, "physicalName");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("file_size is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("file_size is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(Long value) {
            addCriterion("file_size =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(Long value) {
            addCriterion("file_size <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(Long value) {
            addCriterion("file_size >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("file_size >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(Long value) {
            addCriterion("file_size <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(Long value) {
            addCriterion("file_size <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<Long> values) {
            addCriterion("file_size in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<Long> values) {
            addCriterion("file_size not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(Long value1, Long value2) {
            addCriterion("file_size between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(Long value1, Long value2) {
            addCriterion("file_size not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileContentIsNull() {
            addCriterion("file_content is null");
            return (Criteria) this;
        }

        public Criteria andFileContentIsNotNull() {
            addCriterion("file_content is not null");
            return (Criteria) this;
        }

        public Criteria andFileContentEqualTo(String value) {
            addCriterion("file_content =", value, "fileContent");
            return (Criteria) this;
        }

        public Criteria andFileContentNotEqualTo(String value) {
            addCriterion("file_content <>", value, "fileContent");
            return (Criteria) this;
        }

        public Criteria andFileContentGreaterThan(String value) {
            addCriterion("file_content >", value, "fileContent");
            return (Criteria) this;
        }

        public Criteria andFileContentGreaterThanOrEqualTo(String value) {
            addCriterion("file_content >=", value, "fileContent");
            return (Criteria) this;
        }

        public Criteria andFileContentLessThan(String value) {
            addCriterion("file_content <", value, "fileContent");
            return (Criteria) this;
        }

        public Criteria andFileContentLessThanOrEqualTo(String value) {
            addCriterion("file_content <=", value, "fileContent");
            return (Criteria) this;
        }

        public Criteria andFileContentLike(String value) {
            addCriterion("file_content like", value, "fileContent");
            return (Criteria) this;
        }

        public Criteria andFileContentNotLike(String value) {
            addCriterion("file_content not like", value, "fileContent");
            return (Criteria) this;
        }

        public Criteria andFileContentIn(List<String> values) {
            addCriterion("file_content in", values, "fileContent");
            return (Criteria) this;
        }

        public Criteria andFileContentNotIn(List<String> values) {
            addCriterion("file_content not in", values, "fileContent");
            return (Criteria) this;
        }

        public Criteria andFileContentBetween(String value1, String value2) {
            addCriterion("file_content between", value1, value2, "fileContent");
            return (Criteria) this;
        }

        public Criteria andFileContentNotBetween(String value1, String value2) {
            addCriterion("file_content not between", value1, value2, "fileContent");
            return (Criteria) this;
        }

        public Criteria andDocServerIdIsNull() {
            addCriterion("doc_server_id is null");
            return (Criteria) this;
        }

        public Criteria andDocServerIdIsNotNull() {
            addCriterion("doc_server_id is not null");
            return (Criteria) this;
        }

        public Criteria andDocServerIdEqualTo(Long value) {
            addCriterion("doc_server_id =", value, "docServerId");
            return (Criteria) this;
        }

        public Criteria andDocServerIdNotEqualTo(Long value) {
            addCriterion("doc_server_id <>", value, "docServerId");
            return (Criteria) this;
        }

        public Criteria andDocServerIdGreaterThan(Long value) {
            addCriterion("doc_server_id >", value, "docServerId");
            return (Criteria) this;
        }

        public Criteria andDocServerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("doc_server_id >=", value, "docServerId");
            return (Criteria) this;
        }

        public Criteria andDocServerIdLessThan(Long value) {
            addCriterion("doc_server_id <", value, "docServerId");
            return (Criteria) this;
        }

        public Criteria andDocServerIdLessThanOrEqualTo(Long value) {
            addCriterion("doc_server_id <=", value, "docServerId");
            return (Criteria) this;
        }

        public Criteria andDocServerIdIn(List<Long> values) {
            addCriterion("doc_server_id in", values, "docServerId");
            return (Criteria) this;
        }

        public Criteria andDocServerIdNotIn(List<Long> values) {
            addCriterion("doc_server_id not in", values, "docServerId");
            return (Criteria) this;
        }

        public Criteria andDocServerIdBetween(Long value1, Long value2) {
            addCriterion("doc_server_id between", value1, value2, "docServerId");
            return (Criteria) this;
        }

        public Criteria andDocServerIdNotBetween(Long value1, Long value2) {
            addCriterion("doc_server_id not between", value1, value2, "docServerId");
            return (Criteria) this;
        }

        public Criteria andDocServerAddressIsNull() {
            addCriterion("doc_server_address is null");
            return (Criteria) this;
        }

        public Criteria andDocServerAddressIsNotNull() {
            addCriterion("doc_server_address is not null");
            return (Criteria) this;
        }

        public Criteria andDocServerAddressEqualTo(String value) {
            addCriterion("doc_server_address =", value, "docServerAddress");
            return (Criteria) this;
        }

        public Criteria andDocServerAddressNotEqualTo(String value) {
            addCriterion("doc_server_address <>", value, "docServerAddress");
            return (Criteria) this;
        }

        public Criteria andDocServerAddressGreaterThan(String value) {
            addCriterion("doc_server_address >", value, "docServerAddress");
            return (Criteria) this;
        }

        public Criteria andDocServerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("doc_server_address >=", value, "docServerAddress");
            return (Criteria) this;
        }

        public Criteria andDocServerAddressLessThan(String value) {
            addCriterion("doc_server_address <", value, "docServerAddress");
            return (Criteria) this;
        }

        public Criteria andDocServerAddressLessThanOrEqualTo(String value) {
            addCriterion("doc_server_address <=", value, "docServerAddress");
            return (Criteria) this;
        }

        public Criteria andDocServerAddressLike(String value) {
            addCriterion("doc_server_address like", value, "docServerAddress");
            return (Criteria) this;
        }

        public Criteria andDocServerAddressNotLike(String value) {
            addCriterion("doc_server_address not like", value, "docServerAddress");
            return (Criteria) this;
        }

        public Criteria andDocServerAddressIn(List<String> values) {
            addCriterion("doc_server_address in", values, "docServerAddress");
            return (Criteria) this;
        }

        public Criteria andDocServerAddressNotIn(List<String> values) {
            addCriterion("doc_server_address not in", values, "docServerAddress");
            return (Criteria) this;
        }

        public Criteria andDocServerAddressBetween(String value1, String value2) {
            addCriterion("doc_server_address between", value1, value2, "docServerAddress");
            return (Criteria) this;
        }

        public Criteria andDocServerAddressNotBetween(String value1, String value2) {
            addCriterion("doc_server_address not between", value1, value2, "docServerAddress");
            return (Criteria) this;
        }

        public Criteria andServerGroupIsNull() {
            addCriterion("server_group is null");
            return (Criteria) this;
        }

        public Criteria andServerGroupIsNotNull() {
            addCriterion("server_group is not null");
            return (Criteria) this;
        }

        public Criteria andServerGroupEqualTo(String value) {
            addCriterion("server_group =", value, "serverGroup");
            return (Criteria) this;
        }

        public Criteria andServerGroupNotEqualTo(String value) {
            addCriterion("server_group <>", value, "serverGroup");
            return (Criteria) this;
        }

        public Criteria andServerGroupGreaterThan(String value) {
            addCriterion("server_group >", value, "serverGroup");
            return (Criteria) this;
        }

        public Criteria andServerGroupGreaterThanOrEqualTo(String value) {
            addCriterion("server_group >=", value, "serverGroup");
            return (Criteria) this;
        }

        public Criteria andServerGroupLessThan(String value) {
            addCriterion("server_group <", value, "serverGroup");
            return (Criteria) this;
        }

        public Criteria andServerGroupLessThanOrEqualTo(String value) {
            addCriterion("server_group <=", value, "serverGroup");
            return (Criteria) this;
        }

        public Criteria andServerGroupLike(String value) {
            addCriterion("server_group like", value, "serverGroup");
            return (Criteria) this;
        }

        public Criteria andServerGroupNotLike(String value) {
            addCriterion("server_group not like", value, "serverGroup");
            return (Criteria) this;
        }

        public Criteria andServerGroupIn(List<String> values) {
            addCriterion("server_group in", values, "serverGroup");
            return (Criteria) this;
        }

        public Criteria andServerGroupNotIn(List<String> values) {
            addCriterion("server_group not in", values, "serverGroup");
            return (Criteria) this;
        }

        public Criteria andServerGroupBetween(String value1, String value2) {
            addCriterion("server_group between", value1, value2, "serverGroup");
            return (Criteria) this;
        }

        public Criteria andServerGroupNotBetween(String value1, String value2) {
            addCriterion("server_group not between", value1, value2, "serverGroup");
            return (Criteria) this;
        }

        public Criteria andServerRootDirIsNull() {
            addCriterion("server_root_dir is null");
            return (Criteria) this;
        }

        public Criteria andServerRootDirIsNotNull() {
            addCriterion("server_root_dir is not null");
            return (Criteria) this;
        }

        public Criteria andServerRootDirEqualTo(String value) {
            addCriterion("server_root_dir =", value, "serverRootDir");
            return (Criteria) this;
        }

        public Criteria andServerRootDirNotEqualTo(String value) {
            addCriterion("server_root_dir <>", value, "serverRootDir");
            return (Criteria) this;
        }

        public Criteria andServerRootDirGreaterThan(String value) {
            addCriterion("server_root_dir >", value, "serverRootDir");
            return (Criteria) this;
        }

        public Criteria andServerRootDirGreaterThanOrEqualTo(String value) {
            addCriterion("server_root_dir >=", value, "serverRootDir");
            return (Criteria) this;
        }

        public Criteria andServerRootDirLessThan(String value) {
            addCriterion("server_root_dir <", value, "serverRootDir");
            return (Criteria) this;
        }

        public Criteria andServerRootDirLessThanOrEqualTo(String value) {
            addCriterion("server_root_dir <=", value, "serverRootDir");
            return (Criteria) this;
        }

        public Criteria andServerRootDirLike(String value) {
            addCriterion("server_root_dir like", value, "serverRootDir");
            return (Criteria) this;
        }

        public Criteria andServerRootDirNotLike(String value) {
            addCriterion("server_root_dir not like", value, "serverRootDir");
            return (Criteria) this;
        }

        public Criteria andServerRootDirIn(List<String> values) {
            addCriterion("server_root_dir in", values, "serverRootDir");
            return (Criteria) this;
        }

        public Criteria andServerRootDirNotIn(List<String> values) {
            addCriterion("server_root_dir not in", values, "serverRootDir");
            return (Criteria) this;
        }

        public Criteria andServerRootDirBetween(String value1, String value2) {
            addCriterion("server_root_dir between", value1, value2, "serverRootDir");
            return (Criteria) this;
        }

        public Criteria andServerRootDirNotBetween(String value1, String value2) {
            addCriterion("server_root_dir not between", value1, value2, "serverRootDir");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIpIsNull() {
            addCriterion("creator_ip is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIpIsNotNull() {
            addCriterion("creator_ip is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIpEqualTo(String value) {
            addCriterion("creator_ip =", value, "creatorIp");
            return (Criteria) this;
        }

        public Criteria andCreatorIpNotEqualTo(String value) {
            addCriterion("creator_ip <>", value, "creatorIp");
            return (Criteria) this;
        }

        public Criteria andCreatorIpGreaterThan(String value) {
            addCriterion("creator_ip >", value, "creatorIp");
            return (Criteria) this;
        }

        public Criteria andCreatorIpGreaterThanOrEqualTo(String value) {
            addCriterion("creator_ip >=", value, "creatorIp");
            return (Criteria) this;
        }

        public Criteria andCreatorIpLessThan(String value) {
            addCriterion("creator_ip <", value, "creatorIp");
            return (Criteria) this;
        }

        public Criteria andCreatorIpLessThanOrEqualTo(String value) {
            addCriterion("creator_ip <=", value, "creatorIp");
            return (Criteria) this;
        }

        public Criteria andCreatorIpLike(String value) {
            addCriterion("creator_ip like", value, "creatorIp");
            return (Criteria) this;
        }

        public Criteria andCreatorIpNotLike(String value) {
            addCriterion("creator_ip not like", value, "creatorIp");
            return (Criteria) this;
        }

        public Criteria andCreatorIpIn(List<String> values) {
            addCriterion("creator_ip in", values, "creatorIp");
            return (Criteria) this;
        }

        public Criteria andCreatorIpNotIn(List<String> values) {
            addCriterion("creator_ip not in", values, "creatorIp");
            return (Criteria) this;
        }

        public Criteria andCreatorIpBetween(String value1, String value2) {
            addCriterion("creator_ip between", value1, value2, "creatorIp");
            return (Criteria) this;
        }

        public Criteria andCreatorIpNotBetween(String value1, String value2) {
            addCriterion("creator_ip not between", value1, value2, "creatorIp");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}