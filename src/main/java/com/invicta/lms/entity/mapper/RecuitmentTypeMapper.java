package com.invicta.lms.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import com.invicta.lms.dto.RecuitmentTypeDto;
import com.invicta.lms.entity.RecuitmentType;

public class RecuitmentTypeMapper {
	public static RecuitmentTypeDto mapRecuitmentTypeToRecuitmentTypeDto(RecuitmentType recuitmentType) {
		RecuitmentTypeDto recuitmentTypeDto = new RecuitmentTypeDto();
		recuitmentTypeDto.setId(recuitmentType.getId());
		recuitmentTypeDto.setRecuitmentType(recuitmentType.getRecuitmentType());

		return recuitmentTypeDto;
	}

	public static List<RecuitmentTypeDto> mapRecuitmentTypeListToRecuitmentTypeDtoList(
			List<RecuitmentType> recuitmentTypeList) {
		List<RecuitmentTypeDto> recuitmentTypeDtoList = new ArrayList<RecuitmentTypeDto>();
		if (recuitmentTypeList != null) {
			for (RecuitmentType recuitmentType : recuitmentTypeList) {
				recuitmentTypeDtoList.add(mapRecuitmentTypeToRecuitmentTypeDto(recuitmentType));
			}
		}
		return recuitmentTypeDtoList;

	}
}
