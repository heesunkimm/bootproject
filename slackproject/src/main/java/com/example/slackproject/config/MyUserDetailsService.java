package com.example.slackproject.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.slackproject.Exception.CustomAuthenticationException;
import com.example.slackproject.dto.UserDTO;
import com.example.slackproject.mapper.MemberServiceMapper;

@Component
public class MyUserDetailsService implements UserDetailsService {
	
	private final MemberServiceMapper mapper;
	
    public MyUserDetailsService(MemberServiceMapper mapper) {
        this.mapper = mapper;
    }
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		UserDTO dto = mapper.findUsernameById(userId);
		
		if(dto == null) {
	        throw new UsernameNotFoundException("가입되지 않은 유저입니다.");
	    }
	    if("F".equals(dto.getUserStatus())) {
	        throw new CustomAuthenticationException("승인대기중입니다.");
	    }
        
        // 해당 ID가 DB에 있는 경우
        return User.builder()
                .username(dto.getUserId())
                .password(dto.getUserPw())
                .roles(dto.getUserRoles())
                .build();
	}
}