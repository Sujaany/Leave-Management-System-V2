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

import com.invicta.lms.dto.UserDto;
import com.invicta.lms.dto.UserSaveDto;
import com.invicta.lms.dto.mapper.UserSaveDtoMapper;
import com.invicta.lms.entity.mapper.UserMapper;
import com.invicta.lms.service.RoleService;
import com.invicta.lms.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@PostMapping
	public ResponseEntity<?> craeteUser(@RequestBody UserSaveDto userSaveDto) {

		return new ResponseEntity<>(userService.addUser(UserSaveDtoMapper.mapUserSaveDtoToUser(userSaveDto),
				roleService.findRoleById(userSaveDto.getRole())), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<UserDto>> getUsers() {
		return new ResponseEntity<>(UserMapper.mapUserListToUserDtoList(userService.viewAllUser()), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
		if (userService.findUserById(id) != null) {

			return new ResponseEntity<>(UserMapper.mapUserToUserDto(userService.findUserById(id)), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@RequestBody UserSaveDto userSaveDto, @PathVariable("id") Long id) {

		return new ResponseEntity<>(userService.updateUser(id, UserSaveDtoMapper.mapUserSaveDtoToUser(userSaveDto),
				roleService.findRoleById(userSaveDto.getRole())), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
	}
}
