package com.invicta.lms.service;

import java.util.List;

import com.invicta.lms.entity.LeaveRequest;

public interface LeaveRequestService {
	
	LeaveRequest addLeaveRequest(LeaveRequest leaveRequest);
	List<LeaveRequest> viewAllLeaveRequest();
	Long deleteLeaveRequest(Long id);
	LeaveRequest updateLeaveRequest(Long id,LeaveRequest leaveRequest);
	LeaveRequest findLeaveRequestById(Long id);

}
