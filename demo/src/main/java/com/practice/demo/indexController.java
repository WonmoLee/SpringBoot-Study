package com.practice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {
	
	@Autowired
	Test t;
	
	@GetMapping("/home")
	public String main() {
		return "index";
	}
	
	@GetMapping("/index")
	public @ResponseBody String home() {
		return "index";
	}
	
	@GetMapping({"","/"})
	public @ResponseBody String index() {
		System.out.println(t.num);
		return "User";
	}
	
	@GetMapping({"","/"})
	public @ResponseBody String form(String username, String password, String email) {
		System.out.println(username);
		System.out.println(password);
		System.out.println(email);
		return "User";
	}
	
}
