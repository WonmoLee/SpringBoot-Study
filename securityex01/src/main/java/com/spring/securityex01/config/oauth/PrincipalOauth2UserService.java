package com.spring.securityex01.config.oauth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.spring.securityex01.config.auth.PrincipalDetails;
import com.spring.securityex01.config.oauth.provider.FaceBookUserInfo;
import com.spring.securityex01.config.oauth.provider.GoogleUserInfo;
import com.spring.securityex01.config.oauth.provider.OAuth2UserInfo;
import com.spring.securityex01.model.User;
import com.spring.securityex01.repository.UserRepository;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
	
	@Autowired
	private UserRepository userRepository;
	
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
			
		}
		return processOAuth2User(userRequest, oAuth2User);
	}
	
	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
		
		//Attribute를 파싱해서 공통 객체로 묶는다. 관리가 편하기 때문이다.
		OAuth2UserInfo oAuth2UserInfo = null;
		if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
			oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
		} else if (userRequest.getClientRegistration().getRegistrationId().equals("facebook")){
			oAuth2UserInfo = new FaceBookUserInfo(oAuth2User.getAttributes());
		} else {
			System.out.println("우리는 구글과 페이스북만 지원합니다.");
		}
		
		System.out.println("oAuth2UserInfo.getProvider() : " + oAuth2UserInfo.getProvider());
		System.out.println("oAuth2UserInfo.getProviderId() : " + oAuth2UserInfo.getProviderId());
		Optional<User> userOptional = userRepository.findByProviderAndProviderId(oAuth2UserInfo.getProvider(), oAuth2UserInfo.getProviderId());
		
		User user;
		if (userOptional.isPresent()) {
			user = userOptional.get();
		} else {
			//user의 패스워드가 null이기 때문에 OAuth 유저는 일반적인 로그인을 할 수 없음.
			user = User.builder()
					.username(oAuth2UserInfo.getProvider() + "_" + oAuth2UserInfo.getProviderId())
					.email(oAuth2UserInfo.getEmail())
					.role("ROLE_USER")
					.provider(oAuth2UserInfo.getProvider())
					.providerId(oAuth2UserInfo.getProviderId())
					.build();
			userRepository.save(user);
		}
		
		return new PrincipalDetails(user, oAuth2User.getAttributes());
	}
}