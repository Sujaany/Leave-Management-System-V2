package com.invicta.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invicta.lms.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
		
}
