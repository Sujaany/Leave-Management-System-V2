package com.invicta.lms.dto.mapper;

import com.invicta.lms.dto.UserSaveDto;
import com.invicta.lms.entity.Role;
import com.invicta.lms.entity.User;

public class UserSaveDtoToUser {
	public static User map(UserSaveDto userSaveDto)
	{
		User user =new User();
		user.setId(userSaveDto.getId());
		user.setUserName(userSaveDto.getUserName());
		user.setEmail(userSaveDto.getEmail());
		Role role = new Role();
		role.setId(userSaveDto.getRole());
		user.setRole(role);
		return user;
	}
}
