package com.kurumi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kurumi.pojo.MrPrinterType;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.BasicEncodingService;
import com.kurumi.service.PrintService;
import com.kurumi.util.Result;

@Controller
@RequestMapping("/exportType")
public class MrExportTypeController {
	
	
	@Autowired
	private PrintService mrPrinterTypeService;
	
	@Autowired
	private BasicEncodingService basicEncodingService;
	
	@RequestMapping("/getMrPrinterTypes")
	public String getMrPrinterTypes(Model model,BasicDataQuery params){
		List<Map<String, Object>> basics = mrPrinterTypeService.getMrPrintTypes();
		int count = mrPrinterTypeService.getCountByParams(params);
		params.setTotalCounts(count);
		List<Map<String, Object>> hospitals = basicEncodingService.getBasicDataList("hospital");
		model.addAttribute("hospitals", hospitals);
		model.addAttribute("count",count);
		model.addAttribute("basics", basics);
		model.addAttribute("basicDataQuery", params);
		return "basic/mrexporttypes";
	}
	
	@RequestMapping("/addMrPrinterTypePage")
	public String addMrPrinterTypePage(Model model){
		List<Map<String, Object>> hospitals = basicEncodingService.getBasicDataList("hospital");
		model.addAttribute("hospitals", hospitals);
		return "basic/addmrexporttype";
	}
	
	@ResponseBody
	@RequestMapping("/getPageTypeListByHospitalId")
	public Result getPageTypeListByHospitalId(Integer hospitalId){
		if(hospitalId!=null){
			List<Map<String, Object>> prageTypeList = mrPrinterTypeService.getPageTypeList(hospitalId);
			return new Result(true,"获取标签类型列表成功",prageTypeList);
		}else{
			return new Result(false);
		}
	}
	
	
	@ResponseBody
	@RequestMapping("/insertMrPrinterType")
	public Result insertMrPrinterType(MrPrinterType basic){
		if (basic != null) {
			int result = mrPrinterTypeService.insertMrPrintType(basic);
			if (result > 0) {
				return new Result(true, "新增信息成功");
			}
		}
		return new Result(false, "新增信息失败");
	}
	
	@RequestMapping("/showMrPrinterType")
	public String showMrPrinterType(Model model,Integer id,Integer currentPage,Integer pageSize,String name,Integer hospitalId){
		MrPrinterType basic = mrPrinterTypeService.selectByPrimaryKey(id);
		List<Map<String, Object>> hospitals = basicEncodingService.getBasicDataList("hospital");
		List<Map<String, Object>> pageTypeList = mrPrinterTypeService.getPageTypeList(basic.getHospitalId());
		model.addAttribute("pageTypeList", pageTypeList);
		model.addAttribute("hospitals", hospitals);
		model.addAttribute("basic", basic);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("name", name);
		model.addAttribute("hospitalId", hospitalId);
		return "basic/updatemrexporttype";
	}
	
	@ResponseBody
	@RequestMapping("/updateMrPrinterType")
	public Result updateMrPrinterType(MrPrinterType basic){
		if (basic != null) {
			int result = mrPrinterTypeService.updateByPrimaryKey(basic);
			if (result > 0) {
				return new Result(true, "修改信息成功");
			}
		}
		return new Result(false, "修改信息失败");
	}
	
	
	
	@ResponseBody
	@RequestMapping("/deleteMrPrinterType")
	public Result deleteMrPrinterType(Integer id){
		int result = mrPrinterTypeService.deleteByPrimaryKey(id);
		if (result > 0) {
			return new Result(true, "删除信息成功");
		} else {
			return new Result(false, "删除信息失败");
		}
	}
}
