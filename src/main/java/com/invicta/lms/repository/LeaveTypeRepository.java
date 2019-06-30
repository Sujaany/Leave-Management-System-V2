package com.invicta.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invicta.lms.entity.LeaveType;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
	LeaveType findLeaveTypeById(Long id);
	
	 Boolean existsByleaveType(String leaveType);
}
