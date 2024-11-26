package com.example.slackproject.dto;

public class ScheduleDTO {
	private String userId;
	private String scheduleTitle;
	private String scheduleContent;
	private String scheduleTime;
	private String scheduleRegDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getScheduleTitle() {
		return scheduleTitle;
	}
	public void setScheduleTitle(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}
	public String getScheduleContent() {
		return scheduleContent;
	}
	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}
	public String getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public String getScheduleRegDate() {
		return scheduleRegDate;
	}
	public void setScheduleRegDate(String scheduleRegDate) {
		this.scheduleRegDate = scheduleRegDate;
	}
}
