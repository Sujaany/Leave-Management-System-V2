package com.invicta.lms.validation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.dto.UserDtoRequest;
import com.invicta.lms.service.UserService;

@Service
public class UserValidation {

	@Autowired

	UserService userService;
	Map<String, String> errors = new HashMap<>();

	public void validationUser(UserDtoRequest userDtoRequest) {
		errors.clear();
		if (userDtoRequest.getUserName() == null) {
			errors.put("user", "User name cannot be null");
		}
		if (userDtoRequest.getUserName() == "") {
			errors.put("User", "User name cannot be Empty");
		}
		if (userService.existsByUsername(userDtoRequest.getUserName())) {
			errors.put("User", "User name Alreay exist!");
		}
		if (userDtoRequest.getEmail() == null) {
			errors.put("user", "Email cannot be null");
		}
		if (userDtoRequest.getEmail() == "") {
			errors.put("User", "Email cannot be Empty");
		}
		if (userService.existsByEmail(userDtoRequest.getEmail())) {
			errors.put("User", "Email Alreay exist!");
		}

		if (userDtoRequest.getPassword() == null) {
			errors.put("user", "Password cannot be null");
		}
		if (userDtoRequest.getPassword() == "") {
			errors.put("user", "Password  cannot be Empty");
		}

	}

	public Map<String, String> getErrors() {
		return errors;
	}
}
