package com.spring.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.blog.model.User;
import com.spring.blog.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public int 회원가입(User user) {
		try {
			user.setRole("ROLE_USER");
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.getMessage();
			return -1;
		}
		
	}
	
	@Transactional(readOnly = true)
	public User 로그인(User user) {
		return userRepository.login(user);
		
	}
}
