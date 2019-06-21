package com.example.demo.Service;

import java.util.List;
import com.example.demo.Entity.Role;

public interface RoleService {
	boolean addRole(Role role);
	List<Role> viewAllRole();
	boolean deleteRole(Integer id);
	boolean updateRole(Integer id,Role role);
	
}
