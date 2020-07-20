package com.spring.pt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.pt.dto.SendRequestDto;
import com.spring.pt.dto.WithDrawRequestDto;
import com.spring.pt.model.Account;
import com.spring.pt.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/account")
	public @ResponseBody List<Account> findAll() {
		return accountService.계좌정보보기();
	}
	
	@PutMapping("/send")
	public @ResponseBody String send(SendRequestDto dto) {

		accountService.송금(dto);

		return "<h1>송금이 완료되었습니다.</h1>";
	}

	@PutMapping("/withdraw")
	public @ResponseBody String withdraw(WithDrawRequestDto dto) {

		accountService.인출(dto);

		return "<h1>인출 완료</h1>";
	}
}
