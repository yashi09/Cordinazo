package com.pages;

import java.util.HashMap;
import java.util.Map;

import com.manager.UserManager;

public class HomePage extends BasePage{
	private UserManager userManager;
	private int eventTypeId;
	
	@Override
	public void preProcess(Map<String,Object> map) {
		System.out.println("inside preProcess in homePage.");
	}
	
	@Override
	public Map<String,Object> postProcess() {
		System.out.println("inside postProcess in homePage. eventTypeId = "+eventTypeId);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("eventTypeId", eventTypeId);
		return map;
	}
	
	public int getEventTypeId() {
		return eventTypeId;
	}
	public void setEventTypeId(int eventTypeId) {
		System.out.println("inside setEventTypeId = "+eventTypeId);
		this.eventTypeId = eventTypeId;
	}
	public UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
}
