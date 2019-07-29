package com.invicta.lms.dto.mapper;

import com.invicta.lms.dto.LeaveDtoRequest;
import com.invicta.lms.entity.LeaveRequest;

public class LeaveRequestDtoMapper {
	public static LeaveRequest mapLeaveDtoRequestToLeaveRequest(LeaveDtoRequest leaveDtoRequest) {
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setId(leaveDtoRequest.getId());
		leaveRequest.setLeaveRequestStatus(leaveDtoRequest.getLeaveRequestStatus());
		leaveRequest.setStartDate(leaveDtoRequest.getStartDate());
		leaveRequest.setEndDate(leaveDtoRequest.getEndDate());
		leaveRequest.setNoOfDays(leaveDtoRequest.getNoOfDays());
		leaveRequest.setReason(leaveDtoRequest.getReason());
		return leaveRequest;
	}
}
