package com.invicta.lms.validation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.dto.RecruitmentTypeDto;
import com.invicta.lms.service.RecuitmentTypeService;

@Service
public class RecruitmentTypeValidation {
	@Autowired
	RecuitmentTypeService recuitmentTypeService;

	Map<String, String> errors = new HashMap<String, String>();

	public void validateRecruitmentType(RecruitmentTypeDto recruitmentTypeDto) {
		
		errors.clear();

		if (recruitmentTypeDto.getRecuitmentType() == null) {
			errors.put("recuitmentType", "Recruitment type cannot be null");
		}

		if (recruitmentTypeDto.getRecuitmentType() == "") {
			errors.put("recuitmentType", "Recruitment type cannot be Empty");
		}

		if (recuitmentTypeService.existsByRecuitmentType(recruitmentTypeDto.getRecuitmentType())) {
			errors.put("recuitmentType", "Recruitment type Already exist");
		}

	}

	public Map<String, String> getErrors() {
		return errors;
	}

}
