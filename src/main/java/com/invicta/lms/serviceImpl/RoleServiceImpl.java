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
	public Boolean addRole(Role role) {
		if (role != null) {
			roleRepository.save(role);
			return true;
		}
		return false;
	}

	@Override
	public List<Role> viewAllRole() {
		return roleRepository.findAll();
	}

	@Override
	public Boolean deleteRole(Integer id) {
		if (roleRepository.getOne(id) != null) {
			roleRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Boolean updateRole(Integer id, Role role) {
		if (roleRepository.getOne(id) != null) {
			role.setId(id);
			roleRepository.save(role);
			return true;
		}
		return false;
	}

	@Override
	public Boolean findRoleById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
