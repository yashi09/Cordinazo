package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.manager.EventManager;
import com.pojo.EventDetailsDto;
import com.pojo.UserDetailsDto;

public class ParticipantsOfEvent extends BasePage{
	private EventManager em;
	private int eventId;
	private EventDetailsDto event;
	private List<UserDetailsDto> participants;

	@Override
	public void preProcess(Map<String, Object> map) {
		if(map!=null && !map.isEmpty()){
			eventId = (int)map.get("eventId");
			event = em.getEvent(eventId);
			participants = new ArrayList<UserDetailsDto>(event.getEventParticipants());
		}
	}

	@Override
	public Map<String, Object> postProcess() {
		// TODO Auto-generated method stub
		return null;
	}

	public EventManager getEm() {
		return em;
	}

	public void setEm(EventManager em) {
		this.em = em;
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

	public List<UserDetailsDto> getParticipants() {
		return participants;
	}

	public void setParticipants(List<UserDetailsDto> participants) {
		this.participants = participants;
	}
	
}
