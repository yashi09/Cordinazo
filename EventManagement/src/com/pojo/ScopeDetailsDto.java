package com.pojo;

import java.util.Set;

public class ScopeDetailsDto {
	private Set<EventDetailsDto> eventDetailsDtos;
	private int scopeId;
	private String scope;
	
	public Set<EventDetailsDto> getEventDetailsDtos() {
		return eventDetailsDtos;
	}
	public void setEventDetailsDtos(Set<EventDetailsDto> eventDetailsDtos) {
		this.eventDetailsDtos = eventDetailsDtos;
	}
	public int getScopeId() {
		return scopeId;
	}
	public void setScopeId(int scopeId) {
		this.scopeId = scopeId;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
}
