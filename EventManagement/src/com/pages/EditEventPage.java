package com.pages;

import java.util.HashMap;
import java.util.Map;

import com.manager.EventManager;
import com.pojo.EventDetailsDto;

public class EditEventPage extends BasePage{
	private EventManager manager;
	private int eventId;
	private EventDetailsDto event;
	private String work;
	@Override
	public void preProcess(Map<String, Object> map) {
		if(map!=null && !map.isEmpty()){
			eventId = (int)map.get("eventId");
		}
		event = manager.getEvent(eventId); 
	}

	@Override
	public Map<String, Object> postProcess() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("festId", event.getFest().getFestId());
		if(work!=null && !work.isEmpty()){
			manager.updateEvent(event);
		}
		return map;
	}

	public EventManager getManager() {
		return manager;
	}

	public void setManager(EventManager manager) {
		this.manager = manager;
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

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
	
}
