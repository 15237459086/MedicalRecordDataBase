package com.kurumi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kurumi.pojo.StdDiagnosisRc020Icd10;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.StdDiagnosisRc020Icd10Service;
import com.kurumi.util.Result;

@Controller
@RequestMapping("/diagnosis")
public class StdDiagnosisRc020Icd10Controller {
	
	@Autowired
	private StdDiagnosisRc020Icd10Service stdDiagnosisRc020Icd10Service;
	
	@RequestMapping("/getDiagnosisRc020Icd10s")
	public String getDiagnosisRc020IcdList(Model model,BasicDataQuery params){
		List<StdDiagnosisRc020Icd10> basics = stdDiagnosisRc020Icd10Service.getStdDiagnosisRc020Icd10s(params);
		
		int count = stdDiagnosisRc020Icd10Service.getCountByParams(params);
		params.setTotalCounts(count);
		model.addAttribute("count",count);
		model.addAttribute("basics", basics);
		model.addAttribute("basicDataQuery", params);
		return "basic/stddiagnosisrc020icds";
	}
	
	@RequestMapping("/addDiagnosisRc020Icd10Page")
	public String addDiagnosisRc020Icd10Page(Model model){
		return "basic/addstddiagnosisrc020icd10";
	}
	
	@RequestMapping("/showStdDiagnosisRc020Icd10")
	public String showStdDiagnosisRc020Icd10(Model model,String code,Integer currentPage,Integer pageSize,String name,String queryCode,String indexCode){
		StdDiagnosisRc020Icd10 basic = stdDiagnosisRc020Icd10Service.selectByPrimaryKey(code);
		model.addAttribute("basic", basic);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("name", name);
		model.addAttribute("code", queryCode);
		model.addAttribute("indexCode", indexCode);
		return "basic/updatestddiagnosisrc020icd10";
	}
	
	@ResponseBody
	@RequestMapping("/insertStdDiagnosisRc020Icd10")
	public Result insertStdDisease(StdDiagnosisRc020Icd10 basic){
		if (basic != null) {
			int result = stdDiagnosisRc020Icd10Service.insert(basic);
			if (result > 0) {
				return new Result(true, "新增信息成功");
			}
		}
		return new Result(false, "新增信息失败");
	}
	
	
	@ResponseBody
	@RequestMapping("/updateStdDiagnosisRc020Icd")
	public Result updateStdDiagnosisRc020Icd(StdDiagnosisRc020Icd10 basic){
		if (basic != null) {
			int result = stdDiagnosisRc020Icd10Service.updateByPrimaryKey(basic);
			if (result > 0) {
				return new Result(true, "修改信息成功");
			}
		}
		return new Result(false, "修改信息失败");
	}
	
	@ResponseBody
	@RequestMapping("/deleteStdDiagnosisRc020Icd")
	public Result deleteStdDiagnosisRc020Icd(String code){
		int result = stdDiagnosisRc020Icd10Service.deleteByPrimaryKey(code);
		if (result > 0) {
			return new Result(true, "删除信息成功");
		} else {
			return new Result(false, "删除信息失败");
		}
	}

}
