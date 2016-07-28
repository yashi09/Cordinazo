package com.pages;

import java.util.Map;

import com.manager.WorkshopManager;
import com.pojo.ScopeDetailsDto;
import com.pojo.WorkshopDetailsDto;
import com.util.EventUtil;

public class AddWorkshopPage extends BasePage{
	private WorkshopManager workshopManager;
	private String wsName;
	private String wsDesc;
	private int scope;
	private String venue;
	private Integer fees;
	private String startDate;
	private String endDate;
	private String work;
	
	@Override
	public void preProcess(Map<String, Object> map) {
		System.out.println("inside preProcess in addWorkshopPage");
	}

	@Override
	public Map<String, Object> postProcess() {
		if(work!=null && work.equals("addWorkshop")){
			if(!wsName.isEmpty()){
				WorkshopDetailsDto workshopDto = new WorkshopDetailsDto();
				workshopDto.setEventName(wsName);
				workshopDto.setEventDescription(wsDesc);
				workshopDto.setFees(fees);
				workshopDto.setStartDate(EventUtil.getDate(startDate));
				workshopDto.setEndDate(EventUtil.getDate(endDate));
				workshopDto.setVenue(venue);
				ScopeDetailsDto scopeDto = new ScopeDetailsDto();
				scopeDto.setScopeId(scope);
				workshopDto.setScopeDto(scopeDto);
				workshopManager.addWorkshop(workshopDto);
			}
		}
		return null;
	}

	public WorkshopManager getWorkshopManager() {
		return workshopManager;
	}

	public void setWorkshopManager(WorkshopManager workshopManager) {
		this.workshopManager = workshopManager;
	}

	public String getWsName() {
		return wsName;
	}

	public void setWsName(String wsName) {
		this.wsName = wsName;
	}

	public String getWsDesc() {
		return wsDesc;
	}

	public void setWsDesc(String wsDesc) {
		this.wsDesc = wsDesc;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Integer getFees() {
		return fees;
	}

	public void setFees(Integer fees) {
		this.fees = fees;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
	
}
