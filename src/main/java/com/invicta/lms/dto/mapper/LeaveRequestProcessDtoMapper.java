package com.invicta.lms.dto.mapper;

import com.invicta.lms.dto.LeaveProcessDtoRequest;
import com.invicta.lms.entity.LeaveRequestProcess;

public class LeaveRequestProcessDtoMapper {
	public static LeaveRequestProcess LeaveRequestProcessDtoToLeaveRequestProcess(LeaveProcessDtoRequest leaveProcessDtoRequest ) {
		LeaveRequestProcess leaveRequestProcess = new  LeaveRequestProcess();
		leaveRequestProcess.setId(leaveProcessDtoRequest.getId());
		leaveRequestProcess.setReason(leaveProcessDtoRequest.getReason());
		return leaveRequestProcess;
	}
}
