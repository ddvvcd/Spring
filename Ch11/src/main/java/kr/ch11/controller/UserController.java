package kr.ch11.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ch11.dto.UserRequestDTO;
import kr.ch11.entity.UserEntity;
import kr.ch11.jwt.JwtProvider;
import kr.ch11.security.MyUserDetails;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //한번에 주입하는 생성자 관련 (파이널 설정 해줘야 함)
@RestController
public class UserController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtProvider jwtProvider;
	
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody UserRequestDTO dto) {
		
		try {
			//Security 인증처리()
			UsernamePasswordAuthenticationToken authenticationToken
				= new UsernamePasswordAuthenticationToken(dto.getUid(), dto.getPass());
			
			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
			
			UserEntity user = userDetails.getUser();
			
			//토큰 발행 (2개 발행)
			String accessToken = jwtProvider.createToken(user, 1);	// 1일
			String refreshToken = jwtProvider.createToken(user, 7); // 7일
			
			Map<String, String> resultMap = Map.of("grantType", "Bearer", 
												   "accessToken", accessToken,
												   "refreshToken", refreshToken);
			
			return resultMap;
			
		}catch (Exception e) {
			Map<String, String> resultMap = Map.of("grantType", "None", 
												   "message", e.getMessage());
			
			return resultMap;
		}
	}
	
}
