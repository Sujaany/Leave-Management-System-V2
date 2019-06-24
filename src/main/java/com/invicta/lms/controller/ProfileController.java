package com.invicta.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invicta.lms.entity.Profile;
import com.invicta.lms.service.ProfileService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProfileController {
	
	@Autowired
	ProfileService profileService;

	@GetMapping("/profile")
	public ResponseEntity<List<Profile>> getProfile() {
		return new ResponseEntity<>(profileService.viewAllProfile(), HttpStatus.OK);
	}
	
	@GetMapping("/profile/{id}")
	public ResponseEntity<?>getProfileById(@PathVariable("id") Integer id){
		return new ResponseEntity<Profile>(profileService.findProfileById(id), HttpStatus.OK);
	}
	
	@PostMapping("/profile")
	public ResponseEntity<?> addProfile(@RequestBody Profile profile) {
		return new ResponseEntity<>(profileService.addProfile(profile),HttpStatus.CREATED);
		}

	@PutMapping("/profile/{id}")
	public ResponseEntity<?> updateProfile(@RequestBody Profile profile, @PathVariable Integer id) {
		return new ResponseEntity<Profile>(profileService.updateProfile(id, profile), HttpStatus.OK);
		}

	@DeleteMapping("/profile/{id}")
	public ResponseEntity<?> deleteProfile(@PathVariable Integer id) {
		return new ResponseEntity<>(profileService.deleteProfile(id), HttpStatus.OK);
	}
}

