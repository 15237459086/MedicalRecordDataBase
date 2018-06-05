package com.kurumi.query;

import com.kurumi.util.StringUtil;

public class BasicEncodingQuery extends PageQuery {

    private String code;

    private String name;
    
    private String enName;
    
    private String indexCode;
    
    private String sortCode;
    
    private String comment;

    private Integer status;
    
    private String tableName;
    
    private String title;
    
    //查询结果集
  	private Object queryDatas;

	public String getCode() {
		return StringUtil.meaningStr(code);
	}

	public void setCode(String code) {
		this.code = StringUtil.meaningStr(code);
	}

	public String getName() {
		return StringUtil.meaningStr(name);
	}

	public void setName(String name) {
		this.name = StringUtil.meaningStr(name);
	}

	public String getEnName() {
		return StringUtil.meaningStr(enName);
	}

	public void setEnName(String enName) {
		this.enName = StringUtil.meaningStr(enName);
	}

	public String getIndexCode() {
		return StringUtil.meaningStr(indexCode);
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = StringUtil.meaningStr(indexCode);
	}

	public String getSortCode() {
		return StringUtil.meaningStr(sortCode);
	}

	public void setSortCode(String sortCode) {
		this.sortCode = StringUtil.meaningStr(sortCode);
	}

	public String getComment() {
		return StringUtil.meaningStr(comment);
	}

	public void setComment(String comment) {
		this.comment = StringUtil.meaningStr(comment);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Object getQueryDatas() {
		return queryDatas;
	}

	public void setQueryDatas(Object queryDatas) {
		this.queryDatas = queryDatas;
	}

	public boolean isEmpty(){
		if(this.getCode() == null && this.getName() == null && this.getIndexCode() == null){
			return true;
		}
		return false;
	}
    
}
