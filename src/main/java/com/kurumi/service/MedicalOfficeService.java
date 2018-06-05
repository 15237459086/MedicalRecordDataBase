package com.kurumi.service;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.MedicalOffice;
import com.kurumi.query.BasicDataQuery;

public interface MedicalOfficeService {
	int deleteByPrimaryKey(Integer id);

    int insert(MedicalOffice record);

    MedicalOffice selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(MedicalOffice record);

    List<Map<String,Object>> getMedicalOffices(BasicDataQuery params);
    
    int getCountByParams(BasicDataQuery params);
    
    boolean validateIsUse(Integer id);
}
