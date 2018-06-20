package com.kurumi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kurumi.pojo.RespondResult;
import com.kurumi.pojo.StdDisease;
import com.kurumi.pojo.StdOperation;
import com.kurumi.query.DiseaseQuery;
import com.kurumi.query.OperationQuery;
import com.kurumi.service.StdDiseaseService;
import com.kurumi.service.StdOperationService;
import com.kurumi.util.JsonUtils;

@Controller
@RequestMapping("/icd")
public class ICDController {
	
	@Autowired
	private StdDiseaseService stdDiseaseService;
	
	@Autowired
	private StdOperationService stdOperationService;

	@RequestMapping("/icd_disease_page")
	public String icdDiseasePage(){
		return "icd/icd_disease_page";
	}
	
	@RequestMapping("/icd_operation_page")
	public String icdOperationPage(Model model){
		Map<String, Object> basicDatas = stdOperationService.getBaseData();
		model.addAttribute("baseInfoJson", JsonUtils.objectToJson(basicDatas));
		return "icd/icd_operation_page";
	}
	
	
	@RequestMapping("/query_icd_disease")
	@ResponseBody
	public RespondResult queryICDDisease(Model model,DiseaseQuery params){
		RespondResult respondResult = null;
		try {
			List<Map<String, Object>> queryDatas = new ArrayList<Map<String, Object>>();
			int count = 0;
			if(!params.isEmpty()){
				queryDatas = stdDiseaseService.getDiseasesByDiseaseQuery(params);
				count = stdDiseaseService.getDiseasesCountByDiseaseQuery(params);
			}
			params.setTotalCounts(count);
			params.setQueryDatas(queryDatas);
			respondResult = new RespondResult(true, RespondResult.successCode, "查询成功", params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		
		return respondResult;
	}
	
	
	@ResponseBody
	@PostMapping("/create_icd_disease")
	public RespondResult createICDDisease(StdDisease stdDisease){
		RespondResult respondResult = null;
		try{
			int result = stdDiseaseService.insert(stdDisease);
			if (result == 1) {
				respondResult = new RespondResult(true, RespondResult.successCode, "新增信息成功", stdDisease);
			} else if (result == 2) {
				respondResult = new RespondResult(true, RespondResult.repeatCode, "此编号已存在", stdDisease);
			} else{
				respondResult = new RespondResult(true, RespondResult.errorCode, "新增失败", stdDisease);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}
	
	
	@ResponseBody
	@GetMapping("/show_icd_disease")
	public RespondResult showICDDisease(String code){
		RespondResult respondResult = null;
		try{
			StdDisease disease = stdDiseaseService.selectByPrimaryKey(code);
			if(disease != null){
				if(disease.getFitManCodeFlag() == null){
					disease.setFitManCodeFlag("0");
				}
				if(disease.getFitWomanCodeFlag()== null){
					disease.setFitWomanCodeFlag("0");
				}
				if(disease.getUnDeathFlag()== null){
					disease.setUnDeathFlag("0");
				}
				if(disease.getUnPrimaryFlag()== null){
					disease.setUnPrimaryFlag("0");
				}
				if(disease.getAttentionFlag()== null){
					disease.setAttentionFlag("0");
				}
			}
			respondResult = new RespondResult(true, RespondResult.successCode, "获取成功", disease);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}
	
	
	@ResponseBody
	@PostMapping("/update_icd_disease")
	public RespondResult updateICDDisease(StdDisease stdDisease){
		RespondResult respondResult = null;
		try{
			int result = stdDiseaseService.updateByPrimaryKey(stdDisease);
			if (result == 1) {
				respondResult = new RespondResult(true, RespondResult.successCode, "修改信息成功", stdDisease);
			} else{
				respondResult = new RespondResult(true, RespondResult.errorCode, "新增失败", stdDisease);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}

	
	@RequestMapping("/query_icd_operation")
	@ResponseBody
	public RespondResult queryICDOperation(Model model,OperationQuery params){
		RespondResult respondResult = null;
		try {
			List<Map<String, Object>> queryDatas = new ArrayList<Map<String, Object>>();
			int count = 0;
			if(!params.isEmpty()){
				queryDatas = stdOperationService.getOperationByOperationQuery(params);
				count = stdOperationService.getOperationCountByOperationQuery(params);
			}
			params.setTotalCounts(count);
			params.setQueryDatas(queryDatas);
			respondResult = new RespondResult(true, RespondResult.successCode, "查询成功", params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		
		return respondResult;
	}
	
	@ResponseBody
	@PostMapping("/create_icd_operation")
	public RespondResult createICDOperation(StdOperation stdOperation){
		RespondResult respondResult = null;
		try{
			int result = stdOperationService.insert(stdOperation);
			if (result == 1) {
				respondResult = new RespondResult(true, RespondResult.successCode, "新增信息成功", stdOperation);
			} else if (result == 2) {
				respondResult = new RespondResult(true, RespondResult.repeatCode, "此编号已存在", stdOperation);
			} else{
				respondResult = new RespondResult(true, RespondResult.errorCode, "新增失败", stdOperation);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}
	
	
	@ResponseBody
	@GetMapping("/show_icd_operation")
	public RespondResult showICDOperation(String code){
		RespondResult respondResult = null;
		try{
			StdOperation stdOperation = stdOperationService.selectByPrimaryKey(code);
			
			respondResult = new RespondResult(true, RespondResult.successCode, "获取成功", stdOperation);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}
	
	
	@ResponseBody
	@PostMapping("/update_icd_operation")
	public RespondResult updateICDOperation(StdOperation stdOperation){
		RespondResult respondResult = null;
		try{
			int result = stdOperationService.updateByPrimaryKey(stdOperation);
			if (result == 1) {
				respondResult = new RespondResult(true, RespondResult.successCode, "修改信息成功", stdOperation);
			} else{
				respondResult = new RespondResult(true, RespondResult.errorCode, "修改失败", stdOperation);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}

}
