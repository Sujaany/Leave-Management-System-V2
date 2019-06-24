package com.invicta.lms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.entity.LeaveType;
import com.invicta.lms.repository.LeaveTypeRepository;
import com.invicta.lms.service.LeaveTypeService;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService{
	@Autowired
	LeaveTypeRepository leaveTypeRepository;

	@Override
	public Boolean addLeaveType(LeaveType leaveType) {
		if (leaveType != null) {
			leaveTypeRepository.save(leaveType);
			return true;
		}
		return false;
	}

	@Override
	public List<LeaveType> viewAllLeaveType() {
		return leaveTypeRepository.findAll();
		}

	@Override
	public Boolean deleteLeaveType(Integer id) {
		if (leaveTypeRepository.getOne(id) != null) {
			leaveTypeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Boolean updateLeaveType(Integer id, LeaveType leaveType) {
		if (leaveTypeRepository.getOne(id) != null) {
			leaveType.setId(id);
			leaveTypeRepository.save(leaveType);
			return true;
		}
		return false;
	}

	@Override
	public Boolean findLeaveTypeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}	
}
