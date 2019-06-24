package com.invicta.lms.service;

import java.util.List;

import com.invicta.lms.entity.Role;

public interface RoleService {
	Role addRole(Role role);
	List<Role> viewAllRole();
	Integer deleteRole(Integer id);
	Role updateRole(Integer id,Role role);
	Role findRoleById(Integer id);
	
}
