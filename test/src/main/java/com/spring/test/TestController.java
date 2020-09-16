package com.spring.test;

import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@PostMapping("/json/model")
	public @ResponseBody String jsonModel(@RequestBody User user) {
		return "test";
	}
	
}

