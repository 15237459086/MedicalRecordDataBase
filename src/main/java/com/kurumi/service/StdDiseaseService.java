package com.kurumi.service;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.StdDisease;
import com.kurumi.query.BasicDataQuery;

public interface StdDiseaseService {
	int deleteByPrimaryKey(String code);

    int insert(StdDisease record);

    StdDisease selectByPrimaryKey(String code);

    int updateByPrimaryKey(StdDisease record);

    List<StdDisease> getDiseases(BasicDataQuery params);
    List<Map<String,Object>> getStdAttributeCodes();
    
    int getCountByParams(BasicDataQuery params);
    
    boolean validateCodeIsUnique(String code);
}
