package com.kurumi.service;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.BasicEncoding;
import com.kurumi.query.BasicEncodingQuery;

public interface BasicEncodingService {
	List<Map<String,Object>> getBasicEncoding(BasicEncodingQuery params);
	
	
	int getBasicEncodingCount(BasicEncodingQuery params);
	
	int insertBasicEncoding(BasicEncoding basicData);
	
	int updateBasicEncoding(BasicEncoding basicData);
	
	BasicEncoding getBasicEncodingById(Map<String,Object> map);
	int updateBasicEncodingById(BasicEncoding basic);
	int deleteBasicEncodingById (Map<String,Object> map);
	
	boolean validateIdTypeIsUse(Integer id);
	
	
	
	boolean validateSexIsUse(Integer id);
	
	boolean validateTreatmentIsUse(Map<String,Object> map);
	boolean validateHospitalTypeIsUse(Map<String,Object> map);
	
	boolean validateHospitalIsUse(Integer id);
	
	boolean validateResourceTypeIsUse(Integer id);
	
	List<Map<String,Object>> getBasicDataList(String tableName);
	
	boolean validateStdAttributeCodeIsUse(Integer id);
	
	boolean validateIncisionAndOpsLevelAndOpsMarkIsUse(Map<String,Integer> map);
	
}
