package com.invicta.lms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.dto.LeaveSummary;
import com.invicta.lms.entity.LeaveDaysProcessor;
import com.invicta.lms.entity.LeaveType;
import com.invicta.lms.entity.User;
import com.invicta.lms.enums.LeaveProcessType;
import com.invicta.lms.repository.LeaveDaysProcessorRepository;
import com.invicta.lms.service.LeaveDaysProcessorService;
import com.invicta.lms.service.LeaveTypeService;

@Service
public class LeaveDaysProcessorServiceImpl implements LeaveDaysProcessorService{
	
	@Autowired
	LeaveDaysProcessorRepository leaveDaysProcessorRepository;
	
	@Autowired
	LeaveTypeService leaveTypeService;

	@Override
	public LeaveDaysProcessor addLeaveDaysProcessor(LeaveDaysProcessor leaveDaysProcessor, User user,
			LeaveType leaveType) {
		
		if(leaveDaysProcessor != null) {
			leaveDaysProcessor.setUser(user);
			leaveDaysProcessor.setLeaveType(leaveType);
			return leaveDaysProcessorRepository.save(leaveDaysProcessor);
		}
		return null;
	}

	@Override
	public LeaveDaysProcessor updateLeaveDaysProcessor(Long id, LeaveDaysProcessor leaveDaysProcessor, User user,
			LeaveType leaveType) {
		if(leaveDaysProcessorRepository.getOne(id)!= null) {
			leaveDaysProcessor.setId(id);
			leaveDaysProcessor.setUser(user);
			leaveDaysProcessor.setLeaveType(leaveType);
			return leaveDaysProcessorRepository.save(leaveDaysProcessor);
		}
		return null;
	}
	@Override
	public LeaveDaysProcessor findLeaveDaysProcessorById(Long id) {
		if (leaveDaysProcessorRepository.getOne(id) != null) {
			return leaveDaysProcessorRepository.findLeaveDaysProcessorById(id);
		}
		return null;
	}

	@Override
	public Long deleteLeaveDaysProcessor(Long id) {
		if (leaveDaysProcessorRepository.getOne(id) != null) {
			leaveDaysProcessorRepository.deleteById(id);
			return id;
		}
		return null;
	}

	@Override
	public List<LeaveDaysProcessor> viewAllLeaveDaysProcessor() {
		return leaveDaysProcessorRepository.findAll();
		}

	@Override
	public List<LeaveDaysProcessor> findLeaveDaysByUserId(Long userId) {
		return leaveDaysProcessorRepository.findLeaveDaysByUserId(userId);
	}

	@Override
	public List<LeaveDaysProcessor> findLeaveDaysByUserAndLeaveType(Long userId, Long leaveTypeId) {
		return leaveDaysProcessorRepository.findLeaveDaysByUserAndLeaveType(userId, leaveTypeId);
	}

	@Override
	public LeaveSummary leaveSummary(Long userId, Long leaveTypeId) {
		LeaveSummary leaveSummary=new LeaveSummary();
		leaveSummary.setLeaveType(leaveTypeService.findLeaveTypeById(leaveTypeId).getLeaveTypeName());
		
		leaveSummary.setAllocation(leaveDaysProcessorRepository.sumLeaveProcessTypesByUserandLeaveType(userId, leaveTypeId, LeaveProcessType.ALLOCATION));
		leaveSummary.setUtilized(leaveDaysProcessorRepository.sumLeaveProcessTypesByUserandLeaveType(userId, leaveTypeId, LeaveProcessType.UTILIZED));
		leaveSummary.setRemaining(leaveDaysProcessorRepository.sumLeaveDaysByUserAndLeaveType(userId, leaveTypeId));
		return leaveSummary;
	}

}

