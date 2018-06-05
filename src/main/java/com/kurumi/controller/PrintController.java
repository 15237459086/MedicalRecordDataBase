package com.kurumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/print")
public class PrintController {

	@RequestMapping("/print_index")
	public String qualityControlIndex(){
		return "print_index.default";
	}
}
