package com.kurumi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kurumi.pojo.StdOperation;
import com.kurumi.query.OperationQuery;


public interface StdOperationMapper {
	
	List<Map<String,Object>> getOperationByOperationQuery(OperationQuery params);
	
	int getOperationCountByOperationQuery(OperationQuery params);
	
	int getOperationCountByPrimaryKey(@Param("code") String code);
	
	int insert(StdOperation record);
	
	StdOperation selectByPrimaryKey(String code);
	
	int deleteByPrimaryKey(String code);

    int updateByPrimaryKey(StdOperation record);
   
}