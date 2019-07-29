package com.invicta.lms.dto;

public class LeaveSummary {
	private String LeaveType;
	private Double Allocation;
	private Double Utilized;
	private Double Remaining;
	
	public String getLeaveType() {
		return LeaveType;
	}
	public void setLeaveType(String leaveType) {
		LeaveType = leaveType;
	}
	public Double getAllocation() {
		return Allocation;
	}
	public void setAllocation(Double allocation) {
		Allocation = allocation;
	}
	public Double getUtilized() {
		return Utilized;
	}
	public void setUtilized(Double utilized) {
		Utilized = utilized;
	}
	public Double getRemaining() {
		return Remaining;
	}
	public void setRemaining(Double remaining) {
		Remaining = remaining;
	}
	
	
}
