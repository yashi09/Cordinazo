package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.EventManager;
import com.manager.FestManager;
import com.pojo.EventDetailsDto;
import com.pojo.FestDetailsDto;
import com.pojo.FestEventMappingClass;

public class AdminEventsOfFestPage extends BasePage{
	private int festId;
	private int fstId;
	private List<EventDetailsDto> festEvents;
	private FestDetailsDto festDto;
	private FestManager manager; 
	private String festName;
	private String work;
	private int eventId;
	private EventManager eventManager;
	@Override
	public void preProcess(Map<String,Object> map) {
		System.out.println("inside preProcess in AdminEventsOfFestPage");
		if(map!=null){
			festId = (int)map.get("festId");
			festDto = manager.getFest(festId);
			festName = festDto.getFestName();
			festEvents = new ArrayList<EventDetailsDto>(festDto.getEvents());
		}
	}

	@Override
	public Map<String,Object> postProcess() {
		System.out.println("inside postProcess in AdminEventsOfFestPage");
		Map<String,Object> map = null;
		if(work!=null){
			if(work.equals("viewEventCoordinators")){
				map = new HashMap<String,Object>();
				System.out.println("inside postProcess in AdminEventsOf FestPage. work = "+work+ " eventId = "+eventId);
				map.put("eventId", eventId);
			} else if(work.equals("editEvent")){
				map = new HashMap<String,Object>();
				map.put("eventId", eventId);
			} else if(work.equals("deleteEvent")){
				FestEventMappingClass festEvent = new FestEventMappingClass();
				festEvent.setEventId(eventId);
				festEvent.setFestId(festId);
				manager.deleteEventOfFest(festEvent);
				eventManager.deleteAllUsersOfEvent(eventId);
				eventManager.deleteEvent(eventId);
				map = new HashMap<String,Object>();
				map.put("festId", festId);
			} else if(work.equals("addEventToFest")){
				map = new HashMap<String,Object>();
				map.put("festId", festId);
			}
		}
		return map;
	}

	public int getFestId() {
		System.out.println("inside getFestId in AdminEventsOfFestPage . festId = "+festId);
		return festId;
	}

	public void setFestId(int festId) {
		System.out.println("inside setFestId in AdminEventsOfFestPage . festId = "+festId);
		this.festId = festId;
	}

	public List<EventDetailsDto> getFestEvents() {
		return festEvents;
	}

	public void setFestEvents(List<EventDetailsDto> festEvents) {
		this.festEvents = festEvents;
	}

	public FestDetailsDto getFestDto() {
		return festDto;
	}

	public void setFestDto(FestDetailsDto festDto) {
		this.festDto = festDto;
	}

	public FestManager getManager() {
		return manager;
	}

	public void setManager(FestManager manager) {
		this.manager = manager;
	}

	public String getFestName() {
		return festName;
	}

	public void setFestName(String festName) {
		this.festName = festName;
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

	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	public int getFstId() {
		return fstId;
	}

	public void setFstId(int fstId) {
		System.out.println("inside setFstId in AdminEventsOfFestPage . fstId = "+fstId);
		this.fstId = fstId;
	}
	
}
