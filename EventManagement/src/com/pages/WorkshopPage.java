package com.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.WorkshopManager;
import com.pojo.WorkshopDetailsDto;

public class WorkshopPage extends BasePage{
	private WorkshopManager manager;
	private List<WorkshopDetailsDto> workshops;
	private int workshopId;
	
	@Override
	public void preProcess(Map<String, Object> map) {
		workshops = manager.getAllWorkshops();
		
	}

	@Override
	public Map<String, Object> postProcess() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("workshopId", workshopId);
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

	public int getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(int workshopId) {
		this.workshopId = workshopId;
	}
	
}
