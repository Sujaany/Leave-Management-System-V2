package com.invicta.lms.service;

import java.util.List;

import com.invicta.lms.entity.LeaveType;

public interface LeaveTypeService {
	LeaveType addLeaveType(LeaveType leaveType);
	List<LeaveType> viewAllLeaveType();
	Integer deleteLeaveType(Integer id);
	LeaveType updateLeaveType(Integer id,LeaveType leaveType);
	LeaveType findLeaveTypeById(Integer id);
}
