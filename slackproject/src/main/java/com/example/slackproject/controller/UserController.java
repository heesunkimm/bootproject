package com.example.slackproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.slackproject.mapper.UserMapper;

@Controller
public class UserController {

//	@Autowired
//	UserMapper userMapper;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
}
