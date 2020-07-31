package com.spring.securityex01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.securityex01.model.User;

//JpaRepository를 상속하면 자동 컴포넌트 스캔됨.
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	//Jpa Naming전략
	//SELECT * FROM USER WHERE USERNAME=1?
	User findByUsername(String username);
	
	//SELECT * FROM USER WHERE USERNAME=1? AND PASSWORD = 2?
//	User findByUsernameAndPassword(String username, String password);
//	@Query(value = "SELECT * FROM USER", nativeQuery = true)
//	User find마음대로();
}
