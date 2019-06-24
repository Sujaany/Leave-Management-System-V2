package com.invicta.lms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.entity.LeaveRequest;
import com.invicta.lms.repository.LeaveRequestRepository;
import com.invicta.lms.service.LeaveRequestService;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

	@Autowired
	LeaveRequestRepository leaveRequestRepository;
	
	@Override
	public LeaveRequest addLeaveRequest(LeaveRequest leaveRequest) {
		if(leaveRequest != null) {
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
	public LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequest) {
		if(leaveRequestRepository.getOne(id)!= null) {
			leaveRequest.setId(id);
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
