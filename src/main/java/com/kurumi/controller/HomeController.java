package com.kurumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	/**
	 * 默认首页
	 * @return
	 */
	@RequestMapping("/")
	public String home(Model model){
		/*params.setTableName("sex");
		List<Map<String, Object>> basics = basicEncodingService.getBasicEncodings(params);
		int count = basicEncodingService.getBasicEncodingCount(params);
		params.setTotalCounts(count);
		model.addAttribute("count",count);
		model.addAttribute("basics", basics);
		params.setTitle("性别");
		model.addAttribute("basicDataQuery", params);
		//List<Map<String, Object>> sexes = sexService.getSexes();
*/		//model.addAttribute("sexes", sexes);
		
		return "index.default";
	}
	
	/**
	 * 默认首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model){
		/*params.setTableName("sex");
		List<Map<String, Object>> basics = basicEncodingService.getBasicEncodings(params);
		int count = basicEncodingService.getBasicEncodingCount(params);
		params.setTotalCounts(count);
		model.addAttribute("count",count);
		model.addAttribute("basics", basics);
		params.setTitle("性别");
		model.addAttribute("basicDataQuery", params);
		//List<Map<String, Object>> sexes = sexService.getSexes();
*/		//model.addAttribute("sexes", sexes);
		
		return "index.default";
	}
}
