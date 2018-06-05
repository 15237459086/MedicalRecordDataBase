package com.kurumi.mapper;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.MrPageType;
import com.kurumi.query.BasicDataQuery;

public interface MrPageTypeMapper {
	int deleteByPrimaryKey(Integer id);

    int insertMrPage(MrPageType record);
    
    MrPageType selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(MrPageType record);

    List<Map<String,Object>> getMrPageTypes(BasicDataQuery params);
    
    List<Map<String,Object>> getPageTypeListByHospitalId(Integer hospitalId);
    
    int getCountByParams(BasicDataQuery params);
    
    int validateIsUse(Integer id);
    
    int getPageRangeByPageTypeId(Integer id);

}
