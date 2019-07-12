package com.invicta.lms.validation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.invicta.lms.dto.LieuLeaveDtoRequest;

@Service

public class LieuLeaveRequestValidation {
	Map<String,String> errors = new HashMap<>();
	public void validationLieuLeaveRequest(LieuLeaveDtoRequest  leaveDtoRequest) {
		errors.clear();
		if(leaveDtoRequest.getUser()==null) {
			errors.put("lieuLeaveRequest", "User is Required");
		}
		if(leaveDtoRequest.getReason()=="") {
			errors.put("lieuLeaveRequest", "Reason Cannot Be Empty");
		}
		if(leaveDtoRequest.getReason()==null) {
			errors.put("lieuLeaveRequest", "Reason is Required");
		}
		if(leaveDtoRequest.getWorkedHours()==null) {
			errors.put("lieuLeaveRequest", "Worke hours is Required");
		}
//		if(leaveDtoRequest.getWorkedHours()>0) {
//			errors.put("lieuLeaveRequest", "Worke hours Cannot Be less than zero");
//		}
		if(leaveDtoRequest.getStartDate()==null) {
			errors.put("lieuLeaveRequest", "Start date is Required");
		}
		if(leaveDtoRequest.getEndDate()==null) {
			errors.put("lieuLeaveRequest", "End date is Required");
		}
		
	}
	public Map<String,String> getErrors(){
		return errors;
	}
}
