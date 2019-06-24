package com.invicta.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invicta.lms.entity.User;
import com.invicta.lms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<?> craeteUser(@RequestBody User user){
		return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<List<User>>(userService.viewAllUser(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?>getUserById(@PathVariable("id") Long id){
		return new ResponseEntity<User>(userService.findUserById(id), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User>updateUser(@RequestBody User user,@PathVariable("id") Long id){
		return new ResponseEntity<User>(userService.updateUser(id, user), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>deleteById(@PathVariable("id") Long id){
		return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
	}
}
