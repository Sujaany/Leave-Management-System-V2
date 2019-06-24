package com.invicta.lms.service;

import java.util.List;

import com.invicta.lms.entity.Profile;

public interface ProfileService {
	Profile addProfile(Profile profile);
	List<Profile> viewAllProfile();
	Integer deleteProfile(Integer id);
	Profile updateProfile(Integer id,Profile profile);
	Profile findProfileById(Integer id);
}
