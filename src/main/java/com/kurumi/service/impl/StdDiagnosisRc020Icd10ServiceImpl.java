package com.kurumi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurumi.datasource.TargetDataSource;
import com.kurumi.mapper.StdDiagnosisRc020Icd10Mapper;
import com.kurumi.pojo.StdDiagnosisRc020Icd10;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.StdDiagnosisRc020Icd10Service;

@Service
public class StdDiagnosisRc020Icd10ServiceImpl implements StdDiagnosisRc020Icd10Service{
	
	@Autowired
	private StdDiagnosisRc020Icd10Mapper stdDiagnosisRc020Icd10Mapper;

	@TargetDataSource(name="ds1")
	@Override
	public int getCountByParams(BasicDataQuery params) {
		return stdDiagnosisRc020Icd10Mapper.getCountByParams(params);
	}

	@TargetDataSource(name="ds1")
	@Override
	public List<StdDiagnosisRc020Icd10> getStdDiagnosisRc020Icd10s(
			BasicDataQuery params) {
		return stdDiagnosisRc020Icd10Mapper.getStdDiagnosisRc020Icd10s(params);
	}

	@Transactional
	@TargetDataSource(name="ds1")
	@Override
	public int deleteByPrimaryKey(String code) {
		return stdDiagnosisRc020Icd10Mapper.deleteByPrimaryKey(code);
	}

	@Transactional
	@TargetDataSource(name="ds1")
	@Override
	public int insert(StdDiagnosisRc020Icd10 record) {
		return stdDiagnosisRc020Icd10Mapper.insert(record);
	}

	@TargetDataSource(name="ds1")
	@Override
	public StdDiagnosisRc020Icd10 selectByPrimaryKey(String code) {
		return stdDiagnosisRc020Icd10Mapper.selectByPrimaryKey(code);
	}

	@Transactional
	@TargetDataSource(name="ds1")
	@Override
	public int updateByPrimaryKey(StdDiagnosisRc020Icd10 record) {
		return stdDiagnosisRc020Icd10Mapper.updateByPrimaryKey(record);
	}

}
