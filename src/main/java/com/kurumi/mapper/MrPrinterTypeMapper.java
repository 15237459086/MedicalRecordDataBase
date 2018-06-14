package com.kurumi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kurumi.pojo.MrPrinterType;
import com.kurumi.query.BasicDataQuery;

public interface MrPrinterTypeMapper {
	
	List<Map<String,Object>> getMrPrintTypes();
	    
    List<Map<String,Object>> getMrPageTypes();
    
    List<Integer> getMrPageTypeIdsByPrintTypeId(Integer printerTypeId);
	
    int deleteByPrintTypeId(@Param("printerTypeId")Integer printerTypeId);
    
    int insertPrinterRange(@Param("printerTypeId")Integer printerTypeId,@Param("list")List<Integer> pageTypeIds);
	
	int deleteByPrimaryKey(Integer id);

    int insertMrPrintType(MrPrinterType record);
    
    int insertMrPrinterRange(List<MrPrinterType> list);

    MrPrinterType selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(MrPrinterType record);

   
    
    String getPrintRangeByPrintTypeId(Integer id);
    
    int getCountByParams(BasicDataQuery params);
    
    int batchDeletePrintRange(String id);
    
    //int validateIsUse(Integer id);

}
