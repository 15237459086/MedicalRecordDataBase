package com.kurumi.query;

import com.kurumi.util.StringUtil;

public class DiseaseQuery extends PageQuery {

	private String code;

    private String name;
    
    private String indexCode;
    
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

	public String getIndexCode() {
		return StringUtil.meaningStr(indexCode);
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = StringUtil.meaningStr(indexCode);
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
