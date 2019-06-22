package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Role;

public interface RoleService {
	Boolean addRole(Role role);
	List<Role> viewAllRole();
	Boolean deleteRole(Integer id);
	Boolean updateRole(Integer id,Role role);
	Boolean findRoleById(Integer id);
	
}
