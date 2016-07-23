package com.manager;

import java.util.List;

import com.pojo.EventUserMappingClass;
import com.pojo.LoginDetailsDto;
import com.pojo.UserDetailsDto;

public interface UserManager {
	public void addUserDetails(UserDetailsDto detailsDto);
	public LoginDetailsDto getLoginDetails(String email);
	public UserDetailsDto getUserDetails(int userId);
	public List<UserDetailsDto> getAllOrganizers();
	public void updateUserDetails(UserDetailsDto detailsDto);
	public void deleteUserDetails(int userId);
}
