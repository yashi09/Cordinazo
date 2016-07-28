package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.manager.EventManager;
import com.manager.WorkshopManager;
import com.pojo.EventParticipantMappingClass;
import com.pojo.EventVolunteerMappingClass;
import com.pojo.UserDetailsDto;
import com.pojo.WorkshopDetailsDto;

public class WorkshopDetailsPage extends BasePage{
	private WorkshopManager workshopManager;
	private EventManager manager;
	private WorkshopDetailsDto workshopDto;
	private List<UserDetailsDto> coords;
	private int workshopId;
	private boolean participant;
	private boolean volunteer;
	private String work;
	
	@Override
	public void preProcess(Map<String, Object> map) {
		if(map!=null && !map.isEmpty()){
			workshopId = (int)map.get("workshopId");
			workshopDto = workshopManager.getWorkshop(workshopId);
			getContext().put("workshopDto", workshopDto);
			coords = new ArrayList<UserDetailsDto>(workshopDto.getEventUsers());
			
			UserDetailsDto userDetailsDto = (UserDetailsDto)getContext().get("userKaObject");
			Set<UserDetailsDto> eventParticipants = workshopDto.getEventParticipants();
			Set<UserDetailsDto> eventVolunteers = workshopDto.getEventVolunteers();
			
			for(UserDetailsDto dto : eventParticipants){
				if(userDetailsDto.getUserId() == dto.getUserId()){
					participant = true;
					break;
				}
			}
			
			for(UserDetailsDto dto : eventVolunteers){
				if(userDetailsDto.getUserId() == dto.getUserId()){
					volunteer = true;
					break;
				}
			}
		}
		System.out.println("participant = "+participant);
		System.out.println("volunteer = "+volunteer);
	}

	@Override
	public Map<String, Object> postProcess() {
		workshopDto =(WorkshopDetailsDto) getContext().get("workshopDto");
		getContext().remove("workshopDto");
		workshopId = workshopDto.getEventId();
		Map<String,Object> map = null;
		if(work!=null && !work.isEmpty()){
			map = new HashMap<String, Object>();
			map.put("workshopId", workshopId);
			/*FacesContext context = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession)context.getExternalContext().getSession(false);
			UserDetailsDto userDetailsDto = (UserDetailsDto) session.getAttribute("loggedInDto");*/
			UserDetailsDto userDetailsDto = (UserDetailsDto)getContext().get("userKaObject");
			if(work.equals("volunteer")){
				EventVolunteerMappingClass eventVolunteer = new EventVolunteerMappingClass();
				eventVolunteer.setEventId(workshopId);
				eventVolunteer.setUserId(userDetailsDto.getUserId());
				manager.addVolunteerToEvent(eventVolunteer);
			} else if(work.equals("participate")){
				EventParticipantMappingClass eventParticipant = new EventParticipantMappingClass();
				eventParticipant.setEventId(workshopId);
				eventParticipant.setUserId(userDetailsDto.getUserId());
				manager.addParticipantToEvent(eventParticipant);
			} else if(work.equals("withdrawVolunteering")){
				EventVolunteerMappingClass eventVolunteer = new EventVolunteerMappingClass();
				eventVolunteer.setEventId(workshopId);
				eventVolunteer.setUserId(userDetailsDto.getUserId());
				manager.deleteVolunteerOfEvent(eventVolunteer);
			} else if(work.equals("withdrawParticipation")){
				EventParticipantMappingClass eventParticipant = new EventParticipantMappingClass();
				eventParticipant.setEventId(workshopId);
				eventParticipant.setUserId(userDetailsDto.getUserId());
				manager.deleteParticipantOfEvent(eventParticipant);
			}
		}
		
		return map;
	}

	public WorkshopManager getWorkshopManager() {
		return workshopManager;
	}

	public void setWorkshopManager(WorkshopManager workshopManager) {
		this.workshopManager = workshopManager;
	}

	public WorkshopDetailsDto getWorkshopDto() {
		return workshopDto;
	}

	public void setWorkshopDto(WorkshopDetailsDto workshopDto) {
		this.workshopDto = workshopDto;
	}

	public List<UserDetailsDto> getCoords() {
		return coords;
	}

	public void setCoords(List<UserDetailsDto> coords) {
		this.coords = coords;
	}

	public int getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(int workshopId) {
		this.workshopId = workshopId;
	}

	public boolean isParticipant() {
		return participant;
	}

	public void setParticipant(boolean participant) {
		this.participant = participant;
	}

	public boolean isVolunteer() {
		return volunteer;
	}

	public void setVolunteer(boolean volunteer) {
		this.volunteer = volunteer;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public EventManager getManager() {
		return manager;
	}

	public void setManager(EventManager manager) {
		this.manager = manager;
	}
	
}
