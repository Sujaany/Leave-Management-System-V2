package com.invicta.lms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.entity.Role;
import com.invicta.lms.entity.User;
import com.invicta.lms.repository.UserRepository;
import com.invicta.lms.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user,Role role) {
		if(user != null) {
			user.setRole(role);
			return userRepository.save(user);
		}
		return null;
	}

	@Override
	public List<User> viewAllUser() {
		return userRepository.findAll();
	}

	@Override
	public Long deleteUser(Long id) {
		if(userRepository.getOne(id)!=null) {
		 userRepository.deleteById(id);
		 return id;
		}
		return null;
	}

	@Override
	public User updateUser(Long id, User user,Role role) {
		if(userRepository.getOne(id)!= null) {
			user.setId(id);
			user.setRole(role);
			return userRepository.save(user);
		}
		return null;
	}

	@Override
	public User findUserById(Long id) {
		if(userRepository.getOne(id)!= null) {
			return userRepository.findUserById(id);
		}
		return null;
	}

}
