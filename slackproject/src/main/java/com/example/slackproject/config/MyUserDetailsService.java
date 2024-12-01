package com.example.slackproject.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.slackproject.dto.UserDTO;
import com.example.slackproject.mapper.MemberServiceMapper;

public class MyUserDetailsService implements UserDetailsService {

	private final MemberServiceMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public MyUserDetailsService(MemberServiceMapper mapper, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		UserDTO userDTO = new UserDTO();
		userDTO = mapper.findUsernameById(userId);
		
		// ID가 DB에 있는 경우
		return User.builder()
				.username(userDTO.getUserId())
				.password(userDTO.getUserPw())
				.roles(userDTO.getUserRoles())
				.build();
	}
}
