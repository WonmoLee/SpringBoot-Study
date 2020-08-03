package com.spring.securityex01.config.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
	
	//userRequest는 code를 받아서 accessToken을 응답받은 객체
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest);
		//OAuth2User 정보를 어디에 담아서 무엇을 리턴하면 될까
		//1번: PrincipalDetails에 OAuth2User 정보를 집어 넣어준다.
		//2번: PrincipalDetails를 리턴한다.
		System.out.println("oAuth2User : " + oAuth2User);
		System.out.println("userRequest : " + userRequest.getAccessToken().getTokenValue());
		System.out.println("userRequest : " + userRequest.getClientRegistration());
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return super.loadUser(userRequest);
	}
	
	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
		
		// 일반적으로 로그인할 때 유저 정보 User
		
		//1. OAuth2로 로그인 할 때 유저 정보 attributes(OAuth2User) <- 이거 구성해야함
		//2. DB에 이사람잇나?
		
		//있으면?
		//-->update해야함.
		
		//없으면?
		//-->없으면 insert해야함.
		
		//return PrincipalDetails()
		return null;
	}
}
