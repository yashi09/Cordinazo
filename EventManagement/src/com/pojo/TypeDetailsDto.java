package com.pojo;

import java.util.Set;

public class TypeDetailsDto {
	private int eventTypeId;
	private String eventType;
	private Set<EventDetailsDto> eventDetailsDtos;

	public Set<EventDetailsDto> getEventDetailsDtos() {
		return eventDetailsDtos;
	}
	public void setEventDetailsDtos(Set<EventDetailsDto> eventDetailsDtos) {
		this.eventDetailsDtos = eventDetailsDtos;
	}
	public int getEventTypeId() {
		return eventTypeId;
	}
	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
}
