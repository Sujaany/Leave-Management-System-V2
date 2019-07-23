package com.invicta.lms.validation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.invicta.lms.dto.LoginDtoRequest;

@Service
public class LoginValidation {
	
	Map<String,String> errors = new HashMap<>();
	
	public void validationLogin(LoginDtoRequest loginDtoRequest) {
		errors.clear();
		if(loginDtoRequest.getUsernameOrEmail() ==null) {
			errors.put("Login", "UsernameOrEmail cannot be null");
		}
		if(loginDtoRequest.getPassword() ==null) {
			errors.put("Login", "Password cannot be null");
		}
		
	}
	
	public Map<String,String> getErrors(){
		return errors;
	}

}
