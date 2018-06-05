package com.kurumi.mapper;

import java.util.List;

import com.kurumi.pojo.StdOperation;
import com.kurumi.query.BasicDataQuery;


public interface StdOperationMapper {
	
	int deleteByPrimaryKey(String code);

    int insert(StdOperation record);

    StdOperation selectByPrimaryKey(String code);

    int updateByPrimaryKey(StdOperation record);

    List<StdOperation> getStdOperations(BasicDataQuery params);
    
    int getCountByParams(BasicDataQuery params);
   
}