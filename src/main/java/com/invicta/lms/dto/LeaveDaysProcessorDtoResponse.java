package com.invicta.lms.dto;

import java.sql.Date;

import com.invicta.lms.enums.LeaveProcessType;

public class LeaveDaysProcessorDtoResponse {
	
	private Long id;
	private String userName;
	private String leaveType;
	private LeaveProcessType leaveProcessType;
	private Double days;
	private Date dateOfProcess;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public LeaveProcessType getLeaveProcessType() {
		return leaveProcessType;
	}
	public void setLeaveProcessType(LeaveProcessType leaveProcessType) {
		this.leaveProcessType = leaveProcessType;
	}
	public Double getDays() {
		return days;
	}
	public void setDays(Double days) {
		this.days = days;
	}
	public Date getDateOfProcess() {
		return dateOfProcess;
	}
	public void setDateOfProcess(Date dateOfProcess) {
		this.dateOfProcess = dateOfProcess;
	}
	
	
}
