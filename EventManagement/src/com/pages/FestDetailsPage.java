package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.EventManager;
import com.manager.FestManager;
import com.pojo.EventDetailsDto;
import com.pojo.FestDetailsDto;

public class FestDetailsPage extends BasePage{
	private int festId;
	private EventManager eventManager;
	private FestDetailsDto fest;
	private String festName;
	private FestManager festManager;
	private FestDetailsDto festDto;
	private List<EventDetailsDto> list;
	private int eventId;
	
	@Override
	public void preProcess(Map map) {
		festId = (int)map.get("festId");
		fest = festManager.getFest(festId);
		festName=fest.getFestName();
		list = new ArrayList<EventDetailsDto>(fest.getEvents());
		
	}

	@Override
	public Map postProcess() {
		System.out.println("inside postProcess in festDetailsPage");
		Map map = new HashMap();
		map.put("eventId", eventId);
		return map;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		System.out.println("inside seteventId in festDetailsDto eventId = "+eventId);
		this.eventId = eventId;
	}
	public List<EventDetailsDto> getList() {
		return list;
	}
	public void setList(List<EventDetailsDto> list) {
		this.list = list;
	}
	public FestDetailsDto getFestDto() {
		return festDto;
	}
	public void setFestDto(FestDetailsDto festDto) {
		this.festDto = festDto;
	}
	public FestManager getFestManager() {
		return festManager;
	}
	public void setFestManager(FestManager festManager) {
		this.festManager = festManager;
	}
	public String getFestName() {
		return festName;
	}
	public void setFestName(String festName) {
		this.festName = festName;
	}
	public int getFestId() {
		return festId;
	}
	public void setFestId(int festId) {
		this.festId = festId;
	}
	public EventManager getEventManager() {
		return eventManager;
	}
	public void setEventManager(EventManager eventManager) {
		System.out.println("inside setEventManager in festDetailsPage");
		this.eventManager = eventManager;
	}
	public FestDetailsDto getFest() {
		return fest;
	}
	public void setFest(FestDetailsDto fest) {
		this.fest = fest;
	}
}
