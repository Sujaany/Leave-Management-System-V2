package com.invicta.lms.validation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.entity.Designation;
import com.invicta.lms.service.DesignationService;

@Service
public class DesignationValidation {
	@Autowired
	DesignationService designationService;

	Map<String, String> errors = new HashMap<String, String>();

	public void validateDesignation(Designation designation) {
		
		errors.clear();

		if (designation.getDesignation() == null) {
			errors.put("designation", "designation cannot be null");
		}

		if (designation.getDesignation() == "") {
			errors.put("designation", "designation cannot be Empty");
		}

		if (designationService.existsByDesignation(designation.getDesignation())) {
			errors.put("designation", "Designation Already exist");
		}

	}

	public Map<String, String> getErrors() {
		return errors;
	}
}
