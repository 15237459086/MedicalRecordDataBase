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
	
	List<Map<String,Object>> getAllBasicEncoding(@Param("tableName")String tableName);
	
	
	 
}
