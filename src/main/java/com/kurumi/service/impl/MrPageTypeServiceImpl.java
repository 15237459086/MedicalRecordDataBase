package com.kurumi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurumi.datasource.TargetDataSource;
import com.kurumi.mapper.MrPageTypeMapper;
import com.kurumi.mapper.MrPrinterTypeMapper;
import com.kurumi.pojo.MrPageType;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.MrPageTypeService;

@Service
public class MrPageTypeServiceImpl implements MrPageTypeService{
	
	@Autowired
	private MrPageTypeMapper mrPageTypeMapper;
	
	@Autowired
	private MrPrinterTypeMapper mrPrinterTypeMapper;

	@Override
	@TargetDataSource(name="ds1")
	@Transactional
	public int deleteByPrimaryKey(Integer id) {
		return mrPageTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	@TargetDataSource(name="ds1")
	@Transactional
	public int insertMrPage(MrPageType record) {
		return mrPageTypeMapper.insertMrPage(record);
	}

	@Override
	@TargetDataSource(name="ds1")
	public MrPageType selectByPrimaryKey(Integer id) {
		return mrPageTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	@TargetDataSource(name="ds1")
	@Transactional
	public int updateByPrimaryKey(MrPageType record) {
		return mrPageTypeMapper.updateByPrimaryKey(record);
	}

	@Override
	@TargetDataSource(name="ds1")
	public List<Map<String, Object>> getMrPageTypes(BasicDataQuery params) {
		return mrPageTypeMapper.getMrPageTypes(params);
	}

	@Override
	@TargetDataSource(name="ds1")
	public int getCountByParams(BasicDataQuery params) {
		return mrPageTypeMapper.getCountByParams(params);
	}

	@Override
	@TargetDataSource(name="ds1")
	public boolean validateIsUse(Integer id) {
		boolean flag= false;
		int count = mrPageTypeMapper.validateIsUse(id);
		if(count==0){
			count = mrPageTypeMapper.getPageRangeByPageTypeId(id);
			if(count==0){
				flag = true;
			}
		}
		return flag;
	}

}
