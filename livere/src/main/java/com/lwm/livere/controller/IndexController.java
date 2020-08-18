package com.lwm.livere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping({"","/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/detail")
	public String detail() {
		return "detail";
	}
}
