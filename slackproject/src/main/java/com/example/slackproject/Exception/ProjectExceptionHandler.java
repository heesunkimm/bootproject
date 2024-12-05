package com.example.slackproject.Exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // 전역 예외처리 어노테이션
public class ProjectExceptionHandler {

    // 권한부족 예외처리
	@ExceptionHandler(AccessDeniedException.class)
    public String AccessDeniedHandlerException(HttpServletRequest req, AccessDeniedException e) {
        req.setAttribute("msg", "이 페이지에 접근할 권한이 없습니다.");
        return "error/authoerror";
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public String NoHandlerFoundException(HttpServletRequest req, NoHandlerFoundException e) {
    	req.setAttribute("msg", "존재하지 않는 페이지입니다.");
    	return "error/error";
    }

    // 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public String HandlerException(HttpServletRequest req, Exception e) {
        req.setAttribute("msg", "Error Message: " + e.getMessage());
        return "error/error";
    }
}
