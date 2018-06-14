package com.kurumi.controller;


import java.util.ArrayList;
import java.util.List;




import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kurumi.pojo.StdDisease;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.StdDiseaseService;
import com.kurumi.util.Result;

@Controller
@RequestMapping("/basic")
public class StdDiseaseController{
	@Autowired
	private StdDiseaseService stdDiseaseService;

	@RequestMapping("/getDiseases")
	public String getDiseaseList(Model model,BasicDataQuery params){
		/*List<StdDisease> basics = stdDiseaseService.getDiseases(params);*/
		List<StdDisease> basics = new ArrayList<StdDisease>();
		
/*		if(basics!=null){
			for(int i=0;i<basics.size();i++){
				StdDisease disease = basics.get(i);
				disease.setText(disease.getCode());
			}
		}*/
		
		/*int count = stdDiseaseService.getCountByParams(params);*/
		int count = 0;
		params.setTotalCounts(count);
		model.addAttribute("count",count);
		model.addAttribute("basics", basics);
		model.addAttribute("basicDataQuery", params);
		//(String) JSONArray.fromObject(basics);
		
		return "basic/diseases";
	}
	
	@RequestMapping("/addStdDiseasePage")
	public String addStdDiseasePage(Model model){
		List<Map<String, Object>> list = stdDiseaseService.getStdAttributeCodes();
		model.addAttribute("attributeCodeList",list);
		return "basic/addstddisease";
	}
	
	@RequestMapping("/showStdDisease")
	public String showStdDisease(Model model,String code,Integer currentPage,Integer pageSize,String name,String queryCode,String indexCode){
		StdDisease basic = stdDiseaseService.selectByPrimaryKey(code);
		List<Map<String, Object>> list = stdDiseaseService.getStdAttributeCodes();
		model.addAttribute("attributeCodeList",list);
		model.addAttribute("basic", basic);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("name", name);
		model.addAttribute("code", queryCode);
		model.addAttribute("indexCode", indexCode);
		return "basic/updatedisease";
	}
	
	@ResponseBody
	@RequestMapping("/insertStdDisease")
	public Result insertStdDisease(StdDisease basic){
		if (basic != null) {
			int result = stdDiseaseService.insert(basic);
			if (result > 0) {
				return new Result(true, "新增信息成功");
			}
		}
		return new Result(false, "新增信息失败");
	}
	
	
	@ResponseBody
	@RequestMapping("/updateStdDisease")
	public Result updateStdDisease(StdDisease basic){
		if (basic != null) {
			int result = stdDiseaseService.updateByPrimaryKey(basic);
			if (result > 0) {
				return new Result(true, "修改信息成功");
			}
		}
		return new Result(false, "修改信息失败");
	}
	
	@ResponseBody
	@RequestMapping("/deleteStdDisease")
	public Result deleteStdDisease(String code){
		int result = stdDiseaseService.deleteByPrimaryKey(code);
		if (result > 0) {
			return new Result(true, "删除信息成功");
		} else {
			return new Result(false, "删除信息失败");
		}
	}
	
	/*@ResponseBody
	@RequestMapping("/validateCodeIsUnique")
	public Result validateCodeIsUnique(String code){
		boolean result = stdDiseaseService.validateCodeIsUnique(code);
		if (result) {
			return new Result(true, "编码未重复");
		}else{
			return new Result(false, "编码重复");
		}
	}*/

}