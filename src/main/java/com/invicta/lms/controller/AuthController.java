package com.invicta.lms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.payload.JwtAuthenticationResponse;
import com.invicta.lms.dto.LoginDtoRequest;
import com.invicta.lms.dto.UserDtoRequest;
import com.invicta.lms.dto.mapper.UserSaveDtoMapper;
import com.invicta.lms.entity.mapper.UserMapper;
import com.invicta.lms.security.JwtTokenProvider;
import com.invicta.lms.service.RoleService;
import com.invicta.lms.service.UserService;
import com.invicta.lms.validation.UserValidation;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserService userService;
	@Autowired
	private RoleService roleService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;

	@Autowired
	UserValidation userValidation;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDtoRequest loginDtoRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginDtoRequest.getUsernameOrEmail(), loginDtoRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserDtoRequest userDtoRequest) {
		userValidation.validationUser(userDtoRequest);
		if (!userValidation.getErrors().isEmpty()) {
			return new ResponseEntity<>(userValidation.getErrors(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(UserMapper.mapUserToUserDto( 
				userService.addUser(
				UserSaveDtoMapper.mapUserSaveDtoToUser(userDtoRequest),
				roleService.findRoleById(userDtoRequest.getRole())
				)), HttpStatus.CREATED);
  

	}

}
