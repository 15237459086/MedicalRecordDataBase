package com.kurumi.enums;

public enum TableNameEnum {

	Sex("性别","sex"),Marriage("婚姻","marriage"),Profession("职业","profession"),RelativeRelation("亲属关系","relative_relation"),
	Nationality("国籍","nationality"),Nation("民族","nation"),MrPageType("编页标签","mr_page_type");
	
	// 成员变量  
    private String tableNameDesc;  
    private String tableName;
    
	private TableNameEnum(String tableNameDesc, String tableName) {
		this.tableNameDesc = tableNameDesc;
		this.tableName = tableName;
	}

	public String getTableNameDesc() {
		return tableNameDesc;
	}

	public void setTableNameDesc(String tableNameDesc) {
		this.tableNameDesc = tableNameDesc;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}  
    
}
