package com.invicta.lms.service;

import java.util.List;

import com.invicta.lms.dto.MenuResponseDto;

public interface PermissionService {
	public List<MenuResponseDto> getMenuByRole(String roleName);

}
