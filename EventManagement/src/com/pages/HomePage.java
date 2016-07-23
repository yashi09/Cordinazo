package com.pages;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.manager.UserManager;
import com.pojo.LoginDetailsDto;
import com.pojo.UserDetailsDto;

public class HomePage extends BasePage{
	private UserManager userManager;
	private int eventTypeId;
	
	@Override
	public void preProcess(Map map) {
		System.out.println("inside preProcess in homePage.");
	}
	
	@Override
	public Map postProcess() {
		System.out.println("inside postProcess in homePage. eventTypeId = "+eventTypeId);
		Map map = new HashMap();
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
