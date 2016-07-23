package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.manager.EventManager;
import com.manager.UserManager;
import com.pojo.EventDetailsDto;
import com.pojo.UserDetailsDto;

public class ViewCoordsOfEvent extends BasePage{
	private EventManager eventManager;
	private List<UserDetailsDto> coordinators;
	@Override
	public void preProcess(Map<String, Object> map) {
		if(map!=null && !map.isEmpty()){
			int eventId = (int)map.get("eventId");
			EventDetailsDto event = eventManager.getEvent(eventId);
			coordinators = new ArrayList<UserDetailsDto>(event.getEventUsers());
			
		}
	}

	@Override
	public Map<String, Object> postProcess() {
		// TODO Auto-generated method stub
		return null;
	}

	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	public List<UserDetailsDto> getCoordinators() {
		return coordinators;
	}

	public void setCoordinators(List<UserDetailsDto> coordinators) {
		this.coordinators = coordinators;
	}
	
}
