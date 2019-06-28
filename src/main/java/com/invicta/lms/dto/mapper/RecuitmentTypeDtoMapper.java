package com.invicta.lms.dto.mapper;

import com.invicta.lms.dto.RecuitmentTypeDto;
import com.invicta.lms.entity.RecuitmentType;

public class RecuitmentTypeDtoMapper {

	public static RecuitmentType mapRecuitmentTypeDtoToRecuitmentType(RecuitmentTypeDto recuitmentTypeDto) {
		RecuitmentType recuitmentType = new RecuitmentType();
		recuitmentType.setId(recuitmentTypeDto.getId());
		recuitmentType.setRecuitmentType(recuitmentTypeDto.getRecuitmentType());
		return recuitmentType;
	}
}
