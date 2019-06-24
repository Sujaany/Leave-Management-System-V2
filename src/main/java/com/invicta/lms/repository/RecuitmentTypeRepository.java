package com.invicta.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invicta.lms.entity.RecuitmentType;

public interface RecuitmentTypeRepository extends JpaRepository<RecuitmentType, Integer> {
	RecuitmentType findRecuitmentTypeById(Integer id);

}
