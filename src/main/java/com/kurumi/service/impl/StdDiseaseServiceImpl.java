package com.kurumi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurumi.datasource.TargetDataSource;
import com.kurumi.mapper.StdDiseaseMapper;
import com.kurumi.pojo.StdDisease;
import com.kurumi.query.DiseaseQuery;
import com.kurumi.service.StdDiseaseService;
@Service
public class StdDiseaseServiceImpl implements StdDiseaseService{

	@Autowired
	private StdDiseaseMapper stdDiseaseMapper;
	
	@Override
	@TargetDataSource(name="ds1")
	public List<Map<String,Object>> getDiseasesByDiseaseQuery(DiseaseQuery params){
		return stdDiseaseMapper.getDiseasesByDiseaseQuery(params);
	}

	@Override
	@TargetDataSource(name="ds1")
	public int getDiseasesCountByDiseaseQuery(DiseaseQuery params) {
		return stdDiseaseMapper.getDiseasesCountByDiseaseQuery(params);
	}

	@Override
	@Transactional
	@TargetDataSource(name="ds1")
	public int insert(StdDisease record) {
		int result = stdDiseaseMapper.getDiseaseCountByPrimaryKey(record.getCode());
		if(result >=1){
			return 2;
		}
		if(record.getFitManCodeFlag() == null){
			record.setFitManCodeFlag("0");
		}
		if(record.getFitWomanCodeFlag()== null){
			record.setFitWomanCodeFlag("0");
		}
		if(record.getUnDeathFlag()== null){
			record.setUnDeathFlag("0");
		}
		if(record.getUnPrimaryFlag()== null){
			record.setUnPrimaryFlag("0");
		}
		if(record.getAttentionFlag()== null){
			record.setAttentionFlag("0");
		}
		return stdDiseaseMapper.insert(record);
	}
	
	@Override
	@Transactional
	@TargetDataSource(name="ds1")
	public int deleteByPrimaryKey(String code) {
		return stdDiseaseMapper.deleteByPrimaryKey(code);
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
		StdDisease stdDisease = stdDiseaseMapper.selectByPrimaryKey(record.getCode());
		if(stdDisease == null){
			return -1;
		}
		stdDisease.setName(record.getName());
		stdDisease.setEnName(record.getEnName());
		stdDisease.setIndexCode(record.getIndexCode());
		stdDisease.setAliasName(record.getAliasName());
		stdDisease.setAliasNameIndex(record.getAliasNameIndex());
		stdDisease.setFitManCodeFlag(record.getFitManCodeFlag());
		stdDisease.setFitWomanCodeFlag(record.getFitWomanCodeFlag());
		stdDisease.setUnDeathFlag(record.getUnDeathFlag());
		
		stdDisease.setUnPrimaryFlag(record.getUnPrimaryFlag());
		stdDisease.setAttentionFlag(record.getAttentionFlag());
		stdDisease.setAttentionComment(record.getAttentionComment());
		
		stdDisease.setComment(record.getComment());
		return stdDiseaseMapper.updateByPrimaryKey(stdDisease);
	}

}
