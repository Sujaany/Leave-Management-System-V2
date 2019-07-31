package com.invicta.lms.dto;

import com.invicta.lms.enums.LeaveRequestAction;

public class LeaveProcessDtoRequest {
	private LeaveRequestAction leaveRequestAction;
	private String reason;
	
	public LeaveProcessDtoRequest(LeaveRequestAction leaveRequestAction, String reason) {
		this.leaveRequestAction = leaveRequestAction;
		this.reason = reason;
	}
	
	public LeaveProcessDtoRequest() {
		
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LeaveRequestAction getLeaveRequestAction() {
		return leaveRequestAction;
	}
	public void setLeaveRequestAction(LeaveRequestAction leaveRequestAction) {
		this.leaveRequestAction = leaveRequestAction;
	}
	
	
}
