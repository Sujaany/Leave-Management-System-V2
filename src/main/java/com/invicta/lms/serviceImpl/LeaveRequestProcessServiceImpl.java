package com.invicta.lms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.entity.LeaveRequest;
import com.invicta.lms.entity.LeaveRequestProcess;
import com.invicta.lms.entity.User;
import com.invicta.lms.enums.LeaveRequestAction;
import com.invicta.lms.repository.LeaveRequestProcessRepository;
import com.invicta.lms.service.LeaveRequestProcessService;
import com.invicta.lms.service.LeaveRequestService;

@Service
public class LeaveRequestProcessServiceImpl implements LeaveRequestProcessService{
	@Autowired
	private LeaveRequestProcessRepository leaveRequestProcessRepository;
	@Autowired 
	private LeaveRequestService LeaveRequestService;
	
	@Override
	public Boolean createLeaveRequestProcess(LeaveRequestProcess leaveRequestProcess,
			LeaveRequest leaveRequest, User user) {
			leaveRequestProcess.setProcessedBy(user);
			leaveRequestProcess.setLeaveRequest(leaveRequest);
		if(leaveRequestProcessRepository.save(leaveRequestProcess)!= null) {
			return true ;
		}
		return false;
	}
	
	@Override
	public Boolean processLeaveRequest(LeaveRequestProcess leaveRequestProcess,LeaveRequestAction leaveRequestAction,User user,Long lid) {
		if(lid != user.getId()) {
			leaveRequestProcess.setLeaveRequestTrackType(leaveRequestAction);
			createLeaveRequestProcess(leaveRequestProcess, LeaveRequestService.findLeaveRequestById(lid), user);
			return true;
		}
		return false ;
	}

	
}
