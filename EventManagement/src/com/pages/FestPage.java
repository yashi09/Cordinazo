package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.manager.EventManager;
import com.manager.FestManager;
import com.pojo.EventDetailsDto;
import com.pojo.FestDetailsDto;

public class FestPage extends BasePage{
	private EventManager eventManager;
	private List<EventDetailsDto> eList;
	private List<FestDetailsDto> fList;
	private FestManager festManager;
	private int eventTypeId;
	private int festId;

	@Override
	public void preProcess(Map<String,Object> map) {
		List<EventDetailsDto> list = new ArrayList<EventDetailsDto>();
		eventTypeId= (int)map.get("eventTypeId");
		System.out.println("inside preProcess in eventPage. eventTypeId = "+ eventTypeId);
		if(eventTypeId==201){
			/*list = eventManager.getAllConferences();
			eList=list;*/
		} else{
			if(eventTypeId==202){
				list = eventManager.getAllWorkshops();
				eList=list;
			} else{
				if(eventTypeId==203){
					list = eventManager.getAllGuestLectures();
					eList=list;
				} else {
					if(eventTypeId==204){
						List<FestDetailsDto> list1=festManager.getAllFest();
						fList = list1;
					}
				}
			}
		}
	}

	@Override
	public Map<String,Object> postProcess() {
		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("festId", festId);
		return map;
	}
	public List<FestDetailsDto> getfList() {
		return fList;
	}
	public void setfList(List<FestDetailsDto> fList) {
		this.fList = fList;
	}
	public int getFestId() {
		System.out.println("inside getFestId . festId = "+this.festId);
		return festId;
	}
	public void setFestId(int festId) {
		System.out.println("inside setFestId. festId = "+festId);
		this.festId = festId;
	}
	public int getEventTypeId() {
		return eventTypeId;
	}
	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
	public List<EventDetailsDto> geteList() {
		return eList;
	}
	public void seteList(List<EventDetailsDto> eList) {
		this.eList = eList;
	}
	public EventManager getEventManager() {
		return eventManager;
	}
	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
	public FestManager getFestManager() {
		return festManager;
	}
	public void setFestManager(FestManager festManager) {
		this.festManager = festManager;
	}
}
