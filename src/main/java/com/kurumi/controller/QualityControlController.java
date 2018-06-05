package com.kurumi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kurumi.pojo.QualityControlStandard;
import com.kurumi.pojo.RespondResult;
import com.kurumi.service.QualityControlService;

@Controller
@RequestMapping("/quality_control")
public class QualityControlController {

	@Autowired
	private QualityControlService qualityControlService;

	@RequestMapping("/quality_control_index")
	public String qualityControlIndex(){
		return "quality_control_index.default";
	}
	
	@RequestMapping("/quality_control_page")
	public String qualityControlPage(){
		return "quality_control/quality_control_page";
	}
	
	@ResponseBody
	@GetMapping("/quality_control_first_level")
	public RespondResult firstLevel(){
		RespondResult respondResult = null;
		try {
			List<Map<String, Object>> qualityControlItems = qualityControlService.getQualityControlOfFirstLevel();
			respondResult = new RespondResult(true, RespondResult.successCode, "查询成功", qualityControlItems);
		} catch (Exception e) {
			// TODO: handle exception
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}
	
	@ResponseBody
	@GetMapping("/quality_control_item_by_up_level_code")
	public RespondResult qualityControlPointByUpLevelCode(String upOneLevelCode){
		RespondResult respondResult = null;
		try {
			List<Map<String, Object>> qualityControlItems = qualityControlService.getQualityControlByUpOneLevelCode(upOneLevelCode);
			respondResult = new RespondResult(true, RespondResult.successCode, "查询成功", qualityControlItems);
		} catch (Exception e) {
			// TODO: handle exception
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}
	
	
	@ResponseBody
	@PostMapping("/create_quality_control")
	public RespondResult createQualityControl(QualityControlStandard qualityControlStandard){
		RespondResult respondResult = null;
		try{
			int result = qualityControlService.insert(qualityControlStandard);
			if (result == 1) {
				respondResult = new RespondResult(true, RespondResult.successCode, "新增成功", qualityControlStandard);
			} else if (result == 2) {
				respondResult = new RespondResult(true, RespondResult.repeatCode, "此编号已存在", qualityControlStandard);
			} else{
				respondResult = new RespondResult(true, RespondResult.errorCode, "新增失败", qualityControlStandard);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}
	
	
	@ResponseBody
	@PostMapping("/update_quality_control")
	public RespondResult updateQualityControl(QualityControlStandard qualityControlStandard){
		RespondResult respondResult = null;
		try{
			int result = qualityControlService.update(qualityControlStandard);
			if (result == 1) {
				respondResult = new RespondResult(true, RespondResult.successCode, "修改成功", qualityControlStandard);
			} else if (result == 2) {
				respondResult = new RespondResult(true, RespondResult.repeatCode, "此编号已存在", qualityControlStandard);
			} else{
				respondResult = new RespondResult(true, RespondResult.errorCode, "修改失败", qualityControlStandard);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}
}
