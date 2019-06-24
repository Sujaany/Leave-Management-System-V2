package com.invicta.lms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.entity.LeaveType;
import com.invicta.lms.repository.LeaveTypeRepository;
import com.invicta.lms.service.LeaveTypeService;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {
	@Autowired
	LeaveTypeRepository leaveTypeRepository;

	@Override
	public LeaveType addLeaveType(LeaveType leaveType) {
		if (leaveType != null) {
			return leaveTypeRepository.save(leaveType);
		}
		return null;
	}

	@Override
	public List<LeaveType> viewAllLeaveType() {
		return leaveTypeRepository.findAll();
	}

	@Override
	public Integer deleteLeaveType(Integer id) {
		if (leaveTypeRepository.getOne(id) != null) {
			leaveTypeRepository.deleteById(id);
			return id;
		}
		return null;
	}

	@Override
	public LeaveType updateLeaveType(Integer id, LeaveType leaveType) {
		if (leaveTypeRepository.getOne(id) != null) {
			leaveType.setId(id);
			return leaveTypeRepository.save(leaveType);
		}
		return null;
	}

	@Override
	public LeaveType findLeaveTypeById(Integer id) {
		if (leaveTypeRepository.getOne(id) != null) {
			return leaveTypeRepository.findLeaveTypeById(id);
		}
		return null;
	}
}
