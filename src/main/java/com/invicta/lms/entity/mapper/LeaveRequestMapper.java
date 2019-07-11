package com.invicta.lms.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import com.invicta.lms.dto.LeaveDtoResponse;
import com.invicta.lms.entity.LeaveRequest;



public class LeaveRequestMapper {
	public static LeaveDtoResponse mapLeaveRequestToLeaveDtoResponse(LeaveRequest leaveRequest) {
		LeaveDtoResponse leaveDtoResponse = new LeaveDtoResponse();
		leaveDtoResponse.setId(leaveRequest.getId());
		leaveDtoResponse.setStartDate(leaveRequest.getStartDate());
		leaveDtoResponse.setEndDate(leaveRequest.getEndDate());
		leaveDtoResponse.setNoOfDays(leaveRequest.getNoOfDays());
		leaveDtoResponse.setReason(leaveRequest.getReason());
		leaveDtoResponse.setLeaveStatus(leaveRequest.getLeaveRequestStatus().name());
		leaveDtoResponse.setLeaveType(leaveRequest.getLeaveType().getLeaveType());
		leaveDtoResponse.setRequestedBy(leaveRequest.getRequestedBy().getUserName());
		
		return leaveDtoResponse;
	}
	
	public static List<LeaveDtoResponse> mapLeaveRequestListToLeaveDtoResponseList(List<LeaveRequest> leaveRequestList){
		List<LeaveDtoResponse> leaveDtoResponseList = new ArrayList<LeaveDtoResponse>();
		if(leaveRequestList != null) {
			for(LeaveRequest leaveRequest:leaveRequestList) {
				leaveDtoResponseList.add(mapLeaveRequestToLeaveDtoResponse(leaveRequest));
			}
		}
		return leaveDtoResponseList;
	}
}
