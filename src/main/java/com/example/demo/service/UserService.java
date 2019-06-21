package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
	User addUser(User user);
	List<User> viewAllUser();
	User deleteUser(Integer id);
	User updateUser(Integer id,User user);
	User findUserById(Integer id);
}


