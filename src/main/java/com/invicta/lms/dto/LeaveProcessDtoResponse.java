package com.invicta.lms.dto;

import com.invicta.lms.enums.LeaveRequestAction;

public class LeaveProcessDtoResponse {

	private Long id;
	private Long leaveRequestId;
	private LeaveRequestAction leaveRequestAction;
	private String reason;
	private UserInfoDtoResponse userInfo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLeaveRequestId() {
		return leaveRequestId;
	}
	public void setLeaveRequestId(Long leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}
	public LeaveRequestAction getLeaveRequestAction() {
		return leaveRequestAction;
	}
	public void setLeaveRequestAction(LeaveRequestAction leaveRequestAction) {
		this.leaveRequestAction = leaveRequestAction;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public UserInfoDtoResponse getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoDtoResponse userInfo) {
		this.userInfo = userInfo;
	}
	
	
}
