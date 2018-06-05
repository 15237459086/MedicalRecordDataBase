package com.kurumi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kurumi.pojo.QualityControlStandard;

public interface QualityControlStandardMapper {

    int insert(QualityControlStandard record);
    
    int update(QualityControlStandard record);
    /**
	 * 获取第一级指控标准
	 * @return
	 */
	List<Map<String,Object>> getQualityControlOfFirstLevel();
	
	/**
	 * 依据上一级编号获取指控标准
	 * @return
	 */
	List<Map<String,Object>> getQualityControlByUpOneLevelCode(@Param("upOneLevelCode")String upOneLevelCode);
	
	int getQualityControlCountByCode(String code);
	
	int getQualityControlCountByCodeAndNotEQId(@Param("code")String code,@Param("id")Integer id);
	
	
}