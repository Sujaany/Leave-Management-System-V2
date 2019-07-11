package com.invicta.lms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.entity.LeaveRequest;
import com.invicta.lms.entity.LeaveType;
import com.invicta.lms.entity.User;
import com.invicta.lms.enums.LeaveRequestStatus;
import com.invicta.lms.repository.LeaveRequestRepository;
import com.invicta.lms.service.LeaveRequestService;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

	@Autowired
	LeaveRequestRepository leaveRequestRepository;
	
	@Override
	public LeaveRequest addLeaveRequest(LeaveRequest leaveRequest,User user,LeaveType leaveType) {
		if(leaveRequest != null) {
			leaveRequest.setLeaveRequestStatus(LeaveRequestStatus.PENDING);
			leaveRequest.setRequestedBy(user);
			leaveRequest.setLeaveType(leaveType);
			return leaveRequestRepository.save(leaveRequest);
		}
		return null;
	}

	@Override
	public List<LeaveRequest> viewAllLeaveRequest() {
		return leaveRequestRepository.findAll();
	}

	@Override
	public Long deleteLeaveRequest(Long id) {
		if(leaveRequestRepository.getOne(id)!=null) {
			leaveRequestRepository.deleteById(id);
			 return id;
			}
			return null;
		}

	@Override
	public LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequest,User user,LeaveType leaveType) {
		if(leaveRequestRepository.getOne(id)!= null) {
			leaveRequest.setId(id);
			leaveRequest.setLeaveRequestStatus(LeaveRequestStatus.PENDING);
			leaveRequest.setRequestedBy(user);
			leaveRequest.setLeaveType(leaveType);
			return leaveRequestRepository.save(leaveRequest);
		}
		return null;
	}

	@Override
	public LeaveRequest findLeaveRequestById(Long id) {
		if(leaveRequestRepository.getOne(id)!= null) {
			return leaveRequestRepository.findLeaveRequestById(id);
		}
		return null;
	}
}
