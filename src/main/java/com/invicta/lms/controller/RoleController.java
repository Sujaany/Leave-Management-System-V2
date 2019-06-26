package com.invicta.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invicta.lms.entity.Role;
import com.invicta.lms.service.RoleService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	@GetMapping("/get")
	public ResponseEntity<List<Role>> getRole() {
		return new ResponseEntity<>(roleService.viewAllRole(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?>getRoleById(@PathVariable("id") Long id){
		return new ResponseEntity<Role>(roleService.findRoleById(id), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addRole(@RequestBody Role role) {
		return new ResponseEntity<>(roleService.addRole(role),HttpStatus.CREATED);
		}

	@PutMapping("/edit/{id}")
	public ResponseEntity<Role> updateRole(@RequestBody Role role, @PathVariable Long id) {
		return new ResponseEntity<Role>(roleService.updateRole(id, role), HttpStatus.OK);
		}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable Long id) {
		return new ResponseEntity<>(roleService.deleteRole(id), HttpStatus.OK);
		}
}
