package com.invicta.lms.dto;


public class LeaveProcessDtoRequest {
	private Long id;
	private Long leaveRequest;
	private Long processedBy;
	private String reason;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLeaveRequest() {
		return leaveRequest;
	}
	public void setLeaveRequest(Long leaveRequest) {
		this.leaveRequest = leaveRequest;
	}
	public Long getProcessedBy() {
		return processedBy;
	}
	public void setProcessedBy(Long processedBy) {
		this.processedBy = processedBy;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
