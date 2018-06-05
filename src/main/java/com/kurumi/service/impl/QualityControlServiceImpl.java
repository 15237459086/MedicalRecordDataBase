package com.kurumi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurumi.datasource.TargetDataSource;
import com.kurumi.mapper.QualityControlStandardMapper;
import com.kurumi.pojo.QualityControlStandard;
import com.kurumi.service.QualityControlService;

@Service
public class QualityControlServiceImpl implements QualityControlService {
	
	@Autowired
	private QualityControlStandardMapper qualityControlStandardMapper;


	@Transactional
	@TargetDataSource(name="ds1")
	@Override
	public int insert(QualityControlStandard record) {
		if(qualityControlStandardMapper.getQualityControlCountByCode(record.getCode()) > 0){
			return 2;
		}
		return qualityControlStandardMapper.insert(record);
	}

	@TargetDataSource(name="ds1")
	@Override
	public List<Map<String, Object>> getQualityControlOfFirstLevel() {
		// TODO Auto-generated method stub
		return qualityControlStandardMapper.getQualityControlOfFirstLevel();
	}


	@TargetDataSource(name="ds1")
	@Override
	public List<Map<String, Object>> getQualityControlByUpOneLevelCode(String upOneLevelCode) {
		// TODO Auto-generated method stub
		return qualityControlStandardMapper.getQualityControlByUpOneLevelCode(String.format("%s__", upOneLevelCode));
	}

	@TargetDataSource(name="ds1")
	@Override
	public int update(QualityControlStandard record) {
		// TODO Auto-generated method stub
		if(qualityControlStandardMapper.getQualityControlCountByCodeAndNotEQId(record.getCode(),record.getId()) > 0){
			return 2;
		}
		return qualityControlStandardMapper.update(record);
	}

	

}
