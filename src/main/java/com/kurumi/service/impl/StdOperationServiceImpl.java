package com.kurumi.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurumi.datasource.TargetDataSource;
import com.kurumi.enums.TableNameEnum;
import com.kurumi.mapper.BasicEncodingMapper;
import com.kurumi.mapper.StdOperationMapper;
import com.kurumi.pojo.StdOperation;
import com.kurumi.query.OperationQuery;
import com.kurumi.service.StdOperationService;

@Service
public class StdOperationServiceImpl implements StdOperationService{
	
	@Autowired
	private StdOperationMapper stdOperationMapper;
	
	@Autowired
	private BasicEncodingMapper basicEncodingMapper;
	
	@Override
	@TargetDataSource(name="ds1")
	public List<Map<String,Object>> getOperationByOperationQuery(OperationQuery params) {
		return stdOperationMapper.getOperationByOperationQuery(params);
	}

	@Override
	@TargetDataSource(name="ds1")
	public int getOperationCountByOperationQuery(OperationQuery params) {
		return stdOperationMapper.getOperationCountByOperationQuery(params);
	}

	@Override
	@Transactional
	@TargetDataSource(name="ds1")
	public int insert(StdOperation record) {
		int result = stdOperationMapper.getOperationCountByPrimaryKey(record.getCode());
		if(result > 0){
			return 2;
		}
		return stdOperationMapper.insert(record);
	}

	
	@Override
	@TargetDataSource(name="ds1")
	public Map<String,Object> getBaseData() {
		Map<String,Object> baseDatas = new HashMap<>();
		baseDatas.put("incisionLevels", basicEncodingMapper.getAllBasicEncoding(TableNameEnum.StdIncisionLevel.getTableName()));
		baseDatas.put("opsLevels",basicEncodingMapper.getAllBasicEncoding(TableNameEnum.StdOpsLevel.getTableName()));
		baseDatas.put("opsMarks", basicEncodingMapper.getAllBasicEncoding(TableNameEnum.StdOpsMark.getTableName()));
		return baseDatas;
	}
	
	@Override
	@TargetDataSource(name="ds1")
	public StdOperation selectByPrimaryKey(String code) {
		return stdOperationMapper.selectByPrimaryKey(code);
	}
	
	@Override
	@TargetDataSource(name="ds1")
	public int updateByPrimaryKey(StdOperation record) {
		StdOperation stdOperation = stdOperationMapper.selectByPrimaryKey(record.getCode());
		if(stdOperation == null){
			return -1;
		}
		stdOperation.setName(record.getName());
		stdOperation.setEnName(record.getEnName());
		stdOperation.setIndexCode(record.getIndexCode());
		stdOperation.setAliasName(record.getAliasName());
		stdOperation.setAliasNameIndex(record.getAliasNameIndex());
		stdOperation.setOperationMarkCode(record.getOperationMarkCode());
		stdOperation.setOperationMarkName(record.getOperationMarkName());
		stdOperation.setIncisionLevelCode(record.getIncisionLevelCode());
		stdOperation.setIncisionLevelName(record.getIncisionLevelName());
		stdOperation.setOperationLevelCode(record.getOperationLevelCode());
		stdOperation.setOperationLevelName(record.getOperationLevelName());
		stdOperation.setComment(record.getComment());
		return stdOperationMapper.updateByPrimaryKey(stdOperation);
	}
	
	@Override
	@Transactional
	@TargetDataSource(name="ds1")
	public int deleteByPrimaryKey(String code) {
		return stdOperationMapper.deleteByPrimaryKey(code);
	}


}
