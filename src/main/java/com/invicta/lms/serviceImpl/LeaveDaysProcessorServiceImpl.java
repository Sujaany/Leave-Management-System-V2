package com.invicta.lms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.entity.LeaveDaysProcessor;
import com.invicta.lms.entity.LeaveType;
import com.invicta.lms.entity.User;
import com.invicta.lms.enums.LeaveProcessType;
import com.invicta.lms.repository.LeaveDaysProcessorRepository;
import com.invicta.lms.service.LeaveDaysProcessorService;

@Service
public class LeaveDaysProcessorServiceImpl implements LeaveDaysProcessorService{
	
	@Autowired
	LeaveDaysProcessorRepository leaveDaysProcessorRepository;

	@Override
	public LeaveDaysProcessor addLeaveDaysProcessor(LeaveDaysProcessor leaveDaysProcessor, User user,
			LeaveType leaveType) {
		
		if(leaveDaysProcessor != null) {
			leaveDaysProcessor.setUser(user);
			leaveDaysProcessor.setLeaveProcessType(LeaveProcessType.ALLOCATION);
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
	public List<LeaveDaysProcessor> findLeaveDaysByUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDaysProcessor> findLeaveDaysByUserAndLeaveType(Long userId, Long leaveId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long sumLeaveDaysByUserAndLeaveType(Long userId, Long leaveId) {
		// TODO Auto-generated method stub
		return null;
	}
}
