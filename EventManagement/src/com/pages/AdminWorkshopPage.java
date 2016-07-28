package com.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.EventManager;
import com.manager.WorkshopManager;
import com.pojo.WorkshopDetailsDto;

public class AdminWorkshopPage extends BasePage{
	private WorkshopManager manager;
	private EventManager eventManager;
	private List<WorkshopDetailsDto> workshops; 
	private String work;
	private int workshopId;
	@Override
	public void preProcess(Map<String, Object> map) {
		workshops = manager.getAllWorkshops();
	}

	@Override
	public Map<String, Object> postProcess() {
		Map<String,Object> map = new HashMap<String, Object>();
		if(work!=null && work.equals("delWorkshop")){
			manager.deleteWorkshop(workshopId);
			eventManager.deleteAllUsersOfEvent(workshopId);
		} else {
			if(work!=null && !work.isEmpty()){
				map.put("workshopId", workshopId);
				map.put("eventId", workshopId);
			}
		}
		return map;
	}

	public WorkshopManager getManager() {
		return manager;
	}

	public void setManager(WorkshopManager manager) {
		this.manager = manager;
	}

	public List<WorkshopDetailsDto> getWorkshops() {
		return workshops;
	}

	public void setWorkshops(List<WorkshopDetailsDto> workshops) {
		this.workshops = workshops;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public int getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(int workshopId) {
		this.workshopId = workshopId;
	}

	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

}
