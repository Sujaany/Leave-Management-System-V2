package com.invicta.lms.dto.mapper;

import com.invicta.lms.dto.UserSaveDto;
import com.invicta.lms.entity.Role;
import com.invicta.lms.entity.User;

public class UserSaveDtoMapper {
	public static User mapUserSaveDtoToUser(UserSaveDto userSaveDto)
	{
		User user =new User();
		user.setId(userSaveDto.getId());
		user.setUserName(userSaveDto.getUserName());
		user.setEmail(userSaveDto.getEmail());
		Role role = new Role();
		role.setId(userSaveDto.getRole());
		return user;
	}
}
