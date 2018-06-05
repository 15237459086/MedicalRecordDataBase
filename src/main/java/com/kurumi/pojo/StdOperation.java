package com.kurumi.pojo;

public class StdOperation {
    private String code;

    private String name;

    private String enName;

    private String aliasName;

    private String aliasNameIndex;

    private String indexCode;

    private Integer attributesId;

    private String comment;

    private Integer stdOpsPerationMarkId;

    private Integer stdIncisionLevelId;

    private Integer stdOpsLevelId;

    private Integer status;

    private String stdRegionCode;

    private String stdProvinceCode;

    private String interDiseaseVersion;
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName == null ? null : aliasName.trim();
    }

    public String getAliasNameIndex() {
        return aliasNameIndex;
    }

    public void setAliasNameIndex(String aliasNameIndex) {
        this.aliasNameIndex = aliasNameIndex == null ? null : aliasNameIndex.trim();
    }

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode == null ? null : indexCode.trim();
    }

    public Integer getAttributesId() {
        return attributesId;
    }

    public void setAttributesId(Integer attributesId) {
        this.attributesId = attributesId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getStdOpsPerationMarkId() {
        return stdOpsPerationMarkId;
    }

    public void setStdOpsPerationMarkId(Integer stdOpsPerationMarkId) {
        this.stdOpsPerationMarkId = stdOpsPerationMarkId;
    }

    public Integer getStdIncisionLevelId() {
        return stdIncisionLevelId;
    }

    public void setStdIncisionLevelId(Integer stdIncisionLevelId) {
        this.stdIncisionLevelId = stdIncisionLevelId;
    }

    public Integer getStdOpsLevelId() {
        return stdOpsLevelId;
    }

    public void setStdOpsLevelId(Integer stdOpsLevelId) {
        this.stdOpsLevelId = stdOpsLevelId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStdRegionCode() {
        return stdRegionCode;
    }

    public void setStdRegionCode(String stdRegionCode) {
        this.stdRegionCode = stdRegionCode == null ? null : stdRegionCode.trim();
    }

    public String getStdProvinceCode() {
        return stdProvinceCode;
    }

    public void setStdProvinceCode(String stdProvinceCode) {
        this.stdProvinceCode = stdProvinceCode == null ? null : stdProvinceCode.trim();
    }

    public String getInterDiseaseVersion() {
        return interDiseaseVersion;
    }

    public void setInterDiseaseVersion(String interDiseaseVersion) {
        this.interDiseaseVersion = interDiseaseVersion == null ? null : interDiseaseVersion.trim();
    }
}