package com.lwm.jwtex01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lwm.jwtex01.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
