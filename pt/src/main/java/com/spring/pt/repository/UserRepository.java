package com.spring.pt.repository;

import com.spring.pt.model.User;

public interface UserRepository {
	
	public void save(User user);
	public User login(User user);
}
