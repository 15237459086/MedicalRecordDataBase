package com.kurumi.query;

import com.kurumi.util.StringUtil;


public class BasicDataQuery extends PageQuery{
	
	private String code;
	
	private String indexCode;
	
	private String name;
	
	private Integer hospitalId;
	
	private String tableName;
	
	private String title;

	public String getCode() {
		return StringUtil.meaningStr(code);
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIndexCode() {
		return StringUtil.meaningStr(indexCode);
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}

	public String getName() {
		return StringUtil.meaningStr(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
}
