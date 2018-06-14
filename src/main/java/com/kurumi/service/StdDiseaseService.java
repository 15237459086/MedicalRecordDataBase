package com.kurumi.service;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.StdDisease;
import com.kurumi.query.DiseaseQuery;

public interface StdDiseaseService {
	
	
	
	List<Map<String,Object>> getDiseasesByDiseaseQuery(DiseaseQuery params);
	 
	int getDiseasesCountByDiseaseQuery(DiseaseQuery params);
	
	int insert(StdDisease record);
	
	StdDisease selectByPrimaryKey(String code);

	int updateByPrimaryKey(StdDisease record);
	
	int deleteByPrimaryKey(String code);

    

   

   
    
    List<Map<String,Object>> getStdAttributeCodes();
    
   
    
    boolean validateCodeIsUnique(String code);
}
