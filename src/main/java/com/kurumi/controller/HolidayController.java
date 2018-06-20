package com.kurumi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kurumi.pojo.RespondResult;
import com.kurumi.service.HolidayService;
import com.kurumi.util.DateUtil;

@Controller
@RequestMapping("/holiday")
public class HolidayController {
	
	@Autowired
	private HolidayService holidayService;

	@RequestMapping("/holiday_index")
	public String holidayIndex(Model model){
		return "holiday_index.default";
	}
	
	@RequestMapping("/holiday_page")
	public String holidayPage(Model model){
		return "holiday/holiday_page";
	}
	
	
	@ResponseBody
	@GetMapping("/query_holiday")
	public RespondResult queryHoliday(String year){
		RespondResult respondResult = null;
		try {
			Date holidayDate = DateUtil.dateParse("yyyy",year);
			Date startDate = DateUtil.getMinDateOfYear(holidayDate);
			Date endDate = DateUtil.getMaxDateOfYear(holidayDate);
			List<String> holidays = holidayService.getHoliday(startDate, endDate);
			respondResult = new RespondResult(true, RespondResult.successCode, "查询成功", holidays);
			
		} catch (Exception e) {
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}
	

	@ResponseBody
	@PostMapping("/set_holiday")
	public RespondResult setHoliday(String date,String tag){
		RespondResult respondResult = null;
		try {
			Date holidayDate = DateUtil.dateParse(date);
			int result = holidayService.setHoliday(holidayDate, tag);
			if(result == 1){
				respondResult = new RespondResult(true, RespondResult.successCode, "节假日设置成功", result);
			}else{
				respondResult = new RespondResult(true, RespondResult.errorCode, "节假日设置失败", result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}
	
	
	
	@ResponseBody
	@PostMapping("/init_holiday")
	public RespondResult initHoliday(String year){
		RespondResult respondResult = null;
		try {
			Date holidayDate = DateUtil.dateParse("yyyy",year);
			Date startDate = DateUtil.getMinDateOfYear(holidayDate);
			Date endDate = DateUtil.getMaxDateOfYear(holidayDate);
			List<String> holidays = holidayService.initHoliday(startDate, endDate);
			respondResult = new RespondResult(true, RespondResult.successCode, "节假日初始化成功", holidays);
			
		} catch (Exception e) {
			e.printStackTrace();
			respondResult = new RespondResult(false, RespondResult.errorCode, e.getMessage(),e.getMessage());
		}
		return respondResult;
	}

}
