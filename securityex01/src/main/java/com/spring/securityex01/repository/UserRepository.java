package com.spring.securityex01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.securityex01.model.User;

//JpaRepository를 상속하면 자동 컴포넌트 스캔됨.
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	//Jpa Naming전략
	//SELECT * FROM USER WHERE USERNAME=?1
	User findByUsername(String username);
	
	
	//SELECT * FROM USER WHERE PROVIDER = ?1 AND PROVIDERID = ?2
//	@Query(value = "SELECT * FROM USER WHERE PROVIDER = ?1 AND PROVIDERID = ?2", nativeQuery = true)
	Optional<User> findByProviderAndProviderId(String provider, String providerId);
	//SELECT * FROM USER WHERE USERNAME=1? AND PASSWORD = 2?
//	User findByUsernameAndPassword(String username, String password);
//	@Query(value = "SELECT * FROM USER", nativeQuery = true)
//	User find마음대로();
}
