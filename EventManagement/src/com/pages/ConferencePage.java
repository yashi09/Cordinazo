package com.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.EventManager;
import com.pojo.ConferenceDetailsDto;

public class ConferencePage extends BasePage{
	private EventManager eventManager;
	private List<ConferenceDetailsDto> conferences;
	private int conferenceId;
	
	@Override
	public void preProcess(Map<String, Object> map) {
		conferences = eventManager.getAllConferences();
	}

	@Override
	public Map<String, Object> postProcess() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("conferenceId", conferenceId);
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

	public int getConferenceId() {
		return conferenceId;
	}

	public void setConferenceId(int conferenceId) {
		this.conferenceId = conferenceId;
	}
	
}
