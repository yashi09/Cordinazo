package com.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.manager.EventManager;
import com.manager.UserManager;
import com.pojo.EventDetailsDto;
import com.pojo.ScopeDetailsDto;
import com.pojo.TypeDetailsDto;

public class AdminPage extends BasePage{
	private String work;
	private String eventName;
	private String eventDescription;
	private String startDate;
	private String endDate;
	private int scope;
	private int eventType;
	private String venue;
	private EventManager eventManager;
	private List<EventDetailsDto> list;
	private int eventId;
	private UserManager userManager;

	@Override
	public void preProcess(Map map) {
		System.out.println("inside preProcess in adminPage.");
		if(map!=null){
			work = (String)map.get("work");
			System.out.println("work = "+work);
		}
		if(work==null){
			list = new ArrayList<EventDetailsDto>();
			System.out.println("work is null");
			list = eventManager.getAllEvents();
		} else {
			if(work.equals("organizers")){
				EventDetailsDto detailsDto = new EventDetailsDto();
				
			}
			
		}
	}

	@Override
	public Map postProcess() {
		System.out.println("inside postProcess in adminPage. work = "+work);
		Map map = new HashMap();
		if(work!=null){
			if(work.equals("addEvent")){
				map.put("work", work);
			} else if(work.equals("addEventToDb")){
				EventDetailsDto detailsDto = new EventDetailsDto();
				detailsDto.setEventName(getEventName());
				detailsDto.setVenue(getVenue());
				detailsDto.setEventDescription(getEventDescription());
				SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
				try {
					Date date = sdf.parse(startDate);
					detailsDto.setStartDate(date);
					date = sdf.parse(endDate);
					detailsDto.setEndDate(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				ScopeDetailsDto scopeDto = new ScopeDetailsDto();
				scopeDto.setScopeId(scope);
				if(getScope()==101){
					scopeDto.setScope("Intra-college");
				} else if(getScope()==102){
					scopeDto.setScope("Inter-state");
				} else if(getScope()==103){
					scopeDto.setScope("National");
				} else if(getScope()==104){
					scopeDto.setScope("International");
				}
				detailsDto.setScopeDto(scopeDto);
				TypeDetailsDto typeDetails = new TypeDetailsDto();
				typeDetails.setEventTypeId(eventType);
				if(getEventType()==201){
					typeDetails.setEventType("Conference");
				} else if(getEventType()==202){
					typeDetails.setEventType("Workshop");
				} else if(getEventType()==203){
					typeDetails.setEventType("Guest Lecture");
				} else if(getEventType()==204){
					typeDetails.setEventType("Campus Event");
				}
				detailsDto.setEventTypeDetails(typeDetails);
				detailsDto.setEventId(406);
				eventManager.addEvent(detailsDto);
			} else if(work.equals("delEvent")){
				int id = getEventId();
				eventManager.deleteEvent(id);
			} else if(work.equals("organizers")){
				map.put("work", work);
			}
		} else if(work==null){
			list = new ArrayList<EventDetailsDto>();
			list = eventManager.getAllEvents();
			setList(list);
		}
		return map;
	}
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public List<EventDetailsDto> getList() {
		return list;
	}
	public void setList(List<EventDetailsDto> list) {
		this.list = list;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public int getScope() {
		return scope;
	}
	public void setScope(int scope) {
		this.scope = scope;
	}
	public int getEventType() {
		return eventType;
	}
	public void setEventType(int eventType) {
		this.eventType = eventType;
	}
	public EventManager getEventManager() {
		return eventManager;
	}
	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
}
