package com.kurumi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kurumi.enums.TableNameEnum;
import com.kurumi.pojo.BasicEncoding;
import com.kurumi.pojo.RespondResult;
import com.kurumi.query.BasicEncodingQuery;
import com.kurumi.service.BasicEncodingService;
import com.kurumi.util.Result;

@Controller
@RequestMapping("/basic")
public class BasicEncodingController {
	
	@Autowired
	private BasicEncodingService basicEncodingService;
	
	
	@RequestMapping("/basic_encoding_index")
	public String basicEncodingIndex(){
		return "basic_encoding_index.default";
	}
	
	@RequestMapping("/basic_encoding_page")
	public String basicEncodingPage(Model model,BasicEncodingQuery params){
		TableNameEnum tableNameEnum =TableNameEnum.valueOf(params.getTableName());
		model.addAttribute("tableNameEnum", tableNameEnum);
		model.addAttribute("params", params);
		return "basic/basic_encoding_page";
	}
	
	@RequestMapping("/query_basic_encoding")
	@ResponseBody
	public RespondResult queryBasicEncoding(Model model,BasicEncodingQuery params){
		RespondResult respondResult = null;
		try {
			List<Map<String, Object>> queryDatas = new ArrayList<Map<String, Object>>();
			int count = 0;
			if(!params.isEmpty()){
				queryDatas = basicEncodingService.getBasicEncoding(params);
				count = basicEncodingService.getBasicEncodingCount(params);
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
	@PostMapping("/create_basic_data")
	public RespondResult createBasicData(BasicEncoding basicData){
		RespondResult respondResult = null;
		try{
			int result = basicEncodingService.insertBasicEncoding(basicData);
			if (result == 1) {
				respondResult = new RespondResult(true, RespondResult.successCode, "新增信息成功", basicData);
			} else if (result == 2) {
				respondResult = new RespondResult(true, RespondResult.repeatCode, "此编号已存在", basicData);
			} else{
				respondResult = new RespondResult(true, RespondResult.errorCode, "新增失败", basicData);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}
	
	@ResponseBody
	@RequestMapping("/update_basic_data")
	public RespondResult updateBasicData(BasicEncoding basicData){
		RespondResult respondResult = null;
		try{
			int result = basicEncodingService.updateBasicEncoding(basicData);
			if (result == 1) {
				respondResult = new RespondResult(true, RespondResult.successCode, "修改信息成功", basicData);
			} else if (result == 2) {
				respondResult = new RespondResult(true, RespondResult.repeatCode, "此编号已存在", basicData);
			} else{
				respondResult = new RespondResult(true, RespondResult.errorCode, "修改失败", basicData);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}
	
	
	/*@RequestMapping("/getBasicEncodes")
	public String getBasicEncodes(Model model,BasicDataQuery params){
		List<Map<String, Object>> basics = basicEncodingService.getBasicEncoding(params);
		int count = basicEncodingService.getBasicEncodingCount(params);
		params.setTotalCounts(count);
		model.addAttribute("count",count);
		model.addAttribute("basics", basics);
		params.setTitle(getTitleByTableName(params.getTableName()));
		model.addAttribute("basicDataQuery", params);
		return "basic/basicencodes";
	}*/
	
	@RequestMapping("/addBasicEncodePage")
	public String addBasicEncodePage(Model model,String tableName){
		model.addAttribute("title", getTitleByTableName(tableName));
		model.addAttribute("tableName", tableName);
		
		return "basic/addbasicencode";
	}
	
	@ResponseBody
	@RequestMapping("/insertBasicEncode")
	public Result insertBasicEncode(BasicEncoding basic){
		if (basic != null) {
			int result = basicEncodingService.insertBasicEncoding(basic);
			if (result > 0) {
				return new Result(true, "新增信息成功");
			}
		}
		return new Result(false, "新增信息失败");
	}
	
	
	@RequestMapping("/showBasicEncode")
	public String showBasicEncode(Model model,Integer id,String tableName,Integer currentPage,Integer pageSize,String name,Integer hospitalId){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("tableName", tableName);
		BasicEncoding basicEncode = basicEncodingService.getBasicEncodingById(map);
		basicEncode.setTableName(tableName);
		if("medical_office".equals(tableName)){
			List<Map<String, Object>> hospitals = basicEncodingService.getBasicDataList("hospital");
			model.addAttribute("hospitals", hospitals);
			model.addAttribute("hospitalId", hospitalId);
		}
		

		model.addAttribute("basic", basicEncode);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("name", name);
		model.addAttribute("title", getTitleByTableName(tableName));
		return "basic/updatebasicencode";
	}
	
	@ResponseBody
	@RequestMapping("/updateBasicEncode")
	public Result updateBasicEncode(BasicEncoding basic){
		if (basic != null) {
			int result = basicEncodingService.updateBasicEncodingById(basic);
			if (result > 0) {
				return new Result(true, "修改信息成功");
			}
		}
		return new Result(false, "修改信息失败");
	}
	
	
	
	@ResponseBody
	@RequestMapping("/deleteBasicEncode")
	public Result deleteBasicEncode(Integer id,String tableName){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("tableName", tableName);
		int result = basicEncodingService.deleteBasicEncodingById(map);
		if (result > 0) {
			return new Result(true, "删除信息成功");
		} else {
			return new Result(false, "删除信息失败");
		}
	}
	
	public String getTitleByTableName(String tableName){
		String title ="";
		
		if("nation".equals(tableName) ){
			title="民族";
		}else if("nationality".equals(tableName)){
			title="国籍";
		}else if("profession".equals(tableName)){
			title="职业";
		}else if("relative_relation".equals(tableName)){
			title="亲属关系";
		}else if("marriage".equals(tableName)){
			title="婚姻";
		}else if("blood_type".equals(tableName)){
			title="血型";
		}else if("rh_blood_type".equals(tableName)){
			title="血型RH";
		}else if("medical_payment_type".equals(tableName)){
			title="付款方式";
		}else if("diagnose_type".equals(tableName)){
			title="诊断类型";
		}else if("hospitalization_dealth_reason".equals(tableName)){
			title="死亡原因";
		}else if("in_hospitalization_state".equals(tableName)){
			title="入院状态";
		}else if("in_hospitalization_disease_state".equals(tableName)){
			title="入院病情";
		}else if("treatment_result".equals(tableName)){
			title="治疗结果";
		}else if("identity_document_type".equals(tableName)){
			title="证件类型";
		}
		else if("in_hospital_type".equals(tableName) ){
			title="入院方式";
		}else if("out_hospital_type".equals(tableName)){
			title="出院方式";
		}else if("treatment_sign".equals(tableName)){
			title="就诊级别";
		}else if("treatment_type".equals(tableName)){
			title="就诊类型";
		}else if("hospital".equals(tableName)){
			title="医院";
		}else if("medical_resource_type".equals(tableName)){
			title="资源文件类型";
		}else if("sex".equals(tableName)){
			title="性别";
		}else if("std_attributes_code".equals(tableName)){
			title="编码属性";
		}
		else if("std_ops_operation_mark".equals(tableName)){
			title="手术标识";
		}else if("std_ops_level".equals(tableName)){
			title="手术级别";
		}else if("std_cicatrization_type".equals(tableName)){
			title="愈合类别";
		}else if("std_ops_part".equals(tableName)){
			title="手术部位";
		}else if("std_ops_infect_part".equals(tableName)){
			title="手术感染部位";
		}else if("std_ops_time_limit".equals(tableName)){
			title="手术时间限制";
		}else if("std_ops_after_syndrome".equals(tableName)){
			title="术后并发症";
		}else if("std_ops_character".equals(tableName)){
			title="患者手术类型";
		}else if("std_ops_after_direction".equals(tableName)){
			title="术后去向";
		}else if("std_anaesthesia_level".equals(tableName)){
			title="麻醉分级";
		}else if("std_anaesthesia_way".equals(tableName)){
			title="麻醉方式";
		}else if("std_anaesthesia_unexpected_event".equals(tableName)){
			title="麻醉非预期事件";
		}else if("std_ops_risk_level".equals(tableName)){
			title="风险分级";
		}else if("std_incision_level".equals(tableName)){
			title="切口等级";
		}
		
		return title;
	}
	
	@ResponseBody
	@RequestMapping("/validateIdTypeIsUse")
	public Result validateIdTypeIsUse(Integer id){
		boolean result = false;
		if(id!=null){
			result = basicEncodingService.validateIdTypeIsUse(id);
		}else{
			System.err.println("验证证件类型是否被引用所需的编号为空");
		}
		return new Result(result);
	}
	
	
	@ResponseBody
	@RequestMapping("/validateSexIsUse")
	public Result validateSexIsUse(Integer id){
		boolean result = false;
		if(id!=null){
			result = basicEncodingService.validateSexIsUse(id);
		}else{
			System.err.println("验证性别是否被引用所需的编号为空");
		}
		return new Result(result);
	}
	
	@ResponseBody
	@RequestMapping("/validateTreatmentIsUse")
	public Result validateTreatmentIsUse(Integer signId,Integer typeId){
		boolean result = false;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("signId", signId);
		map.put("typeId", typeId);
		if(signId!=null || typeId!=null){
			
			result = basicEncodingService.validateTreatmentIsUse(map);
		}else{
			System.err.println("验证就诊标记就诊类型是否被引用所需的编号为空");
		}
		return new Result(result);
	}
	
	@ResponseBody
	@RequestMapping("/validateHospitalTypeIsUse")
	public Result validateHospitalTypeIsUse(Integer inId,Integer outId){
		boolean result = false;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("inId", inId);
		map.put("outId", outId);
		if(inId!=null || outId!=null){
			
			result = basicEncodingService.validateHospitalTypeIsUse(map);
		}else{
			System.err.println("验证出入院方式是否被引用所需的编号为空");
		}
		return new Result(result);
	}
	
	@ResponseBody
	@RequestMapping("/validateHospitalIsUse")
	public Result validateHospitalIsUse(Integer id){
		boolean result = false;
		if(id!=null){
			
			result = basicEncodingService.validateHospitalIsUse(id);
		}else{
			System.err.println("验证医院是否被引用所需的编号为空");
		}
		return new Result(result);
	}
	
	@ResponseBody
	@RequestMapping("/validateResourceTypeIsUse")
	public Result validateResourceTypeIsUse(Integer id){
		boolean result = false;
		if(id!=null){
			
			result = basicEncodingService.validateResourceTypeIsUse(id);
		}else{
			System.err.println("验证资源文件类型是否被引用所需的编号为空");
		}
		return new Result(result);
	}
	
	@ResponseBody
	@RequestMapping("/validateStdAttributesCode")
	public Result validateStdAttributesCode(Integer id){
		boolean result = false;
		if(id!=null){
			result = basicEncodingService.validateStdAttributeCodeIsUse(id);
		}else{
			System.err.println("验证编码属性是否被引用所需的编号为空");
		}
		return new Result(result);
	}
	
	@ResponseBody
	@RequestMapping("/validateOperation")
	public Result validateIncisionAndOpsLevelAndOpsMarkIsUse(Integer incisionLevelId,Integer opsLevelId,Integer opsMarkId){
		Map<String,Integer> map = new HashMap<String, Integer>();
		if(incisionLevelId!= null){
			map.put("incisionLevelId", incisionLevelId);
		}
		if(opsLevelId!= null){
			map.put("opsLevelId", opsLevelId);
		}
		if(opsMarkId!=null){
			map.put("opsMarkId", opsMarkId);
		}
		
		boolean result = false;
		if(!map.isEmpty()){
			result = basicEncodingService.validateIncisionAndOpsLevelAndOpsMarkIsUse(map);
		}else{
			System.err.println("验证切口等级、手术等级、手术标识是否被引用所需的编号为空");
		}
		return new Result(result);
	}
	
	
}
