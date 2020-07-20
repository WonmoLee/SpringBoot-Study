package com.spring.pt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pt.model.User;
import com.spring.pt.repository.UserRepository;

//Controller, Repository, Configuration, Service, Component
//RestController, Bean

@Service//IoC
public class UserService {

	@Autowired
	private UserRepository userRepository; //DI
	
	public void 회원가입(User user) {
		userRepository.save(user);
	}
}
