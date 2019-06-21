package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.LeaveType;

public interface LeaveTypeService {
	LeaveType addLeaveType(LeaveType leaveType);
	List<LeaveType> viewAllLeaveType();
	LeaveType deleteLeaveType(Integer id);
	LeaveType updateLeaveType(Integer id,LeaveType leaveType);
	LeaveType findLeaveTypeById(Integer id);
}
