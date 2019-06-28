package com.invicta.lms.dto.mapper;

import com.invicta.lms.dto.ProfileSaveDto;
import com.invicta.lms.entity.Profile;
import com.invicta.lms.entity.User;

public class ProfileSaveDtoMapper {
	public static Profile mapProfileSaveDtoToProfile(ProfileSaveDto profileSaveDto)
	{
		Profile profile =new Profile();
		profile.setId(profileSaveDto.getId());
		User user = new User();
		user.setId(profileSaveDto.getUser());
		profile.setFirstName(profileSaveDto.getFirstName());
		profile.setLastName(profileSaveDto.getLastName());
		profile.setAddress(profileSaveDto.getAddress());
		profile.setTelephoneNo(profileSaveDto.getTelephoneNo());
		return profile;
	}
}
