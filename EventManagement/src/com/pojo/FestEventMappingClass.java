package com.pojo;

import java.io.Serializable;

public class FestEventMappingClass implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int festId;
	private int eventId;
	public int getFestId() {
		return festId;
	}
	public void setFestId(int festId) {
		this.festId = festId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
}
