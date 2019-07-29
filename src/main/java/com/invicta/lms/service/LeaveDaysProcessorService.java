package com.invicta.lms.service;

import java.util.List;

import com.invicta.lms.dto.LeaveSummary;
import com.invicta.lms.entity.LeaveDaysProcessor;
import com.invicta.lms.entity.LeaveType;
import com.invicta.lms.entity.User;

public interface LeaveDaysProcessorService {
	
	LeaveDaysProcessor addLeaveDaysProcessor(LeaveDaysProcessor leaveDaysProcessor,User user,LeaveType leaveType);
	List<LeaveDaysProcessor> viewAllLeaveDaysProcessor();
	LeaveDaysProcessor updateLeaveDaysProcessor(Long id,LeaveDaysProcessor leaveDaysProcessor,User user,LeaveType leaveType);
	LeaveDaysProcessor findLeaveDaysProcessorById(Long id);
	Long deleteLeaveDaysProcessor(Long id);
	// list all the leaves days for particular user 
	List<LeaveDaysProcessor> findLeaveDaysByUserId(Long userId);
	// list all the leaves days for particular user by leave days and leave type
	List<LeaveDaysProcessor> findLeaveDaysByUserAndLeaveType(Long userId,Long leaveTypeId);
	// list all the leaves days for particular user 
	LeaveSummary leaveSummary(Long userId,Long leaveTypeId);


}
