package com.invicta.lms.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import com.invicta.lms.dto.LieuLeaveDtoResponse;
import com.invicta.lms.entity.LieuLeaveRequest;

public class LieuLeaveRequestMapper {
	public static LieuLeaveDtoResponse mapLieuLeaveRequestToLieuLeaveRequestDto(LieuLeaveRequest lieuLeaveRequest) {
		LieuLeaveDtoResponse lieuLeaveDtoResponse = new LieuLeaveDtoResponse();
		lieuLeaveDtoResponse.setId(lieuLeaveRequest.getId());
		lieuLeaveDtoResponse.setUserName(lieuLeaveRequest.getUser().getUserName());
		lieuLeaveDtoResponse.setStartDate(lieuLeaveRequest.getStartDate());
		lieuLeaveDtoResponse.setEndDate(lieuLeaveRequest.getEndDate());
		lieuLeaveDtoResponse.setWorkedHours(lieuLeaveRequest.getWorkedHours());
		lieuLeaveDtoResponse.setReason(lieuLeaveRequest.getReason());
		lieuLeaveDtoResponse.setCreatedAt(lieuLeaveRequest.getCreatedAt());
		lieuLeaveDtoResponse.setUpdatedAt(lieuLeaveRequest.getUpdatedAt());
		return lieuLeaveDtoResponse;

	}

	public static List<LieuLeaveDtoResponse> mapLieuLeaveRequestListToLieuLeaveRequestDtoList(
			List<LieuLeaveRequest> lieuLeaveRequestList) {
		List<LieuLeaveDtoResponse> lieuLeaveRequestDtoList = new ArrayList<LieuLeaveDtoResponse>();
		if (lieuLeaveRequestList != null) {
			for (LieuLeaveRequest lieuLeaveRequest : lieuLeaveRequestList) {
				lieuLeaveRequestDtoList.add(mapLieuLeaveRequestToLieuLeaveRequestDto(lieuLeaveRequest));
			}
		}
		return lieuLeaveRequestDtoList;

	}

}
