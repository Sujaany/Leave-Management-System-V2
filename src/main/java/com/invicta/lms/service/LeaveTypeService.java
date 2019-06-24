package com.invicta.lms.service;

import java.util.List;

import com.invicta.lms.entity.LeaveType;

public interface LeaveTypeService {
	Boolean addLeaveType(LeaveType leaveType);
	List<LeaveType> viewAllLeaveType();
	Boolean deleteLeaveType(Integer id);
	Boolean updateLeaveType(Integer id,LeaveType leaveType);
	Boolean findLeaveTypeById(Integer id);
}
