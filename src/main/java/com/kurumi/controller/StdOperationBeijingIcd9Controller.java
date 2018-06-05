package com.kurumi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kurumi.pojo.StdOperationBeijingIcd9;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.BasicEncodingService;
import com.kurumi.service.StdOperationBeijingIcd9Service;
import com.kurumi.util.Result;

@Controller
@RequestMapping("/operationIcd9")
public class StdOperationBeijingIcd9Controller {
	
	@Autowired
	private StdOperationBeijingIcd9Service stdOperationBeijingIcd9Service;
	
	@Autowired
	private BasicEncodingService basicEncodingService;
	
	@RequestMapping("/getStdOperationIcd9s")
	public String getStdOperationIcd9s(Model model,BasicDataQuery params){
		List<StdOperationBeijingIcd9> basics = stdOperationBeijingIcd9Service.getStdOperationIcd9s(params);
		int count = stdOperationBeijingIcd9Service.getCountByParams(params);
		params.setTotalCounts(count);
		model.addAttribute("count",count);
		model.addAttribute("basics", basics);
		model.addAttribute("basicDataQuery", params);
		return "basic/stdoperationicd9s";
	}
	
	@RequestMapping("/addStdOperationIcd9Page")
	public String addStdOperationPage(Model model){
		model.addAttribute("operationMarks",basicEncodingService.getBasicDataList("std_ops_operation_mark"));
		return "basic/addstdoperationicd9";
	}
	
	@RequestMapping("/showStdOperationIcd9")
	public String showStdOperationIcd9(Model model,String code,Integer currentPage,Integer pageSize,String name,String queryCode,String indexCode){
		StdOperationBeijingIcd9 basic = stdOperationBeijingIcd9Service.selectByPrimaryKey(code);
		model.addAttribute("operationMarks",basicEncodingService.getBasicDataList("std_ops_operation_mark"));
		model.addAttribute("basic", basic);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("name", name);
		model.addAttribute("code", queryCode);
		model.addAttribute("indexCode", indexCode);
		return "basic/updatestdoperationicd9";
	}
	
	@ResponseBody
	@RequestMapping("/insertStdOperationIcd9")
	public Result insertStdOperationIcd9(StdOperationBeijingIcd9 basic){
		if (basic != null) {
			int result = stdOperationBeijingIcd9Service.insert(basic);
			if (result > 0) {
				return new Result(true, "新增信息成功");
			}
		}
		return new Result(false, "新增信息失败");
	}
	
	
	@ResponseBody
	@RequestMapping("/updateStdOperationIcd9")
	public Result updateStdOperationIcd9(StdOperationBeijingIcd9 basic){
		if (basic != null) {
			int result = stdOperationBeijingIcd9Service.updateByPrimaryKey(basic);
			if (result > 0) {
				return new Result(true, "修改信息成功");
			}
		}
		return new Result(false, "修改信息失败");
	}
	
	@ResponseBody
	@RequestMapping("/deleteStdOperationIcd9")
	public Result deleteStdOperationIcd9(String code){
		int result = stdOperationBeijingIcd9Service.deleteByPrimaryKey(code);
		if (result > 0) {
			return new Result(true, "删除信息成功");
		} else {
			return new Result(false, "删除信息失败");
		}
	}

}
