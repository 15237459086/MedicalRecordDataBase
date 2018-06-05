package com.kurumi.mapper;

import java.util.List;
import java.util.Map;

import com.kurumi.pojo.MrPrinterType;
import com.kurumi.query.BasicDataQuery;

public interface MrPrinterTypeMapper {
	
	int deleteByPrimaryKey(Integer id);

    int insertMrPrintType(MrPrinterType record);
    
    int insertMrPrinterRange(List<MrPrinterType> list);

    MrPrinterType selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(MrPrinterType record);

    List<Map<String,Object>> getMrPrintTypes(BasicDataQuery params);
    
    String getPrintRangeByPrintTypeId(Integer id);
    
    int getCountByParams(BasicDataQuery params);
    
    int batchDeletePrintRange(String id);
    
    //int validateIsUse(Integer id);

}
