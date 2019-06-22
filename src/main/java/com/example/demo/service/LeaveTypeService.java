package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.LeaveType;

public interface LeaveTypeService {
	Boolean addLeaveType(LeaveType leaveType);
	List<LeaveType> viewAllLeaveType();
	Boolean deleteLeaveType(Integer id);
	Boolean updateLeaveType(Integer id,LeaveType leaveType);
	Boolean findLeaveTypeById(Integer id);
}
