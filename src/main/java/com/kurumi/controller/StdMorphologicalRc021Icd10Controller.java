package com.kurumi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kurumi.pojo.StdMorphologicalRc021Icd10;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.StdMorphologicalRc021Icd10Service;
import com.kurumi.util.Result;

@Controller
@RequestMapping("/morphological")
public class StdMorphologicalRc021Icd10Controller {
	
	@Autowired
	private StdMorphologicalRc021Icd10Service stdMorphologicalRc021Icd10Service;
	
	@RequestMapping("/getMorphologicalRc021Icds")
	public String getMorphologicalRc021IcdList(Model model,BasicDataQuery params){
		List<StdMorphologicalRc021Icd10> basics = stdMorphologicalRc021Icd10Service.getStdMorphologicalRc021Icd10(params);
		
		int count = stdMorphologicalRc021Icd10Service.getCountByParams(params);
		params.setTotalCounts(count);
		model.addAttribute("count",count);
		model.addAttribute("basics", basics);
		model.addAttribute("basicDataQuery", params);
		return "basic/morphologicalrc021icds";
	}
	
	@RequestMapping("/addMorphologicalRc021IcdPage")
	public String addMorphologicalRc021IcdPage(Model model){
		return "basic/addmorphologicalrc021icd";
	}
	
	@RequestMapping("/showMorphologicalRc021Icd")
	public String showMorphologicalRc021Icd(Model model,String code,Integer currentPage,Integer pageSize,String name,String queryCode,String indexCode){
		StdMorphologicalRc021Icd10 basic = stdMorphologicalRc021Icd10Service.selectByPrimaryKey(code);
		model.addAttribute("basic", basic);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("name", name);
		model.addAttribute("code", queryCode);
		model.addAttribute("indexCode", indexCode);
		return "basic/updatemorphologicalrc021icd";
	}
	
	@ResponseBody
	@RequestMapping("/insertMorphologicalRc021Icd")
	public Result insertMorphologicalRc021Icd(StdMorphologicalRc021Icd10 basic){
		if (basic != null) {
			int result = stdMorphologicalRc021Icd10Service.insert(basic);
			if (result > 0) {
				return new Result(true, "新增信息成功");
			}
		}
		return new Result(false, "新增信息失败");
	}
	
	
	@ResponseBody
	@RequestMapping("/updateMorphologicalRc021Icd")
	public Result updateMorphologicalRc021Icd(StdMorphologicalRc021Icd10 basic){
		if (basic != null) {
			int result = stdMorphologicalRc021Icd10Service.updateByPrimaryKey(basic);
			if (result > 0) {
				return new Result(true, "修改信息成功");
			}
		}
		return new Result(false, "修改信息失败");
	}
	
	@ResponseBody
	@RequestMapping("/deleteMorphologicalRc021Icd")
	public Result deleteMorphologicalRc021Icd(String code){
		int result = stdMorphologicalRc021Icd10Service.deleteByPrimaryKey(code);
		if (result > 0) {
			return new Result(true, "删除信息成功");
		} else {
			return new Result(false, "删除信息失败");
		}
	}


}
