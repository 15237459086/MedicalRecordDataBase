package com.kurumi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurumi.datasource.TargetDataSource;
import com.kurumi.mapper.SexMapper;
import com.kurumi.pojo.Sex;
import com.kurumi.service.SexService;

@Transactional
@Service
public class SexServiceImpl implements SexService {

	@Autowired
	private SexMapper sexMapper;
	
	@TargetDataSource(name="ds1")
	@Transactional(readOnly= true)
	@Override
	public List<Map<String, Object>> getSexes() {
		// TODO Auto-generated method stub
		return sexMapper.getSexes();
	}

	@Override
	@TargetDataSource(name="ds1")
	public Sex getSexById(Integer id) {
		return sexMapper.selectByPrimaryKey(id);
	}

	@Override
	@TargetDataSource(name="ds1")
	public int updateSexById(Sex sex) {
		return sexMapper.updateByPrimaryKey(sex);
	}

	@Override
	@TargetDataSource(name="ds1")
	public int deleteSexById(Integer id) {
		return sexMapper.deleteByPrimaryKey(id);
	}

	@Override
	@TargetDataSource(name="ds1")
	public int insertSex(Sex sex) {
		return sexMapper.insert(sex);
	}

}
