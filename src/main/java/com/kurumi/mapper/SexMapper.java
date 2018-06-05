package com.kurumi.mapper;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.Sex;

public interface SexMapper {
   
    int deleteByPrimaryKey(Integer id);

    int insert(Sex record);

    Sex selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Sex record);
    
    
    /**
     * 获取所有性别
     * @return
     */
    List<Map<String,Object>> getSexes();
    
}