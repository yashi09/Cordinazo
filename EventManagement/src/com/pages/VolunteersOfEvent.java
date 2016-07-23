package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.EventManager;
import com.pojo.EventDetailsDto;
import com.pojo.EventVolunteerMappingClass;
import com.pojo.UserDetailsDto;

public class VolunteersOfEvent extends BasePage{
	private EventManager manager;
	private List<UserDetailsDto> volunteers;
	private int volunteerId;
	private String work;
	private int eventId;
	EventDetailsDto event;
	
	@Override
	public void preProcess(Map<String, Object> map) {
		System.out.println("inside preProcess in volunteersOfEvent");
		if(map!=null && !map.isEmpty()){
			int eventId = (int)map.get("eventId");
			event = manager.getEvent(eventId);
			volunteers = new ArrayList<UserDetailsDto>(event.getEventVolunteers());
		}
	}

	@Override
	public Map<String, Object> postProcess() {
		System.out.println("inside postProcess in volunteersOfEvent");
		Map<String,Object> map = new HashMap<String, Object>();
		if(work!=null && work.equals("delVolunteer")){
			EventVolunteerMappingClass eventVolunteer = new EventVolunteerMappingClass();
			eventVolunteer.setEventId(eventId);
			eventVolunteer.setUserId(volunteerId);
			manager.deleteVolunteerOfEvent(eventVolunteer);
		}
		map.put("eventId", eventId);
		return map;
	}

	public EventManager getManager() {
		return manager;
	}

	public void setManager(EventManager manager) {
		this.manager = manager;
	}

	public List<UserDetailsDto> getVolunteers() {
		return volunteers;
	}

	public void setVolunteers(List<UserDetailsDto> volunteers) {
		this.volunteers = volunteers;
	}

	public int getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(int volunteerId) {
		this.volunteerId = volunteerId;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public EventDetailsDto getEvent() {
		return event;
	}

	public void setEvent(EventDetailsDto event) {
		this.event = event;
	}
	
}
