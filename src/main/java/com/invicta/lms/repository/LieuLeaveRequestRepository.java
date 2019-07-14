package com.invicta.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.invicta.lms.entity.LieuLeaveRequest;

public interface LieuLeaveRequestRepository extends JpaRepository<LieuLeaveRequest, Long> {
	LieuLeaveRequest findLieuLeaveRequestById(Long id);
	@Query("select lr from LieuLeaveRequest as lr where lr.userId.id = ?1 order by lr.updatedAt desc")
	List<LieuLeaveRequest> findByUser(Long id);
}
