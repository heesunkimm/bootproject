package com.example.slackproject.Exception;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // 전역 예외처리 어노테이션
public class ProjectExceptionHandler {

    // 비로그인 예외처리
    @ExceptionHandler(AuthenticationException.class)
    public String AuthenticationHandlerException(HttpServletRequest req, AuthenticationException e) {
        req.setAttribute("msg", "로그인 세션이 만료되었거나 로그인이 필요합니다. 다시 로그인해주세요.");
        return "redirect:/login";
    }

    // 권한부족 예외처리
    @ExceptionHandler(AccessDeniedException.class)
    public String AccessDeniedHandlerException(HttpServletRequest req, AccessDeniedException e) {
        req.setAttribute("msg", "이 페이지에 접근할 권한이 없습니다.");
        return "error";
    }

    // 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public String HandlerException(HttpServletRequest req, Exception e) {
        req.setAttribute("msg", "Error Message: " + e.getMessage());
        return "error";
    }
}
