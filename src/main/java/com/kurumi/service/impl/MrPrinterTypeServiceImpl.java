package com.kurumi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurumi.datasource.TargetDataSource;
import com.kurumi.mapper.MrPageTypeMapper;
import com.kurumi.mapper.MrPrinterTypeMapper;
import com.kurumi.pojo.MrPrinterType;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.MrPrinterTypeService;
import com.kurumi.util.StringUtil;

@Service
public class MrPrinterTypeServiceImpl implements MrPrinterTypeService {
	
	@Autowired
	private MrPrinterTypeMapper mrPrinterTypeMapper;
	
	@Autowired
	private MrPageTypeMapper mrPageTypeMapper;

	@Override
	@TargetDataSource(name="ds1")
	@Transactional
	public int deleteByPrimaryKey(Integer id) {
		return mrPrinterTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	@TargetDataSource(name="ds1")
	@Transactional
	public int insertMrPrintType(MrPrinterType record) {
		
		int count = mrPrinterTypeMapper.insertMrPrintType(record);
		if(count>0){
			List<MrPrinterType> list = new ArrayList<MrPrinterType>();
			
			if(StringUtil.meaningStr(record.getPageTypeIds())!=null){
				String mrPageTypeIds = record.getPageTypeIds();
				String[] pageTypeIds = mrPageTypeIds.split(",");
				
				MrPrinterType bean = null;
				for(int i=0;i<pageTypeIds.length;i++){
					bean = new MrPrinterType();
					
					bean.setPrintTypeId(record.getPrintTypeId());
					bean.setMrPageTypeId(Integer.valueOf(pageTypeIds[i]));
					
					list.add(bean);
				}
				count = mrPrinterTypeMapper.insertMrPrinterRange(list);
			}
		}
		return count;
	}

	@Override
	@TargetDataSource(name="ds1")
	public MrPrinterType selectByPrimaryKey(Integer id) {
		return mrPrinterTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	@TargetDataSource(name="ds1")
	@Transactional
	public int updateByPrimaryKey(MrPrinterType record) {
		
		int count =  mrPrinterTypeMapper.updateByPrimaryKey(record);
		
		if(StringUtil.meaningStr(record.getPageTypeIds())!=null){
			if(count>0){
				
				
				//目前中间表medical_printer_range没有外建，所以在修改时未验证提示

				String printRangIds= String.valueOf(mrPrinterTypeMapper.getPrintRangeByPrintTypeId(record.getPrintTypeId()));
				
				count = mrPrinterTypeMapper.batchDeletePrintRange(printRangIds);
				if(count>0){
					List<MrPrinterType> list = new ArrayList<MrPrinterType>();
					String mrPageTypeIds = record.getPageTypeIds();
					String[] pageTypeIds = mrPageTypeIds.split(",");
					
					MrPrinterType bean = null;
					for(int i=0;i<pageTypeIds.length;i++){
						bean = new MrPrinterType();
						
						bean.setPrintTypeId(record.getPrintTypeId());
						bean.setMrPageTypeId(Integer.valueOf(pageTypeIds[i]));
						
						list.add(bean);
					}
					
					count = mrPrinterTypeMapper.insertMrPrinterRange(list);
				}
				
			}
		}
		return count;
	}

	@Override
	@TargetDataSource(name="ds1")
	public List<Map<String, Object>> getMrPrintTypes(BasicDataQuery params) {
		return mrPrinterTypeMapper.getMrPrintTypes(params);
	}

	@Override
	@TargetDataSource(name="ds1")
	public int getCountByParams(BasicDataQuery params) {
		return mrPrinterTypeMapper.getCountByParams(params);
	}

	/*@Override
	@TargetDataSource(name="ds1")
	public boolean validateIsUse(Integer id) {
		boolean flag= false;
		int count = mrPrinterTypeMapper.validateIsUse(id);
		if(count==0){
			flag = true;
		}
		return flag;
	}*/

	@Override
	@TargetDataSource(name="ds1")
	public List<Map<String, Object>> getPageTypeList(Integer hospitalId) {
		return mrPageTypeMapper.getPageTypeListByHospitalId(hospitalId);
	}
}
