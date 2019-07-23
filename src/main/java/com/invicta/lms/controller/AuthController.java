package com.invicta.lms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invicta.lms.dto.JwtAuthenticationDtoResponse;
import com.invicta.lms.dto.LoginDtoRequest;
import com.invicta.lms.dto.UserDtoRequest;
import com.invicta.lms.dto.mapper.UserSaveDtoMapper;
import com.invicta.lms.entity.mapper.UserMapper;
import com.invicta.lms.security.CustomUserDetailsService;
import com.invicta.lms.security.JwtTokenProvider;
import com.invicta.lms.service.RoleService;
import com.invicta.lms.service.UserService;
import com.invicta.lms.validation.LoginValidation;
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
	CustomUserDetailsService customUserDetailsService;

	@Autowired
	UserValidation userValidation;
	@Autowired
	LoginValidation loginValidation;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDtoRequest loginDtoRequest) {
		loginValidation.validationLogin(loginDtoRequest);
		if (!loginValidation.getErrors().isEmpty()) {
			return new ResponseEntity<>(loginValidation.getErrors(), HttpStatus.BAD_REQUEST);
		}

		Map<String, String> authErrors = new HashMap<>();
		try {
		UserDetails userDetails=customUserDetailsService.loadUserByUsername(loginDtoRequest.getUsernameOrEmail());
//		String str1=userDetails.getPassword();
//		String str2=passwordEncoder.encode(loginDtoRequest.getPassword());
//		System.out.println(str1.matches(str2));
//		//boolean i=str1.contentEquals(str2);
//		boolean ii=str1.matches(str2);
//		System.out.println(ii);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, loginDtoRequest.getPassword(),userDetails.getAuthorities());

		
		boolean result = authenticationManager.authenticate(usernamePasswordAuthenticationToken).isAuthenticated();
		if (result) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			String jwt = tokenProvider.generateToken(usernamePasswordAuthenticationToken);
			return ResponseEntity.ok(new JwtAuthenticationDtoResponse(jwt));
		}else {
			authErrors.put("Auth", "Invalid password");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(authErrors);
		}
		}catch(UsernameNotFoundException ex) {
			
			authErrors.put("Auth", "Invalid email or username");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(authErrors);
		}
		
		
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserDtoRequest userDtoRequest) {
		userValidation.validationUser(userDtoRequest);
		if (!userValidation.getErrors().isEmpty()) {
			return new ResponseEntity<>(userValidation.getErrors(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(
				UserMapper.mapUserToUserDto(userService.addUser(UserSaveDtoMapper.mapUserSaveDtoToUser(userDtoRequest),
						roleService.findRoleById(userDtoRequest.getRole()))),
				HttpStatus.CREATED);

	}

}
