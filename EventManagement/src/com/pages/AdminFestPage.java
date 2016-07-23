package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.manager.EventManager;
import com.manager.FestManager;
import com.manager.UserManager;
import com.pojo.EventDetailsDto;
import com.pojo.FestDetailsDto;

public class AdminFestPage extends BasePage{
	private FestManager manager;
	private EventManager eventManager;
	private UserManager userManager;
	private List<FestDetailsDto> fests = new ArrayList<FestDetailsDto>();
	private String work;
	private int festId;

	@Override
	public void preProcess(Map<String,Object> map) {
		System.out.println("inside preProcess in AdminFestPage");
		fests = manager.getAllFest();
		System.out.println();
	}

	@Override
	public Map<String,Object> postProcess() {
		System.out.println("inside postProcess in AdminFestPage");
		Map<String,Object> map = null;
		if(work!=null){
			if(work.equals("viewEventsOfFest")){
				map = new HashMap<String,Object>();
				map.put("festId", festId);
			} else{
				if(work.equals("editFest")){
					map = new HashMap<String,Object>();
					map.put("festId", festId);
				} else {
					if(work.equals("delFest")){
						FestDetailsDto fest = manager.getFest(festId);
						Set<EventDetailsDto> events = fest.getEvents();
						for(EventDetailsDto event : events){
							eventManager.deleteAllUsersOfEvent(event.getEventId());
							eventManager.deleteEvent(event.getEventId());
						}
						manager.deleteAllEventsOfFest(festId);
						manager.deleteFest(festId);
					}
				}
			}
		}
		return map;
	}

	public FestManager getManager() {
		return manager;
	}
	public void setManager(FestManager manager) {
		this.manager = manager;
	}

	public List<FestDetailsDto> getFests() {
		return fests;
	}

	public void setFests(List<FestDetailsDto> fests) {
		this.fests = fests;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
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
		this.eventManager = eventManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
}
