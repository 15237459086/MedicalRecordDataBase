package com.kurumi.pojo;

import com.kurumi.util.StringUtil;

public class StdOperation {
    private String code;

    private String name;

    private String enName;
    
    private String indexCode;

    private String aliasName;

    private String aliasNameIndex;
    
    private String operationMarkCode;
    
    private String operationMarkName;

    private String incisionLevelCode;

    private String incisionLevelName;
    
    private String operationLevelCode;
    
    private String operationLevelName;

    private String stdRegionCode;

    private String stdProvinceCode;

    private String interDiseaseVersion;
    
    private String comment;
    
    private Integer status = 1;
    
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
    
    public String getIndexCode() {
        return StringUtil.meaningStr(indexCode);
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
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

	

	public String getOperationMarkCode() {
		return StringUtil.meaningStr(operationMarkCode);
	}

	public void setOperationMarkCode(String operationMarkCode) {
		this.operationMarkCode = operationMarkCode;
	}

	public String getOperationMarkName() {
		return StringUtil.meaningStr(operationMarkName);
	}

	public void setOperationMarkName(String operationMarkName) {
		this.operationMarkName = operationMarkName;
	}

	public String getIncisionLevelCode() {
		return StringUtil.meaningStr(incisionLevelCode);
	}

	public void setIncisionLevelCode(String incisionLevelCode) {
		this.incisionLevelCode = incisionLevelCode;
	}

	public String getIncisionLevelName() {
		return StringUtil.meaningStr(incisionLevelName);
	}

	public void setIncisionLevelName(String incisionLevelName) {
		this.incisionLevelName = incisionLevelName;
	}

	public String getOperationLevelCode() {
		return StringUtil.meaningStr(operationLevelCode);
	}

	public void setOperationLevelCode(String operationLevelCode) {
		this.operationLevelCode = operationLevelCode;
	}

	public String getOperationLevelName() {
		return StringUtil.meaningStr(operationLevelName);
	}

	public void setOperationLevelName(String operationLevelName) {
		this.operationLevelName = operationLevelName;
	}

	public String getStdRegionCode() {
		return StringUtil.meaningStr(stdRegionCode);
	}

	public void setStdRegionCode(String stdRegionCode) {
		this.stdRegionCode = stdRegionCode;
	}

	public String getStdProvinceCode() {
		return StringUtil.meaningStr(stdProvinceCode);
	}

	public void setStdProvinceCode(String stdProvinceCode) {
		this.stdProvinceCode = stdProvinceCode;
	}

	public String getInterDiseaseVersion() {
		return StringUtil.meaningStr(interDiseaseVersion);
	}

	public void setInterDiseaseVersion(String interDiseaseVersion) {
		this.interDiseaseVersion = interDiseaseVersion;
	}

	public String getComment() {
		return StringUtil.meaningStr(comment);
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    
    

    
}