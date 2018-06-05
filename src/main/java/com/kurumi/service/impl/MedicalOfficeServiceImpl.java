package com.kurumi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurumi.datasource.TargetDataSource;
import com.kurumi.mapper.MedicalOfficeMapper;
import com.kurumi.pojo.MedicalOffice;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.MedicalOfficeService;

@Service
public class MedicalOfficeServiceImpl implements MedicalOfficeService {
	
	@Autowired
	private MedicalOfficeMapper medicalOfficeMapper;

	@Override
	@TargetDataSource(name="ds1")
	@Transactional
	public int deleteByPrimaryKey(Integer id) {
		return medicalOfficeMapper.deleteByPrimaryKey(id);
	}

	@Override
	@TargetDataSource(name="ds1")
	@Transactional
	public int insert(MedicalOffice record) {
		return medicalOfficeMapper.insertMedicalOffice(record);
	}

	@Override
	@TargetDataSource(name="ds1")
	public MedicalOffice selectByPrimaryKey(Integer id) {
		return medicalOfficeMapper.selectByPrimaryKey(id);
	}

	@Override
	@TargetDataSource(name="ds1")
	@Transactional
	public int updateByPrimaryKey(MedicalOffice record) {
		return medicalOfficeMapper.updateByPrimaryKey(record);
	}

	@Override
	@TargetDataSource(name="ds1")
	public List<Map<String, Object>> getMedicalOffices(BasicDataQuery params) {
		return medicalOfficeMapper.getMedicalOffices(params);
	}

	@Override
	@TargetDataSource(name="ds1")
	public int getCountByParams(BasicDataQuery params) {
		return medicalOfficeMapper.getCountByParams(params);
	}

	@Override
	@TargetDataSource(name="ds1")
	public boolean validateIsUse(Integer id) {
		boolean flag = false;
		int count = medicalOfficeMapper.validateIsUse(id);
		if(count==0){
			flag = true;
		}
		return flag;
	}

}
