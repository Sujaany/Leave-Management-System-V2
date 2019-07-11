package com.invicta.lms.dto.mapper;

import com.invicta.lms.dto.LieuLeaveDtoRequest;
import com.invicta.lms.entity.LieuLeaveRequest;
import com.invicta.lms.entity.User;

public class LieuLeaveRequestDtoMapper {

	public static LieuLeaveRequest mapLieuLeaveRequestDtoToLieuLeaveRequest(LieuLeaveDtoRequest lieuLeaveDtoReuest) {
		LieuLeaveRequest lieuLeaveRequest =new LieuLeaveRequest();
		lieuLeaveRequest.setId(lieuLeaveDtoReuest.getId());
		lieuLeaveRequest.setStartDate(lieuLeaveDtoReuest.getStartDate());
		lieuLeaveRequest.setEndDate(lieuLeaveDtoReuest.getEndDate());
		lieuLeaveRequest.setReason(lieuLeaveDtoReuest.getReason());
		lieuLeaveRequest.setWorkedHours(lieuLeaveDtoReuest.getWorkedHours());
		User user = new User();
		user.setId(lieuLeaveDtoReuest.getUser());
		return lieuLeaveRequest;	
	}
}
