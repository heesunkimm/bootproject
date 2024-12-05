package com.example.slackproject.config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res,
			AuthenticationException exception) throws IOException, ServletException {
		String errorMsg = exception.getMessage();
		
		System.out.println("errorMsg: " + errorMsg);
        
        if ("승인대기중입니다.".equals(errorMsg)) {
            res.sendRedirect("/login?approvalFail");
        } else {
            res.sendRedirect("/login?loginError");
        }
	}

}
