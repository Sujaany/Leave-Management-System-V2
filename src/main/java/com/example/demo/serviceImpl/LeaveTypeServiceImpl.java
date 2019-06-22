package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LeaveType;
import com.example.demo.repository.LeaveTypeRepository;
import com.example.demo.service.LeaveTypeService;

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
