package com.invicta.lms.dto;

public class PermissionRequestDto {

	private String userId;
	private boolean checkstatus;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public boolean isCheckstatus() {
		return checkstatus;
	}
	public void setCheckstatus(boolean checkstatus) {
		this.checkstatus = checkstatus;
	}
	
	
	
}
