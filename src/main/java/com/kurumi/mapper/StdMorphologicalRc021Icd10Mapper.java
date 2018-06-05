package com.kurumi.mapper;

import com.kurumi.pojo.StdMorphologicalRc021Icd10;
import com.kurumi.query.BasicDataQuery;

import java.util.List;

public interface StdMorphologicalRc021Icd10Mapper {
	
	int getCountByParams(BasicDataQuery params);
    
    List<StdMorphologicalRc021Icd10> getStdMorphologicalRc021Icd10(BasicDataQuery params);

    int deleteByPrimaryKey(String code);

    int insert(StdMorphologicalRc021Icd10 record);

    StdMorphologicalRc021Icd10 selectByPrimaryKey(String code);

    int updateByPrimaryKey(StdMorphologicalRc021Icd10 record);
}