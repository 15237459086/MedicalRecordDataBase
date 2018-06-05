package com.kurumi.service;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.Sex;

public interface SexService {

	List<Map<String,Object>> getSexes();
	Sex getSexById(Integer id);
	int updateSexById(Sex sex);
	int deleteSexById (Integer id);
	int insertSex (Sex sex);
}
