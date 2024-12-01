package com.example.slackproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.slackproject.mapper.MainMapper;

@Controller
public class MainController {
	
	@Autowired
	private MainMapper mapper;
	
	@GetMapping("/index")
	public String index(@AuthenticationPrincipal User user) {
	    return "index";
	}

}
