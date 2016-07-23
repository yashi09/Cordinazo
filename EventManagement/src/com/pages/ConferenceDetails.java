package com.pages;

import java.util.HashMap;
import java.util.Map;

import com.manager.EventManager;
import com.pojo.ConferenceDetailsDto;

public class ConferenceDetails extends BasePage{
	private EventManager manager;
	private ConferenceDetailsDto conference;
	private int conferenceId;
	private String work;
	@Override
	public void preProcess(Map<String, Object> map) {
		if(map!=null && !map.isEmpty()){
			conferenceId = (int)map.get("conferenceId");
			conference = manager.getConference(conferenceId);
			getContext().put("conferenceDto", conference);
		}
	}

	@Override
	public Map<String, Object> postProcess() {
		conference = (ConferenceDetailsDto)getContext().get("conferenceDto");
		getContext().remove("conferenceDto");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("conferenceId", conference.getEventId());
		return map;
	}

	public EventManager getManager() {
		return manager;
	}

	public void setManager(EventManager manager) {
		this.manager = manager;
	}

	public ConferenceDetailsDto getConference() {
		return conference;
	}

	public void setConference(ConferenceDetailsDto conference) {
		this.conference = conference;
	}

	public int getConferenceId() {
		return conferenceId;
	}

	public void setConferenceId(int conferenceId) {
		this.conferenceId = conferenceId;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
	
}
