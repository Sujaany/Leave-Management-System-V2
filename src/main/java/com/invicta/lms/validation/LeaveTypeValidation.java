package com.invicta.lms.validation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.dto.LeaveTypeDto;
import com.invicta.lms.service.LeaveTypeService;

@Service
public class LeaveTypeValidation {
	@Autowired
	LeaveTypeService leaveTypeService;
	
	Map<String,String> errors = new HashMap<>();
	public void validationLeaveType(LeaveTypeDto leaveTypeDto) {
		errors.clear();
		if(leaveTypeDto.getLeaveType() ==null) {
			errors.put("LeaveType", "Leave type cannot be null");
		}
		if(leaveTypeDto.getLeaveType() == "") {
			errors.put("LeaveType", "Leave type cannot be Empty");
		}
		if(leaveTypeService.existsByleaveType(leaveTypeDto.getLeaveType())) {
			errors.put("LeaveType", "Leave type Already exist");
		}
	}
	public Map<String,String> getErrors(){
		return errors;
	}

}
