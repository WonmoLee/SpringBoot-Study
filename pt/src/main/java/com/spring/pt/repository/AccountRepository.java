package com.spring.pt.repository;

import java.util.List;

import com.spring.pt.model.Account;

public interface AccountRepository {

	public void update(Account account);
	public List<Account> findAll();
	public Account findByAccountNumber(String accountNumber);
} 
