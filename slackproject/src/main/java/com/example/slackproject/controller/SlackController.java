package com.example.slackproject.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.slackproject.mapper.SlackService;
import com.slack.api.methods.SlackApiException;

@RestController
public class SlackController {
	@Autowired
	private SlackService slackService;
	
	@GetMapping("/slack_msg")
	public String sendMessage(String message) {
		try {
			message = "slack 연동 성공";
			slackService.sendMessage(message);
			return "Message sent Successfully";
		}catch(IOException | SlackApiException e) {
			return "Error Message: " + e.getMessage();
		}
	}

}
