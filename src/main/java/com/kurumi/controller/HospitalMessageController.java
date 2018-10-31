package com.kurumi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EnumType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kurumi.enums.TableNameEnum;
import com.kurumi.query.BasicEncodingQuery;
import com.kurumi.service.BasicEncodingService;
import com.kurumi.util.JsonUtils;

@Controller
@RequestMapping("/hospital_message")
public class HospitalMessageController {

	@Autowired
	private BasicEncodingService basicEncodingService;
	
	/**
	 * 医院管理首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model){
		
		
		return "hospital_message_index.default";
	}
	
	@GetMapping("/medical_dept_page")
	public String medicalDeptPage(Model model){
		return "hospital_message/medical_dept_page";
	}
}
