package com.spring.pt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@GetMapping("/test")
	public String test() {
		return "데이터입니다.";
	}
	
	//인증필요
	@GetMapping("/test/user/{id}")
	public String findUser() {
		return "<h1>유저 찾기 페이지</h1>";
	}
	
	//인증 필요없음
	@GetMapping("/test/post/{id}")
	public String findPost() {
		return "<h1>글 상세보기 페이지</h1>";
	}
	
	//인증 필요 + 관리자 권한 필요
	@GetMapping("/test/admin")
	public String admin() {
		return "<h1>관리자 페이지</h1>";
	}
}
