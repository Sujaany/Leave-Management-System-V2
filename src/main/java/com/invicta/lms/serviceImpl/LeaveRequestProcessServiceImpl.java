package com.invicta.lms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.dto.LeaveProcessDtoRequest;
import com.invicta.lms.dto.LeaveProcessDtoResponse;
import com.invicta.lms.dto.mapper.LeaveRequestProcessMapper;
import com.invicta.lms.entity.LeaveRequestProcess;
import com.invicta.lms.repository.LeaveRequestProcessRepository;
import com.invicta.lms.repository.LeaveRequestRepository;
import com.invicta.lms.repository.UserRepository;
import com.invicta.lms.service.LeaveRequestProcessService;

@Service
public class LeaveRequestProcessServiceImpl implements LeaveRequestProcessService{
	@Autowired
	private LeaveRequestProcessRepository leaveRequestProcessRepository;
	@Autowired 
	private LeaveRequestRepository leaveRequestRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LeaveRequestProcessMapper leaveRequestProcessMapper;
	
	@Override
	public LeaveProcessDtoResponse processLeaveRequest(Long leaveRequestId,Long processUserId,LeaveProcessDtoRequest leaveProcessDtoRequest) {
		LeaveRequestProcess leaveRequestProcess=new LeaveRequestProcess();
		leaveRequestProcess=leaveRequestProcessMapper.mapDtoToEntity(leaveProcessDtoRequest, leaveRequestProcess);
		leaveRequestProcess.setLeaveRequest(leaveRequestRepository.findLeaveRequestById(leaveRequestId));
		leaveRequestProcess.setProcessUser(userRepository.findUserById(processUserId));
		leaveRequestProcess=leaveRequestProcessRepository.save(leaveRequestProcess);
		
		return leaveRequestProcessMapper.mapEntityToDto(leaveRequestProcess);
	}

	
}
