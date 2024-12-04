package com.example.slackproject.dto;

import java.util.Date;

public class ScheduleDTO {
	private int scheduledId;
	private String userId;
	private String scheduleTitle;
	private String scheduleContent;
	private Date scheduleDate;
	private String scheduleTime;
	private String scheduleRegDate;
	
	public int getScheduledId() {
		return scheduledId;
	}
	public void setScheduledId(int scheduledId) {
		this.scheduledId = scheduledId;
	}
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
	public Date getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
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
