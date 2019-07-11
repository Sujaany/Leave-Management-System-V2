package com.invicta.lms.dto.mapper;

import com.invicta.lms.dto.LeaveDtoRequest;
import com.invicta.lms.entity.LeaveRequest;
import com.invicta.lms.entity.LeaveType;
import com.invicta.lms.entity.User;

public class LeaveRequestDtoMapper {
	public static LeaveRequest mapLeaveDtoRequestToLeaveRequest(LeaveDtoRequest leaveDtoRequest) {
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setId(leaveDtoRequest.getId());
		leaveRequest.setLeaveRequestStatus(leaveDtoRequest.getLeaveRequestStatus());
		leaveRequest.setStartDate(leaveDtoRequest.getStartDate());
		leaveRequest.setEndDate(leaveDtoRequest.getEndDate());
		leaveRequest.setNoOfDays(leaveDtoRequest.getNoOfDays());
		leaveRequest.setReason(leaveDtoRequest.getReason());
		
		User user=new User();
		user.setId(leaveDtoRequest.getRequestedBy());
		
		LeaveType leaveType= new LeaveType();
		leaveType.setId(leaveDtoRequest.getLeaveType());
		return leaveRequest;
	}
}
