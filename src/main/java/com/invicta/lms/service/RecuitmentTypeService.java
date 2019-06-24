package com.invicta.lms.service;

import java.util.List;

import com.invicta.lms.entity.RecuitmentType;

public interface RecuitmentTypeService {
	RecuitmentType addRecuitmentType(RecuitmentType recuitmentType);
	List<RecuitmentType> viewAllRecuitmentType();
	Integer deleteRecuitmentType(Integer id);
	RecuitmentType updateRecuitmentType(Integer id,RecuitmentType recuitmentType);
	RecuitmentType findRecuitmentTypeById(Integer id);

}
