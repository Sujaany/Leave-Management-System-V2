package com.invicta.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invicta.lms.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findRoleById(Long id);
	Optional<Role>findByRoleName(String roleName);
	Boolean existsByRoleName(String roleName);
	
		
}
