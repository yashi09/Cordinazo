package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import com.manager.EventManager;
import com.manager.UserManager;
import com.pojo.EventDetailsDto;
import com.pojo.EventUserMappingClass;
import com.pojo.UserDetailsDto;

public class AdminCoordsOfEventPage extends BasePage{
	private EventManager manager;
	private UserManager userManager;
	private int eventId;
	private EventDetailsDto eventDto; 
	private List<UserDetailsDto> eventCoords;
	private List<UserDetailsDto> eventUsers;
	private String eventName;
	private String work;
	private int coordId;
	private List<SelectItem> organizers;
	private SelectItem coord;
	
	@Override
	public void preProcess(Map<String,Object> map) {
		System.out.println("inside preProcess in AdminCoordsOfEventPage");
		if(map!=null){
			eventId = (int)map.get("eventId");
			eventDto = manager.getEvent(eventId);
			eventName = eventDto.getEventName();
			eventUsers = new ArrayList<UserDetailsDto>(eventDto.getEventUsers());
			eventCoords = new ArrayList<UserDetailsDto>();
			for(UserDetailsDto user : eventUsers){
				if(user.getRole()==3){
					eventCoords.add(user);
				}
			}
			List<UserDetailsDto> organizers = userManager.getAllOrganizers();
			organizers.removeAll(eventCoords);
			this.organizers=new ArrayList<SelectItem>();
			for(UserDetailsDto dto:organizers){
				System.out.println("organizer = "+dto);
				SelectItem itm=new SelectItem(dto.getUserId(), dto.getFirstName()+" "+dto.getLastName());
				this.organizers.add(itm);
			}
		}
	}

	@Override
	public Map<String,Object> postProcess() {
		System.out.println("inside postProcess in AdminCoordsOfEventPage");
		Map<String,Object> map = new HashMap<String,Object>();
		if(work!=null){
			if(work.equals("addCoordToEvent")){
				EventUserMappingClass eventUserMappingClass = new EventUserMappingClass();
				eventUserMappingClass.setEventId(eventId);
				eventUserMappingClass.setUserId(coordId);
				manager.addUserToEvent(eventUserMappingClass);
				map.put("eventId", eventId);
			} else if(work.equals("delCoord")){
				EventUserMappingClass eventUser = new EventUserMappingClass();
				eventUser.setEventId(eventId);
				eventUser.setUserId(coordId);
				manager.deleteUserOfEvent(eventUser);
				map.put("eventId", eventId);
			}
		}
		return map;
	}

	public EventManager getManager() {
		return manager;
	}

	public void setManager(EventManager manager) {
		this.manager = manager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public List<UserDetailsDto> getEventCoords() {
		return eventCoords;
	}

	public void setEventCoords(List<UserDetailsDto> eventCoords) {
		this.eventCoords = eventCoords;
	}

	public List<UserDetailsDto> getEventUsers() {
		return eventUsers;
	}

	public void setEventUsers(List<UserDetailsDto> eventUsers) {
		this.eventUsers = eventUsers;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public EventDetailsDto getEventDto() {
		return eventDto;
	}

	public void setEventDto(EventDetailsDto eventDto) {
		this.eventDto = eventDto;
	}

	public int getCoordId() {
		return coordId;
	}

	public void setCoordId(int coordId) {
		this.coordId = coordId;
	}

	public List<SelectItem> getOrganizers() {
		return organizers;
	}

	public void setOrganizers(List<SelectItem> organizers) {
		this.organizers = organizers;
	}
	
	public SelectItem getCoord() {
		return coord;
	}

	public void setCoord(SelectItem coord) {
		this.coord = coord;
	}
	
}
