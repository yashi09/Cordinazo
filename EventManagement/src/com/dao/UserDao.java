package com.dao;

import java.util.List;

import com.pojo.EventUserMappingClass;
import com.pojo.LoginDetailsDto;
import com.pojo.UserDetailsDto;

public interface UserDao {
	public void addUserDetails(UserDetailsDto detailsDto);
	public LoginDetailsDto getLoginDetails(String email);
	public UserDetailsDto getUserById(int userId);
	public List<UserDetailsDto> getUsersByRole(int role);
	public void updateUserDetails(UserDetailsDto detailsDto);
	public void deleteUserDetails(int userId);
}
