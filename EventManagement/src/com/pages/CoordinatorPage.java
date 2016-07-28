package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.manager.EventManager;
import com.pojo.EventDetailsDto;
import com.pojo.EventUserMappingClass;
import com.pojo.UserDetailsDto;

public class CoordinatorPage extends BasePage{
	private EventManager manager;
	private UserDetailsDto user;
	private int userId;
	private List<EventDetailsDto> events;
	private String work;
	private int eventId;
	
	@Override
	public void preProcess(Map<String, Object> map) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession)context.getExternalContext().getSession(false);
		user = (UserDetailsDto)session.getAttribute("loggedInDto");
		userId = user.getUserId();
		List<EventUserMappingClass> mappingList = manager.getEventsOfCoordinator(userId);
		if(!mappingList.isEmpty()){
			events = new ArrayList<EventDetailsDto>();
			for(EventUserMappingClass eventUser : mappingList){
				events.add(manager.getEvent(eventUser.getEventId()));
			}
		}
	}

	@Override
	public Map<String, Object> postProcess() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("eventId", eventId);
		map.put("conferenceId", eventId);
		map.put("guestLectureId", eventId);
		map.put("workshopId", eventId);
		return map;
	}

	public EventManager getManager() {
		return manager;
	}

	public void setManager(EventManager manager) {
		this.manager = manager;
	}

	public UserDetailsDto getUser() {
		return user;
	}

	public void setUser(UserDetailsDto user) {
		this.user = user;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<EventDetailsDto> getEvents() {
		return events;
	}

	public void setEvents(List<EventDetailsDto> events) {
		this.events = events;
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
	
}
