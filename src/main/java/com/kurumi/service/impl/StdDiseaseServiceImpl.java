package com.kurumi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurumi.datasource.TargetDataSource;
import com.kurumi.mapper.BasicEncodingMapper;
import com.kurumi.mapper.StdDiseaseMapper;
import com.kurumi.pojo.StdDisease;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.StdDiseaseService;
@Service
public class StdDiseaseServiceImpl implements StdDiseaseService{

	@Autowired
	private StdDiseaseMapper stdDiseaseMapper;
	@Autowired
	private BasicEncodingMapper basicEncodingMapper;

	@Override
	@Transactional
	@TargetDataSource(name="ds1")
	public int deleteByPrimaryKey(String code) {
		return stdDiseaseMapper.deleteByPrimaryKey(code);
	}

	@Override
	@Transactional
	@TargetDataSource(name="ds1")
	public int insert(StdDisease record) {
		return stdDiseaseMapper.insert(record);
	}

	@Override
	@TargetDataSource(name="ds1")
	public StdDisease selectByPrimaryKey(String code) {
		return stdDiseaseMapper.selectByPrimaryKey(code);
	}

	@Override
	@Transactional
	@TargetDataSource(name="ds1")
	public int updateByPrimaryKey(StdDisease record) {
		return stdDiseaseMapper.updateByPrimaryKey(record);
	}

	@Override
	@TargetDataSource(name="ds1")
	public List<StdDisease> getDiseases(BasicDataQuery params) {
		return stdDiseaseMapper.getDiseases(params);
	}

	@Override
	@TargetDataSource(name="ds1")
	public int getCountByParams(BasicDataQuery params) {
		return stdDiseaseMapper.getCountByParams(params);
	}

	@Override
	@TargetDataSource(name="ds1")
	public List<Map<String, Object>> getStdAttributeCodes() {
		return basicEncodingMapper.getBasicDataList("std_attributes_code");
	}

	@Override
	@TargetDataSource(name="ds1")
	public boolean validateCodeIsUnique(String code) {
		boolean result = false;
		int count = stdDiseaseMapper.validateCodeIsUnique(code);
		
		if(count==0){
			result = true;
		}
		
		return result;
	}

}
