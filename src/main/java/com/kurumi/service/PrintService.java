package com.kurumi.service;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.MrPrinterType;
import com.kurumi.query.BasicDataQuery;

public interface PrintService {
	
	List<Map<String,Object>> getMrPrintTypes();
	
	List<Map<String,Object>> getMrPageTypes();
	
	List<Integer> getMrPageTypeIdsByPrintTypeId(Integer printerTypeId);
	
	int updateMrPrinterRanges(Integer printerTypeId,List<Integer> pageTypeIds);
	
	int deleteByPrimaryKey(Integer id);

    int insertMrPrintType(MrPrinterType record);

    MrPrinterType selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(MrPrinterType record);

    
    
    List<Map<String, Object>> getPageTypeList(Integer hospitalId);
    
    int getCountByParams(BasicDataQuery params);
    
   // boolean validateIsUse(Integer id);

}
