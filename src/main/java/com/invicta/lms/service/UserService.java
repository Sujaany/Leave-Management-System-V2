package com.invicta.lms.service;

import java.util.List;

import com.invicta.lms.entity.User;

public interface UserService {
	User addUser(User user);
	List<User> viewAllUser();
	Long deleteUser(Long id);
	User updateUser(Long id,User user);
	User findUserById(Long id);
}


