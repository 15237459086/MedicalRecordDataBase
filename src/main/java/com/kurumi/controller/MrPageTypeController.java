package com.kurumi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kurumi.pojo.MrPageType;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.BasicEncodingService;
import com.kurumi.service.MrPageTypeService;
import com.kurumi.util.Result;

@Controller
@RequestMapping("/basic")
public class MrPageTypeController {
	@Autowired
	private MrPageTypeService mrPageTypeService;
	
	@Autowired
	private BasicEncodingService basicEncodingService;
	
	@RequestMapping("/getMrPageTypes")
	public String getMrPageTypes(Model model,BasicDataQuery params){
		List<Map<String, Object>> basics = mrPageTypeService.getMrPageTypes(params);
		int count = mrPageTypeService.getCountByParams(params);
		params.setTotalCounts(count);
		List<Map<String, Object>> hospitals = basicEncodingService.getBasicDataList("hospital");
		model.addAttribute("hospitals", hospitals);
		model.addAttribute("count",count);
		model.addAttribute("basics", basics);
		model.addAttribute("basicDataQuery", params);
		return "basic/mrpagetypes";
	}
	
	@RequestMapping("/addMrPageTypePage")
	public String addMrPageTypePage(Model model){
		List<Map<String, Object>> hospitals = basicEncodingService.getBasicDataList("hospital");
		model.addAttribute("hospitals", hospitals);
		return "basic/addmrpagetype";
	}
	
	@ResponseBody
	@RequestMapping("/insertMrPageType")
	public Result insertMrPageType(MrPageType basic){
		if (basic != null) {
			int result = mrPageTypeService.insertMrPage(basic);
			if (result > 0) {
				return new Result(true, "新增信息成功");
			}
		}
		return new Result(false, "新增信息失败");
	}
	
	@RequestMapping("/showMrPageType")
	public String showMrPageType(Model model,Integer id,Integer currentPage,Integer pageSize,String name,Integer hospitalId){
		MrPageType basic = mrPageTypeService.selectByPrimaryKey(id);
		List<Map<String, Object>> hospitals = basicEncodingService.getBasicDataList("hospital");
		model.addAttribute("hospitals", hospitals);
		model.addAttribute("basic", basic);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("name", name);
		model.addAttribute("hospitalId", hospitalId);
		return "basic/updatemrpagetype";
	}
	
	@ResponseBody
	@RequestMapping("/updateMrPageType")
	public Result updateMrPageType(MrPageType basic){
		if (basic != null) {
			int result = mrPageTypeService.updateByPrimaryKey(basic);
			if (result > 0) {
				return new Result(true, "修改信息成功");
			}
		}
		return new Result(false, "修改信息失败");
	}
	
	
	
	@ResponseBody
	@RequestMapping("/deleteMrPageType")
	public Result deleteMrPageType(Integer id){
		int result = mrPageTypeService.deleteByPrimaryKey(id);
		if (result > 0) {
			return new Result(true, "删除信息成功");
		} else {
			return new Result(false, "删除信息失败");
		}
	}
	
	@ResponseBody
	@RequestMapping("/validateMrPageTypeIsUse")
	public Result validateMrPageTypeIsUse(Integer id){
		boolean result = false;
		if(id!=null){
			result = mrPageTypeService.validateIsUse(id);
		}else{
			System.err.println("验证标签类型是否被引用所需的编号为空");
		}
		return new Result(result);
	}


}
