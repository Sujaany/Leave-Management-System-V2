package com.invicta.lms.dto;

import java.sql.Date;

public class LeaveDaysProcessorDto {

	private Long id;
	private Long user_id;
	private String leaveType;
	private String leaveProcessType;
	private Double Days;
	private Date Date_of_process;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveProcessType() {
		return leaveProcessType;
	}
	public void setLeaveProcessType(String leaveProcessType) {
		this.leaveProcessType = leaveProcessType;
	}
	public Double getDays() {
		return Days;
	}
	public void setDays(Double days) {
		Days = days;
	}
	public Date getDate_of_process() {
		return Date_of_process;
	}
	public void setDate_of_process(Date date_of_process) {
		Date_of_process = date_of_process;
	}
	
	
}
