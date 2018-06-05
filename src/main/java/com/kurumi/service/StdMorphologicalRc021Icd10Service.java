package com.kurumi.service;

import java.util.List;

import com.kurumi.pojo.StdMorphologicalRc021Icd10;
import com.kurumi.query.BasicDataQuery;

public interface StdMorphologicalRc021Icd10Service {
	
	
int getCountByParams(BasicDataQuery params);
    
    List<StdMorphologicalRc021Icd10> getStdMorphologicalRc021Icd10(BasicDataQuery params);

    int deleteByPrimaryKey(String code);

    int insert(StdMorphologicalRc021Icd10 record);

    StdMorphologicalRc021Icd10 selectByPrimaryKey(String code);

    int updateByPrimaryKey(StdMorphologicalRc021Icd10 record);

}
