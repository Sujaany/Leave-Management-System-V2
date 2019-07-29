package com.invicta.lms.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import com.invicta.lms.dto.LeaveDaysProcessorDtoResponse;
import com.invicta.lms.dto.LeaveTypeDto;
import com.invicta.lms.entity.LeaveDaysProcessor;


public class LeaveDaysProcessorMapper {
	
	public static LeaveDaysProcessorDtoResponse mapLeaveDaysProcessorToLeaveDaysProcessorDto(LeaveDaysProcessor leaveDaysProcessor) {
		LeaveDaysProcessorDtoResponse leaveDaysProcessorDtoResponse =new LeaveDaysProcessorDtoResponse();
		leaveDaysProcessorDtoResponse.setId(leaveDaysProcessor.getId());
		leaveDaysProcessorDtoResponse.setDateOfProcess(leaveDaysProcessor.getDateOfProcess());
		leaveDaysProcessorDtoResponse.setDays(leaveDaysProcessor.getDays());
		leaveDaysProcessorDtoResponse.setLeaveProcessType(leaveDaysProcessor.getLeaveProcessType());
		leaveDaysProcessorDtoResponse.setUserName(leaveDaysProcessor.getUser().getUserName());
		
		LeaveTypeDto leaveTypeDto=new LeaveTypeDto();
		leaveTypeDto.setId(leaveDaysProcessor.getLeaveType().getId());
		leaveTypeDto.setLeaveTypeName(leaveDaysProcessor.getLeaveType().getLeaveTypeName());
		leaveDaysProcessorDtoResponse.setLeaveType(leaveTypeDto);
		
		return leaveDaysProcessorDtoResponse;
		
	}	
	
	public static List<LeaveDaysProcessorDtoResponse> mapLeaveDaysProcessorToLeaveDaysProcessorDtoList(List<LeaveDaysProcessor> leaveDaysProcessorList){
		List<LeaveDaysProcessorDtoResponse> leaveDaysProcessorDtoList = new ArrayList<LeaveDaysProcessorDtoResponse>();
		if(leaveDaysProcessorList != null) {
			for(LeaveDaysProcessor leaveDaysProcessor:leaveDaysProcessorList) {
				leaveDaysProcessorDtoList.add(mapLeaveDaysProcessorToLeaveDaysProcessorDto(leaveDaysProcessor));	
			}
		}
		return leaveDaysProcessorDtoList;
		
	}
}


