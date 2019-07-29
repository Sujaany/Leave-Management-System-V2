package com.invicta.lms.service;

import java.util.List;

import com.invicta.lms.entity.LeaveRequest;
import com.invicta.lms.entity.LeaveType;
import com.invicta.lms.entity.User;

public interface LeaveRequestService {
	LeaveRequest addLeaveRequest(LeaveRequest leaveRequest,User user,LeaveType leaveType);
	Boolean createInitialLeaveRequestProcess(LeaveRequest leaveRequest,User user,LeaveType leaveType);
	List<LeaveRequest> viewAllLeaveRequest();
	List<LeaveRequest> viewLeaveRequestByUser(Long id);
	LeaveRequest findLeaveRequestById(Long id);
	Long deleteLeaveRequest(Long id);
	LeaveRequest updateLeaveRequest(Long id,LeaveRequest leaveRequest,User user,LeaveType leaveType);
	
}
