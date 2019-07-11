package com.invicta.lms.dto;

import java.util.Date;

import com.invicta.lms.enums.LeaveRequestStatus;

public class LeaveDtoRequest {
	private Long id;
	private Long requestedBy;
	private Long leaveType;
	private Date startDate;
	private Date endDate;
	private Double noOfDays;
	private String reason;
	private LeaveRequestStatus leaveRequestStatus;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(Long requestedBy) {
		this.requestedBy = requestedBy;
	}
	public Long getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(Long leaveType) {
		this.leaveType = leaveType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Double getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(Double noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LeaveRequestStatus getLeaveRequestStatus() {
		return leaveRequestStatus;
	}
	public void setLeaveRequestStatus(LeaveRequestStatus leaveRequestStatus) {
		this.leaveRequestStatus = leaveRequestStatus;
	}
	
	
}
