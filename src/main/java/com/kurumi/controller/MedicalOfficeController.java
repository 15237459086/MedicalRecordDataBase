package com.kurumi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kurumi.pojo.MedicalOffice;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.BasicEncodingService;
import com.kurumi.service.MedicalOfficeService;
import com.kurumi.util.Result;

@Controller
@RequestMapping("/basic")
public class MedicalOfficeController {

	@Autowired
	private MedicalOfficeService medicalOfficeService;
	
	@Autowired
	private BasicEncodingService basicEncodingService;
	
	@RequestMapping("/getMedicalOffices")
	public String getMedicalOffices(Model model,BasicDataQuery params){
		List<Map<String, Object>> basics = medicalOfficeService.getMedicalOffices(params);
		int count = medicalOfficeService.getCountByParams(params);
		params.setTotalCounts(count);
		List<Map<String, Object>> hospitals = basicEncodingService.getBasicDataList("hospital");
		model.addAttribute("hospitals", hospitals);
		model.addAttribute("count",count);
		model.addAttribute("basics", basics);
		model.addAttribute("basicDataQuery", params);
		return "basic/medicaloffices";
	}
	
	@RequestMapping("/addMedicalOfficePage")
	public String addMedicalOfficePage(Model model){
		List<Map<String, Object>> hospitals = basicEncodingService.getBasicDataList("hospital");
		model.addAttribute("hospitals", hospitals);
		return "basic/addmedicaloffice";
	}
	
	@ResponseBody
	@RequestMapping("/insertMedicalOffice")
	public Result insertMedicalOffice(MedicalOffice basic){
		if (basic != null) {
			int result = medicalOfficeService.insert(basic);
			if (result > 0) {
				return new Result(true, "新增信息成功");
			}
		}
		return new Result(false, "新增信息失败");
	}
	
	
	@RequestMapping("/showMedicalOffice")
	public String showMedicalOffice(Model model,Integer id,Integer currentPage,Integer pageSize,String name,Integer hospitalId){
		MedicalOffice basic = medicalOfficeService.selectByPrimaryKey(id);
		List<Map<String, Object>> hospitals = basicEncodingService.getBasicDataList("hospital");
		model.addAttribute("hospitals", hospitals);
		model.addAttribute("basic", basic);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("name", name);
		model.addAttribute("hospitalId", hospitalId);
		return "basic/updatemedicaloffice";
	}
	
	@ResponseBody
	@RequestMapping("/updateMedicalOffice")
	public Result updateMedicalOffice(MedicalOffice basic){
		if (basic != null) {
			int result = medicalOfficeService.updateByPrimaryKey(basic);
			if (result > 0) {
				return new Result(true, "修改信息成功");
			}
		}
		return new Result(false, "修改信息失败");
	}
	
	
	
	@ResponseBody
	@RequestMapping("/deleteMedicalOffice")
	public Result deleteMedicalOffice(Integer id){
		int result = medicalOfficeService.deleteByPrimaryKey(id);
		if (result > 0) {
			return new Result(true, "删除信息成功");
		} else {
			return new Result(false, "删除信息失败");
		}
	}
	
	@ResponseBody
	@RequestMapping("/validateMedicalOfficeIsUse")
	public Result validateMedicalOfficeIsUse(Integer id){
		boolean result = false;
		if(id!=null){
			result = medicalOfficeService.validateIsUse(id);
		}else{
			System.err.println("验证科室是否被引用所需的编号为空");
		}
		return new Result(result);
	}

}
