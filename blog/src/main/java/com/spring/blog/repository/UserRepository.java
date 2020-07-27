package com.spring.blog.repository;

import java.util.List;

import com.spring.blog.model.User;

public interface UserRepository {

	public List<User> findAll();
}
