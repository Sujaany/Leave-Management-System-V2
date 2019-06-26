package com.invicta.lms.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import com.invicta.lms.dto.UserDto;
import com.invicta.lms.entity.User;

public class UserMapper {
	public static UserDto mapUserToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUserName(user.getUserName());
		userDto.setEmail(user.getEmail());
		userDto.setRoleName(user.getRole().getRoleName());
		return userDto;
	}
	public static List<UserDto> mapUserListToUserDtoList(List<User> userList){
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		if(userList != null) {
			for(User user:userList) {
				userDtoList.add(mapUserToUserDto(user));	
			}
		}
		return userDtoList;
		
	}
}
