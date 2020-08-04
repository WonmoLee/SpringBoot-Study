package com.spring.securityex01.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.spring.securityex01.model.User;

//Authentication 객체에 저장할 수 있는 유일한 타입
public class PrincipalDetails implements UserDetails, OAuth2User{

	private User user;
	private Map<String, Object> attributes;
	
	public PrincipalDetails(User user) {
		super();
		this.user = user;
	}
	
	//OAuth2.0 로그인시 사용
	public PrincipalDetails(User user, Map<String, Object> attributes) {
		this.user = user;
		this.attributes = attributes;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	//계정만료확인 메서드 (true는 계정이 만료되지 않은것)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//계정 활성화 여부
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	//계정 권한
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(()->{ return user.getRole();});
		return authList;
	}

	//리소스 서버로부터 받는 회원 정보
	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public String getName() {
		return user.getId() + "";
	}

	public User getUser() {
		return user;
	}
	
	
	
}
