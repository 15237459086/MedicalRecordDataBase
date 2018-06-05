package com.kurumi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurumi.datasource.TargetDataSource;
import com.kurumi.mapper.StdMorphologicalRc021Icd10Mapper;
import com.kurumi.pojo.StdMorphologicalRc021Icd10;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.StdMorphologicalRc021Icd10Service;

@Service
public class StdMorphologicalRc021Icd10ServiceImpl implements StdMorphologicalRc021Icd10Service{
	
	@Autowired
	private StdMorphologicalRc021Icd10Mapper stdMorphologicalRc021Icd10Mapper;

	@TargetDataSource(name="ds1")
	@Override
	public int getCountByParams(BasicDataQuery params) {
		return stdMorphologicalRc021Icd10Mapper.getCountByParams(params);
	}

	@TargetDataSource(name="ds1")
	@Override
	public List<StdMorphologicalRc021Icd10> getStdMorphologicalRc021Icd10(
			BasicDataQuery params) {
		return stdMorphologicalRc021Icd10Mapper.getStdMorphologicalRc021Icd10(params);
	}

	@Transactional
	@TargetDataSource(name="ds1")
	@Override
	public int deleteByPrimaryKey(String code) {
		return stdMorphologicalRc021Icd10Mapper.deleteByPrimaryKey(code);
	}

	@Transactional
	@TargetDataSource(name="ds1")
	@Override
	public int insert(StdMorphologicalRc021Icd10 record) {
		return stdMorphologicalRc021Icd10Mapper.insert(record);
	}

	@TargetDataSource(name="ds1")
	@Override
	public StdMorphologicalRc021Icd10 selectByPrimaryKey(String code) {
		return stdMorphologicalRc021Icd10Mapper.selectByPrimaryKey(code);
	}

	@Transactional
	@TargetDataSource(name="ds1")
	@Override
	public int updateByPrimaryKey(StdMorphologicalRc021Icd10 record) {
		return stdMorphologicalRc021Icd10Mapper.updateByPrimaryKey(record);
	}

}
