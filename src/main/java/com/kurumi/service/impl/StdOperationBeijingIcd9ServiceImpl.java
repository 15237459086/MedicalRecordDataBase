package com.kurumi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurumi.datasource.TargetDataSource;
import com.kurumi.mapper.StdOperationBeijingIcd9Mapper;
import com.kurumi.pojo.StdOperationBeijingIcd9;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.StdOperationBeijingIcd9Service;

@Service
public class StdOperationBeijingIcd9ServiceImpl implements StdOperationBeijingIcd9Service {
	
	@Autowired
	private StdOperationBeijingIcd9Mapper stdOperationBeijingIcd9Mapper;

	@Transactional
	@TargetDataSource(name="ds1")
	@Override
	public int deleteByPrimaryKey(String code) {
		return stdOperationBeijingIcd9Mapper.deleteByPrimaryKey(code);
	}

	@Transactional
	@TargetDataSource(name="ds1")
	@Override
	public int insert(StdOperationBeijingIcd9 record) {
		return stdOperationBeijingIcd9Mapper.insert(record);
	}

	@TargetDataSource(name="ds1")
	@Override
	public StdOperationBeijingIcd9 selectByPrimaryKey(String code) {
		return stdOperationBeijingIcd9Mapper.selectByPrimaryKey(code);
	}

	@Transactional
	@TargetDataSource(name="ds1")
	@Override
	public int updateByPrimaryKey(StdOperationBeijingIcd9 record) {
		return stdOperationBeijingIcd9Mapper.updateByPrimaryKey(record);
	}

	@TargetDataSource(name="ds1")
	@Override
	public List<StdOperationBeijingIcd9> getStdOperationIcd9s(
			BasicDataQuery params) {
		return stdOperationBeijingIcd9Mapper.getStdOperationIcd9s(params);
	}

	@TargetDataSource(name="ds1")
	@Override
	public int getCountByParams(BasicDataQuery params) {
		return stdOperationBeijingIcd9Mapper.getCountByParams(params);
	}

}
