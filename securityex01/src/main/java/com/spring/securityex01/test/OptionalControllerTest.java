package com.spring.securityex01.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.securityex01.model.User;
import com.spring.securityex01.repository.UserRepository;

@RestController
public class OptionalControllerTest {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/test/user/{id}")
	public User 옵셔널_유저찾기(@PathVariable int id) {
		//첫번째 방법
//		Optional<User> userOptional = userRepository.findById(id);
//		User user;
//		if (userOptional.isPresent()) {
//			user = userOptional.get();
//		} else {
//			user = new User();
//		}
		
		//두번째방법
//		User user = userRepository.findById(id).orElseGet(()-> {
//			
//				return User.builder().id(5).username("아무개").email("asdkas@naver.ocom").build();
//		});
//		
		
		//3번째방법
		User user = userRepository.findById(id)
				.orElseThrow(new Supplier<NullPointerException>() {
					
					@Override
					public NullPointerException get() {
						
						return new NullPointerException("값 없어");
					}
				});
		return user;
	}
}
