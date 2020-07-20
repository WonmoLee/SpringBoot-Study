package com.spring.pt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping({"","/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/auth/login")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/auth/join")
	public String joinForm() {
		return "user/joinForm";
	}
	
}
