package com.invicta.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invicta.lms.entity.LieuLeaveRequest;

public interface LieuLeaveRequestRepository extends JpaRepository<LieuLeaveRequest, Long> {
	LieuLeaveRequest findLieuLeaveRequestById(Long id);
}
