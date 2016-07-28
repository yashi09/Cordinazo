package com.pages;

import java.util.Map;

import com.manager.WorkshopManager;
import com.pojo.ScopeDetailsDto;
import com.pojo.WorkshopDetailsDto;
import com.util.EventUtil;

public class EditWorkshopPage extends BasePage{
	private WorkshopManager manager;
	private WorkshopDetailsDto workshopDto;
	private int workshopId;
	private String wsName;
	private String wsDesc;
	private int scope;
	private String venue;
	private String startDate;
	private String endDate;
	private String work;
	private int fees;
	@Override
	public void preProcess(Map<String, Object> map) {
		if(map!=null && !map.isEmpty()){
			workshopId = (int)map.get("workshopId");
			workshopDto = manager.getWorkshop(workshopId);
			getContext().put("workshopDto", workshopDto);
			wsName = workshopDto.getEventName();
			wsDesc = workshopDto.getEventDescription();
			scope = workshopDto.getScopeDto().getScopeId();
			venue = workshopDto.getVenue();
			startDate = workshopDto.getStartDate().toString();
			endDate = workshopDto.getEndDate().toString();
			fees = workshopDto.getFees();
		}
	}

	@Override
	public Map<String, Object> postProcess() {
		workshopDto =(WorkshopDetailsDto) getContext().get("workshopDto");
		getContext().remove("workshopDto");
		if(work!=null && work.equals("updateWorkshop")){
			workshopDto.setEventName(wsName);
			workshopDto.setEventDescription(wsDesc);
			workshopDto.setFees(fees);
			ScopeDetailsDto scopeDto = new ScopeDetailsDto();
			scopeDto.setScopeId(scope);
			workshopDto.setScopeDto(scopeDto);
			workshopDto.setStartDate(EventUtil.getDate(startDate));
			workshopDto.setEndDate(EventUtil.getDate(endDate));
			workshopDto.setVenue(venue);
			manager.updateWorkshop(workshopDto);
		}
		
		return null;
	}

	public WorkshopManager getManager() {
		return manager;
	}

	public void setManager(WorkshopManager manager) {
		this.manager = manager;
	}

	public WorkshopDetailsDto getWorkshopDto() {
		return workshopDto;
	}

	public void setWorkshopDto(WorkshopDetailsDto workshopDto) {
		this.workshopDto = workshopDto;
	}

	public int getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(int workshopId) {
		this.workshopId = workshopId;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
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

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}
	
}
