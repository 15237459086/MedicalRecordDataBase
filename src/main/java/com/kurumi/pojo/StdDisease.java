package com.kurumi.pojo;

import com.kurumi.util.StringUtil;


public class StdDisease{
	private String code;
	private String name;
	private String enName;
	private String aliasName;
	private String aliasNameIndex;
	private String indexCode;
	private String fitManCodeFlag;
	private String fitWomanCodeFlag;
	private String unDeathFlag;
	private String unPrimaryFlag;
	private String clinicalDiag;
	private String clinicalDiagIndex;
	private String attentionFlag;
	private String attentionComment;
	private String regionCode;
	private String provinceCode;
	private String interDiseaseVersion;

	private String comment;
	private Integer status =1;
	
	
	public String getCode() {
		return StringUtil.meaningStr(code);
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return StringUtil.meaningStr(name);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnName() {
		return StringUtil.meaningStr(enName);
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getAliasName() {
		return StringUtil.meaningStr(aliasName);
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public String getAliasNameIndex() {
		return StringUtil.meaningStr(aliasNameIndex);
	}
	public void setAliasNameIndex(String aliasNameIndex) {
		this.aliasNameIndex = aliasNameIndex;
	}
	public String getIndexCode() {
		return StringUtil.meaningStr(indexCode);
	}
	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}
	public String getComment() {
		return StringUtil.meaningStr(comment);
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getFitManCodeFlag() {
		return StringUtil.meaningStr(fitManCodeFlag);
	}
	public void setFitManCodeFlag(String fitManCodeFlag) {
		this.fitManCodeFlag = fitManCodeFlag;
	}
	
	public String getFitWomanCodeFlag() {
		return StringUtil.meaningStr(fitWomanCodeFlag);
	}

	public void setFitWomanCodeFlag(String fitWomanCodeFlag) {
		this.fitWomanCodeFlag = fitWomanCodeFlag;
	}

	
	
	public String getUnDeathFlag() {
		return StringUtil.meaningStr(unDeathFlag);
	}
	public void setUnDeathFlag(String unDeathFlag) {
		this.unDeathFlag = unDeathFlag;
	}
	public String getUnPrimaryFlag() {
		return StringUtil.meaningStr(unPrimaryFlag);
	}
	public void setUnPrimaryFlag(String unPrimaryFlag) {
		this.unPrimaryFlag = unPrimaryFlag;
	}
	
	public String getClinicalDiag() {
		return StringUtil.meaningStr(clinicalDiag);
	}
	public void setClinicalDiag(String clinicalDiag) {
		this.clinicalDiag = clinicalDiag;
	}
	public String getClinicalDiagIndex() {
		return StringUtil.meaningStr(clinicalDiagIndex);
	}
	public void setClinicalDiagIndex(String clinicalDiagIndex) {
		this.clinicalDiagIndex = clinicalDiagIndex;
	}
	public String getAttentionFlag() {
		return StringUtil.meaningStr(attentionFlag);
	}
	public void setAttentionFlag(String attentionFlag) {
		this.attentionFlag = attentionFlag;
	}
	public String getAttentionComment() {
		return StringUtil.meaningStr(attentionComment);
	}
	public void setAttentionComment(String attentionComment) {
		this.attentionComment = attentionComment;
	}
	public String getRegionCode() {
		return StringUtil.meaningStr(regionCode);
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getProvinceCode() {
		return StringUtil.meaningStr(provinceCode);
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getInterDiseaseVersion() {
		return StringUtil.meaningStr(interDiseaseVersion);
	}
	public void setInterDiseaseVersion(String interDiseaseVersion) {
		this.interDiseaseVersion = interDiseaseVersion;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	

	
	
	
}
