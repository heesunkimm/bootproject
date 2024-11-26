package com.example.slackproject.dto;

import java.time.LocalDateTime;

public class AttendDTO {
	private String userId;
	private String attendMemo;
	private LocalDateTime startWorkTime;
	private LocalDateTime leaveWorkTime;
	private String attendDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAttendMemo() {
		return attendMemo;
	}
	public void setAttendMemo(String attendMemo) {
		this.attendMemo = attendMemo;
	}
	public LocalDateTime getStartWorkTime() {
		return startWorkTime;
	}
	public void setStartWorkTime(LocalDateTime startWorkTime) {
		this.startWorkTime = startWorkTime;
	}
	public LocalDateTime getLeaveWorkTime() {
		return leaveWorkTime;
	}
	public void setLeaveWorkTime(LocalDateTime leaveWorkTime) {
		this.leaveWorkTime = leaveWorkTime;
	}
	public String getAttendDate() {
		return attendDate;
	}
	public void setAttendDate(String attendDate) {
		this.attendDate = attendDate;
	}
}
