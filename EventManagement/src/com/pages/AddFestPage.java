package com.pages;

import java.util.ArrayList;
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
import com.pojo.ScopeDetailsDto;
import com.pojo.TypeDetailsDto;
import com.pojo.UserDetailsDto;
import com.util.EventUtil;

public class AddFestPage extends BasePage{


	private FestManager manager;
	private int festId;
	private String festName;
	private String festDescription;
	private TypeDetailsDto typeDto=new TypeDetailsDto();
	private ScopeDetailsDto scopeDto=new ScopeDetailsDto();
	private String startDate;
	private String endDate;
	private int scopeId=101;
	private int typeId=110;
	private String work;
	private String eventName1;
	private String eventName2;
	private String eventName3;
	private int coordinator11;
	private int coordinator12;
	private int coordinator13;
	private int coordinator21;
	private int coordinator22;
	private int coordinator23;
	private int coordinator31;
	private int coordinator32;
	private int coordinator33;

	private List<SelectItem> organizers;
	private UserManager userManager;
	private EventManager eventManager;

	@Override
	public void preProcess(Map<String,Object> map) {
		organizers = new ArrayList<SelectItem>();
		List<UserDetailsDto> organizers = userManager.getAllOrganizers();
		for(UserDetailsDto dto : organizers){
			System.out.println("organizer = "+dto);
			SelectItem itm = new SelectItem(dto.getUserId(), dto.getFirstName()+" "+dto.getLastName());
			this.organizers.add(itm);
		}
	}

	@Override
	public Map<String,Object> postProcess() {
		Map<String,Object> map=null;
		System.out.println("inside postProcess in AddFestPage. work = "+work);
		if(work!=null && work.equals("addFestToDb")){
			FestDetailsDto festDetailsDto = new FestDetailsDto();
			festDetailsDto.setFestName(festName);
			festDetailsDto.setStartDate(EventUtil.getDate(startDate));
			festDetailsDto.setEndDate(EventUtil.getDate(endDate));
			festDetailsDto.setFestDescription(festDescription);
			scopeDto.setScopeId(scopeId);
			if(scopeId==101){
				scopeDto.setScope("Intra-college");
			} else if(scopeId==102){
				scopeDto.setScope("Intra-state");
			} else if(scopeId==103){
				scopeDto.setScope("National");
			} else if(scopeId==104){
				scopeDto.setScope("International");
			}
			festDetailsDto.setScopeDto(scopeDto);
			typeDto.setEventTypeId(typeId);
			if(typeId==110){
				typeDto.setEventType("Cultural fest");
			} else if(typeId==120){
				typeDto.setEventType("Technical fest");
			}
			festDetailsDto.setTypeDto(typeDto);
			manager.addFest(festDetailsDto);
			if(eventName1!=null && !eventName1.isEmpty()){

				EventDetailsDto event1 = new EventDetailsDto();
				event1.setEventName(eventName1);
				event1.setFest(festDetailsDto);
				eventManager.addEvent(event1);
				FestEventMappingClass festEvent1 = new FestEventMappingClass();
				festEvent1.setEventId(event1.getEventId());
				festEvent1.setFestId(festDetailsDto.getFestId());
				manager.addEventToFest(festEvent1);
				EventUserMappingClass eventUser11 = new EventUserMappingClass();
				eventUser11.setEventId(event1.getEventId());
				eventUser11.setUserId(coordinator11);
				eventManager.addUserToEvent(eventUser11);
				EventUserMappingClass eventUser12 = new EventUserMappingClass();
				eventUser12.setEventId(event1.getEventId());
				eventUser12.setUserId(coordinator12);
				eventManager.addUserToEvent(eventUser12);
				EventUserMappingClass eventUser13 = new EventUserMappingClass();
				eventUser13.setEventId(event1.getEventId());
				eventUser13.setUserId(coordinator13);
				eventManager.addUserToEvent(eventUser13);
			}
			if(eventName2!=null && !eventName2.isEmpty()){
				EventDetailsDto event2 = new EventDetailsDto();
				event2.setEventName(eventName2);
				event2.setFest(festDetailsDto);
				eventManager.addEvent(event2);
				FestEventMappingClass festEvent2 = new FestEventMappingClass();
				festEvent2.setEventId(event2.getEventId());
				festEvent2.setFestId(festDetailsDto.getFestId());
				manager.addEventToFest(festEvent2);
				EventUserMappingClass eventUser21 = new EventUserMappingClass(); 
				eventUser21.setEventId(event2.getEventId());
				eventUser21.setUserId(coordinator21);
				eventManager.addUserToEvent(eventUser21);
				EventUserMappingClass eventUser22 = new EventUserMappingClass();
				eventUser22.setEventId(event2.getEventId());
				eventUser22.setUserId(coordinator22);
				eventManager.addUserToEvent(eventUser22);
				EventUserMappingClass eventUser23 = new EventUserMappingClass();
				eventUser23.setEventId(event2.getEventId());
				eventUser23.setUserId(coordinator23);
				eventManager.addUserToEvent(eventUser23);
			}
			if(eventName3!=null && !eventName3.isEmpty()){
				EventDetailsDto event3 = new EventDetailsDto();
				event3.setEventName(eventName3);
				event3.setFest(festDetailsDto);
				eventManager.addEvent(event3);
				FestEventMappingClass festEvent3 = new FestEventMappingClass();
				festEvent3.setEventId(event3.getEventId());
				festEvent3.setFestId(festDetailsDto.getFestId());
				manager.addEventToFest(festEvent3);
				EventUserMappingClass eventUser31 = new EventUserMappingClass();
				eventUser31.setEventId(event3.getEventId());
				eventUser31.setUserId(coordinator31);
				eventManager.addUserToEvent(eventUser31);
				EventUserMappingClass eventUser32 = new EventUserMappingClass();
				eventUser32.setEventId(event3.getEventId());
				eventUser32.setUserId(coordinator32);
				eventManager.addUserToEvent(eventUser32);
				EventUserMappingClass eventUser33 = new EventUserMappingClass();
				eventUser33.setEventId(event3.getEventId());
				eventUser33.setUserId(coordinator33);
				eventManager.addUserToEvent(eventUser33);
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
	public int getFestId() {
		return festId;
	}
	public void setFestId(int festId) {
		System.out.println("inside addFestPage . festId = "+festId);
		this.festId = festId;
	}
	public String getFestName() {
		return festName;
	}
	public void setFestName(String festName) {
		System.out.println("inside addFestPage . festName = "+festName);
		this.festName = festName;
	}
	public String getFestDescription() {
		return festDescription;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public void setFestDescription(String festDescription) {
		System.out.println("inside addFestPage . festDesc = "+festDescription);
		this.festDescription = festDescription;
	}
	public TypeDetailsDto getTypeDto() {
		return typeDto;
	}
	public void setTypeDto(TypeDetailsDto typeDto) {
		this.typeDto = typeDto;
	}
	public ScopeDetailsDto getScopeDto() {
		return scopeDto;
	}
	public void setScopeDto(ScopeDetailsDto scopeDto) {
		this.scopeDto = scopeDto;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		System.out.println("inside addFestPage . startDate = "+startDate);
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		System.out.println("inside addFestPage . endDate = "+endDate);
		this.endDate = endDate;
	}
	public int getScopeId() {
		return scopeId;
	}
	public void setScopeId(int scopeId) {
		System.out.println("inside addFestPage . scopeId = "+scopeId);
		this.scopeId = scopeId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		System.out.println("inside addFestPage . typeId = "+typeId);
		this.typeId = typeId;
	}
	public String getEventName1() {
		return eventName1;
	}
	public void setEventName1(String eventName1) {
		this.eventName1 = eventName1;
	}
	public String getEventName2() {
		return eventName2;
	}
	public void setEventName2(String eventName2) {
		this.eventName2 = eventName2;
	}
	public String getEventName3() {
		return eventName3;
	}
	public void setEventName3(String eventName3) {
		this.eventName3 = eventName3;
	}
	public List<SelectItem> getOrganizers() {
		return organizers;
	}
	public void setOrganizers(List<SelectItem> organizers) {
		this.organizers = organizers;
	}
	public UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public int getCoordinator11() {
		return coordinator11;
	}
	public void setCoordinator11(int coordinator11) {
		this.coordinator11 = coordinator11;
	}
	public int getCoordinator12() {
		return coordinator12;
	}
	public void setCoordinator12(int coordinator12) {
		this.coordinator12 = coordinator12;
	}
	public int getCoordinator13() {
		return coordinator13;
	}
	public void setCoordinator13(int coordinator13) {
		this.coordinator13 = coordinator13;
	}
	public int getCoordinator21() {
		return coordinator21;
	}
	public void setCoordinator21(int coordinator21) {
		this.coordinator21 = coordinator21;
	}
	public int getCoordinator22() {
		return coordinator22;
	}
	public void setCoordinator22(int coordinator22) {
		this.coordinator22 = coordinator22;
	}
	public int getCoordinator23() {
		return coordinator23;
	}
	public void setCoordinator23(int coordinator23) {
		this.coordinator23 = coordinator23;
	}
	public int getCoordinator31() {
		return coordinator31;
	}
	public void setCoordinator31(int coordinator31) {
		this.coordinator31 = coordinator31;
	}
	public int getCoordinator32() {
		return coordinator32;
	}
	public void setCoordinator32(int coordinator32) {
		this.coordinator32 = coordinator32;
	}
	public int getCoordinator33() {
		return coordinator33;
	}
	public void setCoordinator33(int coordinator33) {
		this.coordinator33 = coordinator33;
	}
	public EventManager getEventManager() {
		return eventManager;
	}
	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
}
