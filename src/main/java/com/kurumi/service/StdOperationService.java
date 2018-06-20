package com.kurumi.service;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.StdOperation;
import com.kurumi.query.OperationQuery;

public interface StdOperationService {
	
	List<Map<String,Object>> getOperationByOperationQuery(OperationQuery params);
	
	int getOperationCountByOperationQuery(OperationQuery params);
	
	int insert(StdOperation record);
	
	Map<String,Object> getBaseData();
	
	StdOperation selectByPrimaryKey(String code);
	
	int deleteByPrimaryKey(String code);

    int updateByPrimaryKey(StdOperation record);

    
    

}
