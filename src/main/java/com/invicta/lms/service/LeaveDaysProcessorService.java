package com.invicta.lms.service;

import java.util.List;

import com.invicta.lms.entity.LeaveDaysProcessor;
import com.invicta.lms.entity.LeaveType;
import com.invicta.lms.entity.User;

public interface LeaveDaysProcessorService {
	
	LeaveDaysProcessor addLeaveDaysProcessor(LeaveDaysProcessor leaveDaysProcessor,User user,LeaveType leaveType);
	List<LeaveDaysProcessor> viewAllLeaveDaysProcessor();
	LeaveDaysProcessor updateLeaveDaysProcessor(Long id,LeaveDaysProcessor leaveDaysProcessor,User user,LeaveType leaveType);
	LeaveDaysProcessor findLeaveDaysProcessorById(Long id);
	Long deleteLeaveDaysProcessor(Long id);

}
