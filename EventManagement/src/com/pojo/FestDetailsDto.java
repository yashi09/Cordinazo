package com.pojo;

import java.util.Date;
import java.util.Set;

public class FestDetailsDto {

	private Set<EventDetailsDto> events;
	private int festId;
	private  TypeDetailsDto typeDto;
	private String festName;
	private String festDescription;
	private Date startDate;
	private Date endDate;
	private ScopeDetailsDto scopeDto;
	private String venue;
	
	public Set<EventDetailsDto> getEvents() {
		return events;
	}
	public void setEvents(Set<EventDetailsDto> events) {
		this.events = events;
	}
	public int getFestId() {
		return festId;
	}
	public void setFestId(int festId) {
		this.festId = festId;
	}
	public String getFestName() {
		return festName;
	}
	public void setFestName(String festName) {
		this.festName = festName;
	}
	public String getFestDescription() {
		return festDescription;
	}
	public void setFestDescription(String festDescription) {
		this.festDescription = festDescription;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public TypeDetailsDto getTypeDto() {
		return typeDto;
	}
	public void setTypeDto(TypeDetailsDto typeDto) {
		this.typeDto = typeDto;
	}
	public ScopeDetailsDto getScopeDto() {
		return scopeDto;
	}
	public void setScopeDto(ScopeDetailsDto scopeDto) {
		this.scopeDto = scopeDto;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
}
