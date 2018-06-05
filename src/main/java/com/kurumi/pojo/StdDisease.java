package com.kurumi.pojo;

import java.util.HashMap;
import java.util.Map;


public class StdDisease implements Comparable<StdDisease>{
	private String code;
	private String name;
	private String enName;
	private String aliasName;
	private String aliasNameIndex;
	private String indexCode;
	private String comment;
	private String fitManCodeFlag;
	private String womanCodeFlag;
	private String undeathFlag;
	private String unPrimaryFlag;
	private String clinicalDiagnosis;
	private String diagnosisIndex;
	private String attentionFlag;
	private String attentionComment;
	private String regionCode;
	private String provinceCode;
	private String interDiseaseVersion;
	private Integer attributeId;
	
	private Integer status;
	
	private String text;
	
	public StdDisease(){}
	
	public StdDisease(String code, String name, String enName,
			String aliasName, String aliasNameIndex, String indexCode,
			String comment, String fitManCodeFlag, String womanCodeFlag,
			String undeathFlag, String unPrimaryFlag, String clinicalDiagnosis,
			String diagnosisIndex, String attentionFlag,
			String attentionComment, String regionCode, String provinceCode,
			String interDiseaseVersion, Integer attributeId) {
		super();
		this.code = code;
		this.name = name;
		this.enName = enName;
		this.aliasName = aliasName;
		this.aliasNameIndex = aliasNameIndex;
		this.indexCode = indexCode;
		this.comment = comment;
		this.fitManCodeFlag = fitManCodeFlag;
		this.womanCodeFlag = womanCodeFlag;
		this.undeathFlag = undeathFlag;
		this.unPrimaryFlag = unPrimaryFlag;
		this.clinicalDiagnosis = clinicalDiagnosis;
		this.diagnosisIndex = diagnosisIndex;
		this.attentionFlag = attentionFlag;
		this.attentionComment = attentionComment;
		this.regionCode = regionCode;
		this.provinceCode = provinceCode;
		this.interDiseaseVersion = interDiseaseVersion;
		this.attributeId = attributeId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public String getAliasNameIndex() {
		return aliasNameIndex;
	}
	public void setAliasNameIndex(String aliasNameIndex) {
		this.aliasNameIndex = aliasNameIndex;
	}
	public String getIndexCode() {
		return indexCode;
	}
	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getFitManCodeFlag() {
		return fitManCodeFlag;
	}
	public void setFitManCodeFlag(String fitManCodeFlag) {
		this.fitManCodeFlag = fitManCodeFlag;
	}
	public String getWomanCodeFlag() {
		return womanCodeFlag;
	}
	public void setWomanCodeFlag(String womanCodeFlag) {
		this.womanCodeFlag = womanCodeFlag;
	}
	public String getUndeathFlag() {
		return undeathFlag;
	}
	public void setUndeathFlag(String undeathFlag) {
		this.undeathFlag = undeathFlag;
	}
	public String getUnPrimaryFlag() {
		return unPrimaryFlag;
	}
	public void setUnPrimaryFlag(String unPrimaryFlag) {
		this.unPrimaryFlag = unPrimaryFlag;
	}
	public String getClinicalDiagnosis() {
		return clinicalDiagnosis;
	}
	public void setClinicalDiagnosis(String clinicalDiagnosis) {
		this.clinicalDiagnosis = clinicalDiagnosis;
	}
	public String getDiagnosisIndex() {
		return diagnosisIndex;
	}
	public void setDiagnosisIndex(String diagnosisIndex) {
		this.diagnosisIndex = diagnosisIndex;
	}
	public String getAttentionFlag() {
		return attentionFlag;
	}
	public void setAttentionFlag(String attentionFlag) {
		this.attentionFlag = attentionFlag;
	}
	public String getAttentionComment() {
		return attentionComment;
	}
	public void setAttentionComment(String attentionComment) {
		this.attentionComment = attentionComment;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getInterDiseaseVersion() {
		return interDiseaseVersion;
	}
	public void setInterDiseaseVersion(String interDiseaseVersion) {
		this.interDiseaseVersion = interDiseaseVersion;
	}
	public Integer getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int compareTo(StdDisease o) {
		String prevCode = this.code;
		String currentCode = o.getCode();
		o.setName(o.getCode());
		Map<String,String[]> map = splitCode(prevCode,currentCode);
		String[] prevCodes = map.get("prev");
		String[] currentCodes =map.get("current");
		
		if(!currentCode.contains("-") && !prevCode.contains("-")){
			 return prevCode.compareTo(currentCode);
		}else{
			if(prevCodes.length==2 && currentCodes.length==2){
				if(currentCode.contains(".")){
					if(prevCodes[0].compareTo(currentCodes[0])<=0){
						if(prevCodes[1].compareTo(currentCodes[0])>=0){
							return -1;
						}
					}else{
						return 1;
					}
				}else{
					return compareCode(o, this);
				}
			}else {
				return compareCode(o, this);
			}
		}
		return -1;
	}
	
	public static Map<String,String[]> splitCode(String prevCode,String code){
		Map<String,String[]> map = new HashMap<String, String[]>();
		String[] prevCodes = null;
		String[] codes = null;
		if(prevCode.contains("-")){
			prevCodes = prevCode.split("-");
		}else if(prevCode.contains(".")){
			prevCodes = prevCode.split("\\.");
		}else{
			prevCodes = new String[1];
			prevCodes[0] = prevCode;
		}
		if(code.contains("-")){
			codes = code.split("-");
		}else if(code.contains(".")){
			codes = code.split("\\.");
		}else{
			codes = new String[1];
			codes[0] = code;
		}
		
		map.put("prev", prevCodes);
		map.put("current", codes);
		return map;
	}
	
	public int compareCode(StdDisease current,StdDisease prev){
		String thisCode = current.getCode(); 
		String code = prev.getCode();   
		Map<String,String[]> map = splitCode(code, thisCode);
		String[] codes = map.get("prev");
		String[] thisCodes = map.get("current");
	
			if(thisCodes.length==2 && codes.length==2){
				if(code.contains(".")){
					if(codes[0].compareTo(thisCodes[0])>=0){
						if(codes[0].compareTo(thisCodes[1])<=0){
							return 1;
						}
					}else{
						return -1;
					}
				}else{
					if(codes[0].substring(0, 1).compareTo(thisCodes[0].substring(0,1))<0){
						return -1;
					}else if(codes[0].substring(0, 1).compareTo(thisCodes[0].substring(0,1))>0){
							return 1;
					}else{
						if(codes[0].compareTo(thisCodes[0])>=0){
							if(codes[0].compareTo(thisCodes[1])>0){
								
								if(codes[1].compareTo(thisCodes[0])>0){
									if(codes[1].compareTo(thisCodes[1])>=0){
										return 1;
									}else{
										return -1;
									}
								}
								
							}else{
								if(codes[1].compareTo(thisCodes[0])>0){
									if(codes[1].compareTo(thisCodes[1])<=0){
										return 1;
									}else{
										return -1;
									}
								}
							}
						}else{
							if(codes[1].compareTo(thisCodes[0])>0){
								
								if(codes[1].compareTo(thisCodes[1])>=0){
									return -1;
								}
								
							}else{
								return -1;
							}
						}
					}
				}
			}else if(thisCodes.length==2  && codes.length==1){
					if(codes[0].compareTo(thisCodes[0])>=0){
						if(codes[0].compareTo(thisCodes[1])<=0){
							return 1;
						}
					}else{
						return -1;
					}
				
			}else if(thisCodes.length==1  && codes.length==2){
	
				if(thisCodes[0].compareTo(codes[0])<0){
					return 1;
				}else{
					if(thisCodes[0].compareTo(codes[1])<=0){
						return -1;
					}else{
						return -1;
					}
				}
			}
		return 1;
}

	
	public int contains(StdDisease current,StdDisease prev) {
		String currentCode = current.getCode();
		String prevCode = prev.getCode();
		prev.setName(prev.getCode());
		Map<String,String[]> map = splitCode(currentCode,prevCode);
		String[] currentCodes = map.get("prev");
		String[] prevCodes =map.get("current");
		if(!prevCode.contains("-") && !currentCode.contains("-")){
			if(!currentCodes[0].substring(0,1).equals(prevCodes[0].substring(0,1))){
				return -1;
			}else{//—— 。              —— 无。         —— ——
				if(currentCodes.length==2 && prevCodes.length==2){
					String dotCode = "";
					if(prevCodes[1].contains("+")){
						dotCode = prevCodes[1].substring(0,1);
					}else{
						if(prevCodes[1].length()==1){
							dotCode = prevCodes[1];
						}else{
							dotCode = prevCodes[1].substring(0,1);
						}
					}
						if(currentCodes[1].length()>1){
							if(prevCodes[1].length()<3){
								if(currentCodes[1].substring(0,1).equals(dotCode)){
									
									return 1;
								}
							}
							
						}else{
							if(currentCodes[0].equals(prevCodes[0])){
								if(currentCodes[1].substring(0,1).equals(dotCode)){
									return 1;
								}
							}
					
						
					}
				}else if(currentCodes.length==1 && prevCodes.length==1){
					return -1;
				}else{
					if(currentCodes.length==2){
						String subCode = prevCodes[0];
						if(prevCode.contains("+")){
							subCode = prevCodes[0].substring(0,prevCodes[0].indexOf("+"));
						}
						if(currentCodes[0].equals(subCode)){
							return 1;
							
						}
						
					}
				}
			}
		}else{
			if(currentCodes.length==2 && prevCodes.length==2){
				if(currentCode.contains(".")){
					
					if(prevCodes[0].compareTo(currentCodes[0])<=0){
						if(prevCodes[1].compareTo(currentCodes[0])>=0){
							return 1;
						}
					}
				}else if(currentCode.contains("-") && prevCode.contains("-")){
					if(currentCodes[0].compareTo(prevCodes[0])>=0){
						if(currentCodes[0].compareTo(prevCodes[1])<=0){
							return 1;
						}
					}
				}if(prevCode.contains(".")){
					if(prevCodes[0].compareTo(currentCodes[0])>=0){
						if(prevCodes[0].compareTo(currentCodes[1])<=0){
							return 1;
						}
					}else{
						return -1;
					}
				}
			}else if (currentCodes.length == 1 && prevCodes.length == 2) {

				if (currentCodes[0].compareTo(prevCodes[0]) < 0) {
					return -1;
				} else {
					if (currentCodes[0].compareTo(prevCodes[1]) <= 0) {
						return 1;
					}
				}
			}else if(currentCodes.length==2  && prevCodes.length==1){
				if(prevCodes[0].compareTo(currentCodes[0])>=0){
					if(prevCodes[0].compareTo(currentCodes[1])<=0){
						return 1;
					}
				}else{
					return -1;
				}
			
		}
		}
		return -1;
	}
	
	
}
