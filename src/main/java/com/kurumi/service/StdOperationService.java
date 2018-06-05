package com.kurumi.service;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.StdOperation;
import com.kurumi.query.BasicDataQuery;

public interface StdOperationService {
	
	int deleteByPrimaryKey(String code);

    int insert(StdOperation record);

    StdOperation selectByPrimaryKey(String code);

    int updateByPrimaryKey(StdOperation record);

    List<StdOperation> getStdOperations(BasicDataQuery params);
    
    int getCountByParams(BasicDataQuery params);
    
    Map<String,List<Map<String,Object>>> getBasicData();

}
