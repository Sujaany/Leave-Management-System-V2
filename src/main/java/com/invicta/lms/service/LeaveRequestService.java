package com.invicta.lms.service;

import java.util.List;

import com.invicta.lms.dto.LeaveDtoRequest;
import com.invicta.lms.dto.LeaveDtoResponse;

public interface LeaveRequestService {
	
	Boolean createInitialLeaveRequestProcess(LeaveDtoRequest leaveDtoRequest,Long requestUserId);
	List<LeaveDtoResponse> findAllLeaveRequest();
	List<LeaveDtoResponse> findLeaveRequestByUserId(Long userId);
	LeaveDtoResponse findLeaveRequestById(Long id);
	Long deleteLeaveRequest(Long id);
	
	
}
