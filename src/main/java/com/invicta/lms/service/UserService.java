package com.invicta.lms.service;

import java.util.List;

import com.invicta.lms.entity.User;

public interface UserService {
	User addUser(User user);
	List<User> viewAllUser();
	User deleteUser(Integer id);
	User updateUser(Integer id,User user);
	User findUserById(Integer id);
}


