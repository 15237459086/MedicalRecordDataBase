package com.kurumi.mapper;

import java.util.List;

import com.kurumi.pojo.StdDiagnosisRc020Icd10;
import com.kurumi.query.BasicDataQuery;

public interface StdDiagnosisRc020Icd10Mapper {
	
    int getCountByParams(BasicDataQuery params);
    
    List<StdDiagnosisRc020Icd10> getStdDiagnosisRc020Icd10s(BasicDataQuery params);

    int deleteByPrimaryKey(String code);

    int insert(StdDiagnosisRc020Icd10 record);

    StdDiagnosisRc020Icd10 selectByPrimaryKey(String code);

    int updateByPrimaryKey(StdDiagnosisRc020Icd10 record);
    
}