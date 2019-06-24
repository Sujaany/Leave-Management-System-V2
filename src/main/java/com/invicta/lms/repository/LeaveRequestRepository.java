package com.invicta.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invicta.lms.entity.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
	LeaveRequest findLeaveRequestById(Long id);
}
