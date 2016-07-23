package com.pojo;

import java.io.Serializable;
import java.util.Set;

public class UserDetailsDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String firstName;
	private String lastName;
	private int role;
	private String email;
	private long phoneNo;
	private LoginDetailsDto loginDetailsDto;
	private Set<EventDetailsDto> events;
	
	public Set<EventDetailsDto> getEvents() {
		return events;
	}
	public void setEvents(Set<EventDetailsDto> events) {
		this.events = events;
	}
	public LoginDetailsDto getLoginDetailsDto() {
		return loginDetailsDto;
	}
	public void setLoginDetailsDto(LoginDetailsDto loginDetailsDto) {
		this.loginDetailsDto = loginDetailsDto;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
