package com.pojo;

import java.io.Serializable;

public class EventUserMappingClass implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private int eventId;
	private int userRole;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	
}
