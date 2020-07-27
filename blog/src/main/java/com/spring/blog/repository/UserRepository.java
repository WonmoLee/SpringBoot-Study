package com.spring.blog.repository;

import com.spring.blog.model.User;

public interface UserRepository {

	public void save(User user);
	public User login(User user);
}
