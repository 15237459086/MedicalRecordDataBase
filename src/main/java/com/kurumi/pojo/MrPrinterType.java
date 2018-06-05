package com.kurumi.pojo;

public class MrPrinterType {
	
	 	private Integer printTypeId;

	    private String code;
	    
	    private String indexCode;
	    
	    private String name;
	    
	    private String enName;
	    
	    private String comment;

	    private Integer status;
	    
	    private Integer hospitalId;
	    
	    private Integer mrPageTypeId;
	    
	    private String pageTypeIds;

	    public Integer getPrintTypeId() {
	        return printTypeId;
	    }

	    public void setPrintTypeId(Integer printTypeId) {
	        this.printTypeId = printTypeId;
	    }

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

	    public Integer getStatus() {
	        return status;
	    }

	    public void setStatus(Integer status) {
	        this.status = status;
	    }

	    public Integer getHospitalId() {
	        return hospitalId;
	    }

	    public void setHospitalId(Integer hospitalId) {
	        this.hospitalId = hospitalId;
	    }

		public Integer getMrPageTypeId() {
			return mrPageTypeId;
		}

		public void setMrPageTypeId(Integer mrPageTypeId) {
			this.mrPageTypeId = mrPageTypeId;
		}

		public String getPageTypeIds() {
			return pageTypeIds;
		}

		public void setPageTypeIds(String pageTypeIds) {
			this.pageTypeIds = pageTypeIds;
		}

		public String getIndexCode() {
			return indexCode;
		}

		public void setIndexCode(String indexCode) {
			this.indexCode = indexCode;
		}

		public String getEnName() {
			return enName;
		}

		public void setEnName(String enName) {
			this.enName = enName;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}
		
}
