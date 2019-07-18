package com.invicta.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invicta.lms.entity.LeaveDaysProcessor;

public interface LeaveDaysProcessorRepository extends JpaRepository<LeaveDaysProcessor, Long> {

	LeaveDaysProcessor findLeaveDaysProcessorById(Long id);
	
//	 Boolean existsByLeaveDaysProcessor(String leaveDaysProcessor);

}
