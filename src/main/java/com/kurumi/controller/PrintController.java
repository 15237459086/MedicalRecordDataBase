package com.kurumi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kurumi.pojo.RespondResult;
import com.kurumi.service.PrintService;

@Controller
@RequestMapping("/print")
public class PrintController {

	@Autowired
	private PrintService printService;
	
	@RequestMapping("/print_index")
	public String printIndex(){
		return "print_index.default";
	}
	
	
	@RequestMapping("/print_type_page")
	public String printTypePage(Model model){
		List<Map<String,Object>> printTypes = printService.getMrPrintTypes();
		model.addAttribute("printTypes", printTypes);
		List<Map<String,Object>> pageTypes = printService.getMrPageTypes();
		model.addAttribute("pageTypes", pageTypes);
		return "print/print_type_page";
	}
	
	@RequestMapping("/query_page_type_by_print_type_id")
	@ResponseBody
	public RespondResult queryBasicEncoding(Integer printerTypeId){
		RespondResult respondResult = null;
		try {
			List<Integer> pageTypeIds = printService.getMrPageTypeIdsByPrintTypeId(printerTypeId);
			respondResult = new RespondResult(true, RespondResult.successCode, "查询成功", pageTypeIds);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		
		return respondResult;
	}
	
	@PostMapping("/update_mr_printer_range")
	@ResponseBody
	public RespondResult updateMrPrinterRange(@RequestParam("printerTypeId")Integer printerTypeId,@RequestParam("pageTypeIds")List<Integer> pageTypeIds){
		RespondResult respondResult = null;
		try {
			printService.updateMrPrinterRanges(printerTypeId, pageTypeIds);
			respondResult = new RespondResult(true, RespondResult.successCode, "操作成功", "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		
		return respondResult;
	}
	
}
