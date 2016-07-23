package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.dao.UserDao;
import com.pojo.EventUserMappingClass;
import com.pojo.LoginDetailsDto;
import com.pojo.UserDetailsDto;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public void addUserDetails(UserDetailsDto detailsDto) {
		try{
			getSession().save(detailsDto);
			commitTransaction();
			getSession().save(detailsDto.getLoginDetailsDto());
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public LoginDetailsDto getLoginDetails(String email) {
		System.out.println("inside getLoginDetailsDto in userDaoImpl. email = "+email);
		LoginDetailsDto dto = new LoginDetailsDto();
		try{
			Session session = getSession();
			dto = (LoginDetailsDto)session.get(LoginDetailsDto.class, email);
			System.out.println("inside getLoginDetailsDto in userDaoImpl. loginDto = "+dto);
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return dto;
	}

	@Override
	public UserDetailsDto getUserById(int userId) {
		UserDetailsDto dto = new UserDetailsDto();
		try{
			dto = (UserDetailsDto)getSession().get(UserDetailsDto.class, userId);
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return dto;
	}

	@Override
	public List<UserDetailsDto> getUsersByRole(int r) {
		List<UserDetailsDto> list = new ArrayList<UserDetailsDto>();
		try{
			getSession();
			commitTransaction();
			getSession().clear();
			getSession().flush();
			list = (ArrayList<UserDetailsDto>)getSession().createCriteria(UserDetailsDto.class).add(Restrictions.eq("role", r)).list();
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return list;
	}

	@Override
	public void updateUserDetails(UserDetailsDto detailsDto) {
		try{
			getSession().saveOrUpdate(detailsDto);
			commitTransaction();
			getSession().saveOrUpdate(detailsDto.getLoginDetailsDto());
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void deleteUserDetails(int userId) {
		try{
			UserDetailsDto userDetailsDto = (UserDetailsDto)getSession().get(UserDetailsDto.class, userId);
			getSession().delete(userDetailsDto);
			commitTransaction();
			getSession().delete(userDetailsDto.getLoginDetailsDto());
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}
}
