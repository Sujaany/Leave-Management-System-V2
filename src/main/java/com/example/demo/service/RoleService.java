package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Role;

public interface RoleService {
	Role addRole(Role role);
	List<Role> viewAllRole();
	Role deleteRole(Integer id);
	Role updateRole(Integer id,Role role);
	Role findRoleById(Integer id);
	
}
