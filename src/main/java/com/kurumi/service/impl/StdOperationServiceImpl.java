package com.kurumi.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurumi.datasource.TargetDataSource;
import com.kurumi.mapper.BasicEncodingMapper;
import com.kurumi.mapper.StdOperationMapper;
import com.kurumi.pojo.StdOperation;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.StdOperationService;

@Service
public class StdOperationServiceImpl implements StdOperationService{
	
	@Autowired
	private StdOperationMapper stdOperationMapper;
	
	@Autowired
	private BasicEncodingMapper basicEncodingMapper;

	@Override
	@Transactional
	@TargetDataSource(name="ds1")
	public int deleteByPrimaryKey(String code) {
		return stdOperationMapper.deleteByPrimaryKey(code);
	}

	@Override
	@Transactional
	@TargetDataSource(name="ds1")
	public int insert(StdOperation record) {
		return stdOperationMapper.insert(record);
	}

	@Override
	@TargetDataSource(name="ds1")
	public StdOperation selectByPrimaryKey(String code) {
		return stdOperationMapper.selectByPrimaryKey(code);
	}

	@Override
	@TargetDataSource(name="ds1")
	public int updateByPrimaryKey(StdOperation record) {
		return stdOperationMapper.updateByPrimaryKey(record);
	}

	@Override
	@TargetDataSource(name="ds1")
	public List<StdOperation> getStdOperations(BasicDataQuery params) {
		return stdOperationMapper.getStdOperations(params);
	}

	@Override
	@TargetDataSource(name="ds1")
	public int getCountByParams(BasicDataQuery params) {
		return stdOperationMapper.getCountByParams(params);
	}

	@Override
	@TargetDataSource(name="ds1")
	public Map<String, List<Map<String, Object>>> getBasicData() {
		Map<String, List<Map<String, Object>>> map = new HashMap<>();
		map.put("incisionLevels", basicEncodingMapper.getBasicDataList("std_incision_level"));
		map.put("opsLevels", basicEncodingMapper.getBasicDataList("std_ops_level"));
		map.put("opsMarks", basicEncodingMapper.getBasicDataList("std_ops_operation_mark"));
		map.put("stdAttributeCodes", basicEncodingMapper.getBasicDataList("std_attributes_code"));
		return map;
	}

}
