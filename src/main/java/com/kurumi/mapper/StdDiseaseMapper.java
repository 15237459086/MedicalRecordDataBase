package com.kurumi.mapper;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.StdDisease;
import com.kurumi.query.BasicDataQuery;

public interface StdDiseaseMapper {
	int deleteByPrimaryKey(String code);

    int insert(StdDisease record);

    StdDisease selectByPrimaryKey(String code);

    int updateByPrimaryKey(StdDisease record);

    List<StdDisease> getDiseases(BasicDataQuery params);
    
    int getCountByParams(BasicDataQuery params);
    
   int validateCodeIsUnique(String code);
    
  //模糊查询查询国际疾病编号
    List<Map<String,Object>> queryDiseaseByLikeCode(String diseaseCode);
    
    //模糊查询查询国际疾病索引码
    List<Map<String,Object>> queryDiseaseByLikeIndexCode(String diseaseIndexCode);
    
    //模糊查询查询国际疾病名称
    List<Map<String,Object>> queryDiseaseByLikeName(String diseaseName);
    
}