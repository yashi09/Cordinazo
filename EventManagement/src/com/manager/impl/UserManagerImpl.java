package com.manager.impl;

import java.util.List;

import com.dao.UserDao;
import com.manager.UserManager;
import com.pojo.LoginDetailsDto;
import com.pojo.UserDetailsDto;

public class UserManagerImpl implements UserManager{
	private UserDao userDao;

	@Override
	public void addUserDetails(UserDetailsDto detailsDto) {
		userDao.addUserDetails(detailsDto);
	}

	@Override
	public UserDetailsDto getUserDetails(int userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public List<UserDetailsDto> getAllOrganizers() {
		return userDao.getUsersByRole(3);
	}

	@Override
	public void updateUserDetails(UserDetailsDto detailsDto) {
		userDao.updateUserDetails(detailsDto);
	}

	@Override
	public void deleteUserDetails(int userId) {
		userDao.deleteUserDetails(userId);;
	}

	@Override
	public LoginDetailsDto getLoginDetails(String email) {
		return userDao.getLoginDetails(email);
	}

	public UserDao getUserDao() {
		System.out.println("inside getUserDao in UserManagerImpl");
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		System.out.println("inside setUserDao in UserManagerImpl");
		this.userDao = userDao;
	}

}
