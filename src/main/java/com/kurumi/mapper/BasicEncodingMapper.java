package com.kurumi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kurumi.pojo.BasicEncoding;
import com.kurumi.query.BasicEncodingQuery;

public interface BasicEncodingMapper {
	List<Map<String,Object>> getBasicEncoding(BasicEncodingQuery params);
	
	int getBasicEncodingCount(BasicEncodingQuery params);
	
	int insertBasicEncoding (BasicEncoding basicData);
	
	int validateRepeatByIdAndCode(@Param("tableName")String tableName,@Param("id")Integer id,@Param("code")String code);
	 
	int updateBasicEncoding(BasicEncoding basicData);
	
	BasicEncoding getBasicEncodingById(Map<String,Object> map);
	int updateBasicEncodingById(BasicEncoding basic);
	int deleteBasicEncodingById (Map<String,Object> map);
	
	int validateIdTypeIsUse(Integer id);
	
	
	
	int validateSexIsUse(Integer id);
	
	int validateTreatmentIsUse(Map<String, Object> map);
	int validateHospitalTypeIsUse(Map<String, Object> map);
	
	List<Map<String,Object>> getBasicDataList(String tableName);
	
	int getFirstLevelMedicalByHospitalId(Integer id);
	
	int getMedicalOfficeByHospitalId(Integer id);
	
	int getPageTypeByHospitalId(Integer id);
	
	int getPrintTypeByHospitalId(Integer id);
	
	int validateResourceTypeIsUse(Integer id);
	
	 int validateStdAttributeCodeIsUse(Integer id);
	 
	 int getStdOperationByAttributeCodeId(Integer id);
	 
	 int validateIncisionAndOpsLevelAndOpsMarkIsUse(Map<String,Integer> map);
	 
	 int validateOpsMarkIsUseByOpeBeijingICD9(Map<String,Integer> map);
	 
}
