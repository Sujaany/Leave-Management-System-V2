package com.invicta.lms.dto.mapper;

import com.invicta.lms.dto.LeaveDaysProcessorDtoRequest;
import com.invicta.lms.entity.LeaveDaysProcessor;

public class LeaveDaysProcessorDtoMapper {
	
	public static LeaveDaysProcessor mapLeaveDaysProcessorDtoToLeaveDaysProcessor(LeaveDaysProcessorDtoRequest leaveDaysProcessorDtoRequest) {
		LeaveDaysProcessor leaveDaysProcessor = new LeaveDaysProcessor();
		leaveDaysProcessor.setId(leaveDaysProcessorDtoRequest.getId());
		leaveDaysProcessor.setLeaveProcessType(leaveDaysProcessorDtoRequest.getLeaveProcessType());
		leaveDaysProcessor.setDays(leaveDaysProcessorDtoRequest.getDays());
		leaveDaysProcessor.setDateOfProcess(leaveDaysProcessorDtoRequest.getDateOfProcess());
		
		return leaveDaysProcessor;
	}
}
