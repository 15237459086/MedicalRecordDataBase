package com.kurumi.mapper;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.MedicalOffice;
import com.kurumi.query.BasicDataQuery;

public interface MedicalOfficeMapper {

		int deleteByPrimaryKey(Integer id);

	    int insertMedicalOffice(MedicalOffice record);

	    MedicalOffice selectByPrimaryKey(Integer id);

	    int updateByPrimaryKey(MedicalOffice record);
	
	    List<Map<String,Object>> getMedicalOffices(BasicDataQuery params);
	    
	    int getCountByParams(BasicDataQuery params);
	    
	    int validateIsUse(Integer id);
}
