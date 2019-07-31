package com.invicta.lms.dto.mapper;

import org.springframework.stereotype.Service;

import com.invicta.lms.dto.LeaveProcessDtoRequest;
import com.invicta.lms.dto.LeaveProcessDtoResponse;
import com.invicta.lms.dto.UserInfoDtoResponse;
import com.invicta.lms.entity.LeaveRequestProcess;

@Service
public class LeaveRequestProcessMapper {
	public LeaveRequestProcess mapDtoToEntity(LeaveProcessDtoRequest leaveProcessDtoRequest,LeaveRequestProcess leaveRequestProcess ) {
		leaveRequestProcess.setLeaveRequestAction(leaveProcessDtoRequest.getLeaveRequestAction());
		leaveRequestProcess.setReason(leaveProcessDtoRequest.getReason());
		return leaveRequestProcess;
	}
	
	public LeaveProcessDtoResponse mapEntityToDto(LeaveRequestProcess leaveRequestProcess) {
		LeaveProcessDtoResponse leaveProcessDtoResponse=new LeaveProcessDtoResponse();
		leaveProcessDtoResponse.setId(leaveRequestProcess.getId());
		leaveProcessDtoResponse.setLeaveRequestAction(leaveRequestProcess.getLeaveRequestAction());
		leaveProcessDtoResponse.setLeaveRequestId(leaveRequestProcess.getLeaveRequest().getId());
		leaveProcessDtoResponse.setReason(leaveProcessDtoResponse.getReason());
		
		UserInfoDtoResponse userInfoDtoResponse=new UserInfoDtoResponse();
		userInfoDtoResponse.setUserId(leaveRequestProcess.getProcessUser().getId());
		userInfoDtoResponse.setUserName(leaveRequestProcess.getProcessUser().getUserName());
		
		leaveProcessDtoResponse.setUserInfo(userInfoDtoResponse);
		return leaveProcessDtoResponse;
	}
}
