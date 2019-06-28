package com.invicta.lms.dto.mapper;

import com.invicta.lms.dto.UserDtoRequest;
import com.invicta.lms.entity.Role;
import com.invicta.lms.entity.User;

public class UserSaveDtoMapper {
	public static User mapUserSaveDtoToUser(UserDtoRequest userDtoRequest)
	{
		User user =new User();
		user.setId(userDtoRequest.getId());
		user.setUserName(userDtoRequest.getUserName());
		user.setEmail(userDtoRequest.getEmail());
		Role role = new Role();
		role.setId(userDtoRequest.getRole());
		return user;
	}
}
