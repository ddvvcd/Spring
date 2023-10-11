package kr.ch12.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.ch12.entity.UserEntity;
import kr.ch12.repository.UserRepository;


@Service
public class SecurityUserService implements UserDetailsService{

	@Autowired //인증관리 Filter -> Db로 바로 엑세스
	private UserRepository repo;
	
	
	@Override //중요한 파트임
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// 패스워드에 대한 검사는 이전 컴포넌트(AuthenticationProvider)에서 처리되어 사용자 아이디만 넘어옴		
		UserEntity user = repo.findById(username).get();
		
		// 사용자 인증객체 생성(세션에 저장)
		UserDetails userDetails = MyUserDetails.builder()
									.user(user)
									.build();
		
		return userDetails;
	}

}
