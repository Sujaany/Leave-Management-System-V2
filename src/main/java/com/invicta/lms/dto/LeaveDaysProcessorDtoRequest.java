package com.invicta.lms.dto;

import java.sql.Date;

import com.invicta.lms.enums.LeaveProcessType;

public class LeaveDaysProcessorDtoRequest {

	private Long id;
	private Long user;
	private Long leaveType;
	private LeaveProcessType leaveProcessType;
	private Double Days;
	private Date DateOfProcess;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	public Long getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(Long leaveType) {
		this.leaveType = leaveType;
	}
	public LeaveProcessType getLeaveProcessType() {
		return leaveProcessType;
	}
	public void setLeaveProcessType(LeaveProcessType leaveProcessType) {
		this.leaveProcessType = leaveProcessType;
	}
	public Double getDays() {
		return Days;
	}
	public void setDays(Double days) {
		Days = days;
	}
	public Date getDateOfProcess() {
		return DateOfProcess;
	}
	public void setDateOfProcess(Date dateOfProcess) {
		DateOfProcess = dateOfProcess;
	}
		
}
