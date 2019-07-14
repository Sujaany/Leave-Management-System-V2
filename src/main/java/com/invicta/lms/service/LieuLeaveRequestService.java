package com.invicta.lms.service;

import java.util.List;

import com.invicta.lms.entity.LieuLeaveRequest;
import com.invicta.lms.entity.User;

public interface LieuLeaveRequestService {

	LieuLeaveRequest applyLeieuLeave(LieuLeaveRequest lieuLeaveRequest, User User);

	List<LieuLeaveRequest> viewAllLieuLeaveRequest();

	Long deleteLieuLeaveRequest(Long id);

	LieuLeaveRequest updateLieuLeaveRequest(Long id, LieuLeaveRequest lieuLeaveRequest,User user);

	LieuLeaveRequest findLieuLeaveRequestById(Long id);
	
	List<LieuLeaveRequest> findByUser(Long id);


}
