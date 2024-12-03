package com.example.slackproject.dto;

import java.util.Date;

public class AttendDTO {
	private int attendId;
	private String userId;
	private String attendMemo;
	private Date startWorkTime;
	private Date leaveWorkTime;
	private String workHours;
	private String attendDate;
	
	public int getAttendId() {
		return attendId;
	}
	public void setAttendId(int attendId) {
		this.attendId = attendId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAttendMemo() {
		return attendMemo;
	}
	public Date getStartWorkTime() {
		return startWorkTime;
	}
	public void setStartWorkTime(Date startWorkTime) {
		this.startWorkTime = startWorkTime;
	}
	public Date getLeaveWorkTime() {
		return leaveWorkTime;
	}
	public void setLeaveWorkTime(Date leaveWorkTime) {
		this.leaveWorkTime = leaveWorkTime;
	}
	public void setAttendMemo(String attendMemo) {
		this.attendMemo = attendMemo;
	}
	public String getWorkHours() {
		return workHours;
	}
	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}
	public String getAttendDate() {
		return attendDate;
	}
	public void setAttendDate(String attendDate) {
		this.attendDate = attendDate;
	}
}
