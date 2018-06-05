package com.kurumi.service;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.QualityControlStandard;

public interface QualityControlService {

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
   	List<Map<String,Object>> getQualityControlByUpOneLevelCode(String upOneLevelCode);
}
