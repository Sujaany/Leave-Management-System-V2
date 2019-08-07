package com.invicta.lms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invicta.lms.dto.PermissionRequestDto;
import com.invicta.lms.entity.Permission;
import com.invicta.lms.repository.PermissionRepository;

@RestController
@RequestMapping("/permission")
public class PermissionContoller {
	
	@Autowired
	PermissionRepository permissionRepository ;
	
	@GetMapping
	public List<Permission> getAllMenus() {
		return permissionRepository.findAll();
	}
	
	@PutMapping("permissionid/{permissionid}")
	public Permission editPermission(@RequestBody PermissionRequestDto permissionRequestDto,@PathVariable Long permissionid) {
		Permission permission=permissionRepository.findPermissionById(permissionid);
		List<String> permissionlist=permission.getPermission();
		if(permissionRequestDto.isCheckstatus()==true) {
			
			permissionlist.add(permissionRequestDto.getUserId());
			permission.setPermission(permissionlist);
			
		}if(permissionRequestDto.isCheckstatus()==false) {
			
			permissionlist.remove(permissionRequestDto.getUserId());
			permission.setPermission(permissionlist);
		}
		
		return permissionRepository.save(permission);
	}
	
}
