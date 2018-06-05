package com.kurumi.mapper;

import com.kurumi.pojo.StdOperationBeijingIcd9;
import com.kurumi.query.BasicDataQuery;

import java.util.List;

public interface StdOperationBeijingIcd9Mapper {
	int deleteByPrimaryKey(String code);

    int insert(StdOperationBeijingIcd9 record);

    StdOperationBeijingIcd9 selectByPrimaryKey(String code);

    int updateByPrimaryKey(StdOperationBeijingIcd9 record);

    List<StdOperationBeijingIcd9> getStdOperationIcd9s(BasicDataQuery params);
    
    int getCountByParams(BasicDataQuery params);
}