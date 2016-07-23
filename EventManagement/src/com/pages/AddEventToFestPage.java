package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import com.manager.EventManager;
import com.manager.FestManager;
import com.manager.UserManager;
import com.pojo.EventDetailsDto;
import com.pojo.EventUserMappingClass;
import com.pojo.FestDetailsDto;
import com.pojo.FestEventMappingClass;
import com.pojo.UserDetailsDto;

public class AddEventToFestPage extends BasePage{

	private int festId;
	private String eventName;
	private String work;
	private FestManager festManager;
	private UserManager userManager;
	private FestDetailsDto festDto;
	private List<UserDetailsDto> userDtos;
	private List<SelectItem> organizers;
	private int coordId1;
	private int coordId2;
	private int coordId3;
	private EventManager eventManager;
	
	@Override
	public void preProcess(Map<String,Object> map) {
		organizers = new ArrayList<SelectItem>();
		festId = (int)map.get("festId");
		festDto = festManager.getFest(festId);
		System.out.println("inside preProcess in addEventToFestPage. festDto = "+festDto);
		List<UserDetailsDto> organizers = userManager.getAllOrganizers();
		for(UserDetailsDto dto : organizers){
			SelectItem itm = new SelectItem(dto.getUserId(), dto.getFirstName()+" "+dto.getLastName());
			this.organizers.add(itm);
		}
		
	}

	@Override
	public Map<String,Object> postProcess() {
		festDto = festManager.getFest(festId);
		System.out.println("inside postProcess in addEventToFestPage. festDto = "+festDto + " work = "+work);
		Map<String,Object> map = new HashMap<String,Object>();
		if(work!=null && work.equals("addEventToFest")){
		//	Set<EventDetailsDto> eventsOfFest;
			EventDetailsDto eventDto = new EventDetailsDto();
			eventDto.setEventName(eventName);
			eventDto.setFest(festDto);
			eventManager.addEvent(eventDto);
			FestEventMappingClass festEvent = new FestEventMappingClass();
			festEvent.setEventId(eventDto.getEventId());
			festEvent.setFestId(festDto.getFestId());
			festManager.addEventToFest(festEvent);
			EventUserMappingClass eventUser = null;
			if(coordId1!=0){
				eventUser = new EventUserMappingClass();
				eventUser.setEventId(eventDto.getEventId());
				eventUser.setUserId(coordId1);
				eventManager.addUserToEvent(eventUser);
			}
			if(coordId2!=0){
				eventUser = new EventUserMappingClass();
				eventUser.setEventId(eventDto.getEventId());
				eventUser.setUserId(coordId2);
				eventManager.addUserToEvent(eventUser);
			}
			if(coordId3!=0){
				eventUser = new EventUserMappingClass();
				eventUser.setEventId(eventDto.getEventId());
				eventUser.setUserId(coordId3);
				eventManager.addUserToEvent(eventUser);
			}			
			//festEvent.setEventId();
			/*eventsOfFest = festDto.getEvents();
			if(eventsOfFest==null){
				eventsOfFest = new HashSet<EventDetailsDto>();
			}
			eventsOfFest.add(eventDto);*/
			//festDto.setEvents(eventsOfFest);
			//festManager.updateFest(festDto);
			map.put("festId", festDto.getFestId());
		}
		return map;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public FestManager getFestManager() {
		return festManager;
	}

	public void setFestManager(FestManager festManager) {
		this.festManager = festManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public int getFestId() {
		return festId;
	}

	public void setFestId(int festId) {
		this.festId = festId;
	}

	public List<UserDetailsDto> getUserDtos() {
		return userDtos;
	}

	public void setUserDtos(List<UserDetailsDto> userDtos) {
		this.userDtos = userDtos;
	}

	public FestDetailsDto getFestDto() {
		return festDto;
	}

	public void setFestDto(FestDetailsDto festDto) {
		this.festDto = festDto;
	}

	public List<SelectItem> getOrganizers() {
		return organizers;
	}

	public void setOrganizers(List<SelectItem> organizers) {
		this.organizers = organizers;
	}
	public int getCoordId1() {
		return coordId1;
	}

	public void setCoordId1(int coordId1) {
		this.coordId1 = coordId1;
	}

	public int getCoordId2() {
		return coordId2;
	}

	public void setCoordId2(int coordId2) {
		this.coordId2 = coordId2;
	}

	public int getCoordId3() {
		return coordId3;
	}

	public void setCoordId3(int coordId3) {
		this.coordId3 = coordId3;
	}

	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
	
}
