package com.kurumi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurumi.datasource.TargetDataSource;
import com.kurumi.mapper.BasicEncodingMapper;
import com.kurumi.pojo.BasicEncoding;
import com.kurumi.query.BasicEncodingQuery;
import com.kurumi.service.BasicEncodingService;

@Service
public class BasicEncodingServiceImpl implements BasicEncodingService{
	
	@Autowired
	private BasicEncodingMapper basicEncodingMapper;

	@Override
	@TargetDataSource(name="ds1")
	public List<Map<String, Object>> getBasicEncoding(BasicEncodingQuery params) {
		return basicEncodingMapper.getBasicEncoding(params);
	}

	@Override
	@TargetDataSource(name="ds1")
	public int getBasicEncodingCount(BasicEncodingQuery params) {
		return basicEncodingMapper.getBasicEncodingCount(params);
	}

	@Override
	@TargetDataSource(name="ds1")
	public BasicEncoding getBasicEncodingById(Map<String,Object> map) {
		return basicEncodingMapper.getBasicEncodingById(map);
	}

	@Override
	@TargetDataSource(name="ds1")
	@Transactional
	public int updateBasicEncodingById(BasicEncoding basic) {
		return basicEncodingMapper.updateBasicEncodingById(basic);
	}

	@Override
	@TargetDataSource(name="ds1")
	@Transactional
	public int deleteBasicEncodingById(Map<String,Object> map) {
		return basicEncodingMapper.deleteBasicEncodingById(map);
	}

	@Override
	@TargetDataSource(name="ds1")
	@Transactional
	public int insertBasicEncoding(BasicEncoding basicData) {
		BasicEncodingQuery params = new BasicEncodingQuery();
		params.setCode(basicData.getCode());
		params.setTableName(basicData.getTableName());
		int count = basicEncodingMapper.getBasicEncodingCount(params);
		if(count != 0){
			return 2;
		}
		return basicEncodingMapper.insertBasicEncoding(basicData);
	}

	@Override
	@TargetDataSource(name="ds1")
	@Transactional
	public int updateBasicEncoding(BasicEncoding basicData) {
		// TODO Auto-generated method stub
		int count = basicEncodingMapper.validateRepeatByIdAndCode(basicData.getTableName(),basicData.getId(), basicData.getCode());
		if(count != 0){
			return 2;
		}
		return basicEncodingMapper.updateBasicEncoding(basicData);
	}
	
	
	

	

}
