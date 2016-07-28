package com.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.EventManager;
import com.pojo.ConferenceDetailsDto;

public class AdminConferencePage extends BasePage{
	private EventManager eventManager;
	private List<ConferenceDetailsDto> conferences;
	private String work;
	private int conferenceId;
	
	@Override
	public void preProcess(Map<String, Object> map) {
		System.out.println("inside preProcess in AdminConferencePage");
		conferences = eventManager.getAllConferences();
		System.out.println("conferences = "+conferences);
	}

	@Override
	public Map<String, Object> postProcess() {
		Map<String,Object> map = new HashMap<String, Object>();
		if(work!=null & work.equals("delete")){
			eventManager.deleteAllUsersOfEvent(conferenceId);
			eventManager.deleteEvent(conferenceId);
		}
		else if(work!=null){
			map.put("conferenceId", conferenceId);
			map.put("eventId", conferenceId);
		}
		return map;
	}

	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	public List<ConferenceDetailsDto> getConferences() {
		return conferences;
	}

	public void setConferences(List<ConferenceDetailsDto> conferences) {
		this.conferences = conferences;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public int getConferenceId() {
		return conferenceId;
	}

	public void setConferenceId(int conferenceId) {
		this.conferenceId = conferenceId;
	}
	
}
