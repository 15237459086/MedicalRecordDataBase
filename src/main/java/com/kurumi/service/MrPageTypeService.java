package com.kurumi.service;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.MrPageType;
import com.kurumi.query.BasicDataQuery;

public interface MrPageTypeService {
	
	int deleteByPrimaryKey(Integer id);
	
    int insertMrPage(MrPageType record);

    MrPageType selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(MrPageType record);

    List<Map<String,Object>> getMrPageTypes(BasicDataQuery params);
    
    int getCountByParams(BasicDataQuery params);
    
    boolean validateIsUse(Integer id);

}
