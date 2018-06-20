package com.kurumi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kurumi.pojo.StdOperation;
import com.kurumi.query.BasicDataQuery;
import com.kurumi.service.StdOperationService;
import com.kurumi.util.Result;

@Controller
@RequestMapping("/basic")
public class StdOperationController {
	
	@Autowired
	private StdOperationService stdOperationService;

	@RequestMapping("/getStdOperations")
	public String getStdOperations(Model model,BasicDataQuery params){
		/*List<StdOperation> basics = stdOperationService.getStdOperations(params);*/
		List<StdOperation> basics = new ArrayList<StdOperation>();
		/*int count = stdOperationService.getCountByParams(params);*/
		int count = 0;
		params.setTotalCounts(count);
		model.addAttribute("count",count);
		model.addAttribute("basics", basics);
		model.addAttribute("basicDataQuery", params);
		return "basic/stdoperations";
	}
	
	
	
	@RequestMapping("/showStdOperation")
	public String showStdOperation(Model model,String code,Integer currentPage,Integer pageSize,String name,String queryCode,String indexCode){
		StdOperation basic = stdOperationService.selectByPrimaryKey(code);
		
		model.addAttribute("basic", basic);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("name", name);
		model.addAttribute("code", queryCode);
		model.addAttribute("indexCode", indexCode);
		return "basic/updatestdoperation";
	}
	
	@ResponseBody
	@RequestMapping("/insertStdOperation")
	public Result insertStdOperation(StdOperation basic){
		if (basic != null) {
			int result = stdOperationService.insert(basic);
			if (result > 0) {
				return new Result(true, "新增信息成功");
			}
		}
		return new Result(false, "新增信息失败");
	}
	
	
	@ResponseBody
	@RequestMapping("/updateStdOperation")
	public Result updateStdOperation(StdOperation basic){
		if (basic != null) {
			int result = stdOperationService.updateByPrimaryKey(basic);
			if (result > 0) {
				return new Result(true, "修改信息成功");
			}
		}
		return new Result(false, "修改信息失败");
	}
	
	@ResponseBody
	@RequestMapping("/deleteStdOperation")
	public Result deleteStdOperation(String code){
		int result = stdOperationService.deleteByPrimaryKey(code);
		if (result > 0) {
			return new Result(true, "删除信息成功");
		} else {
			return new Result(false, "删除信息失败");
		}
	}
}
