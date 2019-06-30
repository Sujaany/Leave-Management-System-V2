package com.invicta.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invicta.lms.dto.ProfileDto;
import com.invicta.lms.entity.mapper.ProfileMapper;
import com.invicta.lms.service.ProfileService;
import com.invicta.lms.service.UserService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	ProfileService profileService;

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<ProfileDto>> getProfile() {
		return new ResponseEntity<>(ProfileMapper.mapProfileListToProfileDtoList((profileService.viewAllProfile())),
				HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProfileById(@PathVariable("id") Long id) {
		if (profileService.findProfileById(id) != null) {
			return new ResponseEntity<>(ProfileMapper.mapProfileToProfileDto(profileService.findProfileById(id)),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

//	@PostMapping
//	public ResponseEntity<?> addProfile(@RequestBody ProfileSaveDto profileSaveDto) {
//		return new ResponseEntity<>(ProfileMapper.mapProfileToProfileDto(profileService.addProfile(ProfileSaveDtoMapper
//				.mapProfileSaveDtoToProfile(profileSaveDto),userService.findUserById(profileSaveDto.getUser())),HttpStatus.CREATED);
//	}
//				
//				
//	@PutMapping("/{id}")
//	public ResponseEntity<?> updateProfile(@RequestBody ProfileSaveDto profileSaveDto, @PathVariable("id") Long id) {
//		return new ResponseEntity<>(
//				profileService.updateProfile(id, ProfileSaveDtoMapper.mapProfileSaveDtoToProfile(profileSaveDto),
//						userService.findUserById(profileSaveDto.getUser())),
//				HttpStatus.OK);
//	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProfile(@PathVariable Long id) {
		return new ResponseEntity<>(profileService.deleteProfile(id), HttpStatus.OK);
	}
}
