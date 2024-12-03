package com.example.slackproject.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ErrorController {

	
	@GetMapping("/authoerror")
	public String AuthorizationError() {
		return "/error/AuthorizationError";
	}
	
	@GetMapping("/error")
	public String Error() {
		return "/error/error";
	}
}
