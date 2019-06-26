package com.invicta.lms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.entity.Role;
import com.invicta.lms.repository.RoleRepository;
import com.invicta.lms.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role addRole(Role role) {
		if (role != null) {
			return roleRepository.save(role);	
		}
		return null;
	}

	@Override
	public List<Role> viewAllRole() {
		return roleRepository.findAll();
	}

	@Override
	public Long deleteRole(Long id) {
		if (roleRepository.getOne(id) != null) {
			roleRepository.deleteById(id);
			return id;
		}
		return null;
	}
	
	@Override
	public Role updateRole(Long id, Role role) {
		if (roleRepository.getOne(id) != null) {
			role.setId(id);
			return	roleRepository.save(role);	
		}
		return null;
	}

	@Override
	public Role findRoleById(Long id) {
		if(roleRepository.getOne(id)!= null) {
			return roleRepository.findRoleById(id);
		}
		return null;
	}

}
