package com.invicta.lms.service;

import com.invicta.lms.dto.LeaveProcessDtoRequest;
import com.invicta.lms.dto.LeaveProcessDtoResponse;


public interface LeaveRequestProcessService {

	LeaveProcessDtoResponse processLeaveRequest(Long leaveRequestId,Long processUserId,LeaveProcessDtoRequest leaveProcessDtoRequest);
}
