package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> viewAllRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role deleteRole(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role updateRole(Integer id, Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findRoleById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	}
