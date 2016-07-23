package com.pojo;

import java.util.Date;
import java.util.Set;

public class EventDetailsDto {
	private int eventId;
	private TypeDetailsDto eventTypeDetails;
	private String eventName;
	private String eventDescription; 
	private Date startDate;
	private Date endDate;
	private String venue;
	private ScopeDetailsDto scopeDto;
	private Set<UserDetailsDto> eventUsers;
	private String firstPrize;
	private String secondPrize;
	private String thirdPrize;
	private FestDetailsDto fest;
	private Set<UserDetailsDto> eventVolunteers;
	private Set<UserDetailsDto> eventParticipants;
	
	public Set<UserDetailsDto> getEventUsers() {
		return eventUsers;
	}
	public void setEventUsers(Set<UserDetailsDto> eventUsers) {
		this.eventUsers = eventUsers;
	}
	public ScopeDetailsDto getScopeDto() {
		return scopeDto;
	}
	public void setScopeDto(ScopeDetailsDto scopeDto) {
		this.scopeDto = scopeDto;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public TypeDetailsDto getEventTypeDetails() {
		return eventTypeDetails;
	}
	public void setEventTypeDetails(TypeDetailsDto eventTypeDetails) {
		this.eventTypeDetails = eventTypeDetails;
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
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getFirstPrize() {
		return firstPrize;
	}
	public void setFirstPrize(String firstPrize) {
		this.firstPrize = firstPrize;
	}
	public String getSecondPrize() {
		return secondPrize;
	}
	public void setSecondPrize(String secondPrize) {
		this.secondPrize = secondPrize;
	}
	public String getThirdPrize() {
		return thirdPrize;
	}
	public void setThirdPrize(String thirdPrize) {
		this.thirdPrize = thirdPrize;
	}
	public FestDetailsDto getFest() {
		return fest;
	}
	public void setFest(FestDetailsDto fest) {
		this.fest = fest;
	}
	public Set<UserDetailsDto> getEventVolunteers() {
		return eventVolunteers;
	}
	public void setEventVolunteers(Set<UserDetailsDto> eventVolunteers) {
		this.eventVolunteers = eventVolunteers;
	}
	public Set<UserDetailsDto> getEventParticipants() {
		return eventParticipants;
	}
	public void setEventParticipants(Set<UserDetailsDto> eventParticipants) {
		this.eventParticipants = eventParticipants;
	}
	
}
