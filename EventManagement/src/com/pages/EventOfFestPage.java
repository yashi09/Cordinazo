package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.manager.EventManager;
import com.pojo.EventDetailsDto;
import com.pojo.EventParticipantMappingClass;
import com.pojo.EventVolunteerMappingClass;
import com.pojo.UserDetailsDto;

public class EventOfFestPage extends BasePage{

	private String eventName;
	private int eventId;
	private EventDetailsDto eventDetail;
	private EventManager manager;
	private List<UserDetailsDto> eventCoordinaters= new ArrayList<UserDetailsDto>();
	private List<UserDetailsDto> eventParticipants= new ArrayList<UserDetailsDto>();
	private String eventDesc;
	private String firstPrize;
	private String secondPrize;
	private String thirdPrize;
	private String work;
	private boolean participant;
	private boolean volunteer;

	@Override
	public void preProcess(Map<String,Object> map) {
		System.out.println("inside preProcess in EventOfFestPage");
		eventId = (int)map.get("eventId");
		eventDetail = manager.getEvent(eventId);
		eventName = eventDetail.getEventName();
		eventDesc = eventDetail.getEventDescription();
		firstPrize = eventDetail.getFirstPrize();
		secondPrize = eventDetail.getSecondPrize();
		thirdPrize = eventDetail.getThirdPrize();

		/*FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession)context.getExternalContext().getSession(false);
		UserDetailsDto userDetailsDto = (UserDetailsDto) session.getAttribute("loggedInDto");*/
		
		UserDetailsDto userDetailsDto = (UserDetailsDto)getContext().get("userKaObject");
		System.out.println("userDetailsDto = "+userDetailsDto);
		Set<UserDetailsDto> eventParticipants = eventDetail.getEventParticipants();
		System.out.println("eventParticipants = "+eventParticipants);
		Set<UserDetailsDto> eventVolunteers = eventDetail.getEventVolunteers();
		System.out.println("eventVolunteers = "+eventVolunteers);
		
		for(UserDetailsDto dto : eventVolunteers){
			if(dto.getUserId()==userDetailsDto.getUserId()){
				volunteer = true;
			}
		}
		for(UserDetailsDto dto : eventParticipants){
			if(dto.getUserId()==userDetailsDto.getUserId()){
				participant = true;
			}
		}
		System.out.println("participant = "+participant);
		System.out.println("volunteer = "+volunteer);
		Set<UserDetailsDto> set = eventDetail.getEventUsers();
		List<UserDetailsDto> userList = new ArrayList<UserDetailsDto>(set);
		int i =0;
		for(UserDetailsDto dto : userList){
			System.out.println("got fest's userList. firstName = "+userList.get(i).getFirstName());
			i++;
			if(dto.getRole()==3){
				eventCoordinaters.add(dto);
			} else {
				if(dto.getRole()==4){
					eventParticipants.add(dto);
				}
			}
		}
	}

	@Override
	public Map<String,Object> postProcess() {
		Map<String,Object> map = new HashMap<String, Object>();
		if(work!=null && !work.isEmpty()){
			FacesContext context = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession)context.getExternalContext().getSession(false);
			UserDetailsDto userDetailsDto = (UserDetailsDto) session.getAttribute("loggedInDto");
			if(work.equals("volunteer")){
				EventVolunteerMappingClass eventVolunteer = new EventVolunteerMappingClass();
				eventVolunteer.setEventId(eventId);
				eventVolunteer.setUserId(userDetailsDto.getUserId());
				manager.addVolunteerToEvent(eventVolunteer);
			} else if(work.equals("participate")){
				EventParticipantMappingClass eventParticipant = new EventParticipantMappingClass();
				eventParticipant.setEventId(eventId);
				eventParticipant.setUserId(userDetailsDto.getUserId());
				manager.addParticipantToEvent(eventParticipant);
			} else if(work.equals("withdrawVolunteering")){
				EventVolunteerMappingClass eventVolunteer = new EventVolunteerMappingClass();
				eventVolunteer.setEventId(eventId);
				eventVolunteer.setUserId(userDetailsDto.getUserId());
				manager.deleteVolunteerOfEvent(eventVolunteer);
			} else if(work.equals("withdrawParticipation")){
				EventParticipantMappingClass eventParticipant = new EventParticipantMappingClass();
				eventParticipant.setEventId(eventId);
				eventParticipant.setUserId(userDetailsDto.getUserId());
				manager.deleteParticipantOfEvent(eventParticipant);
			}
		}
		map.put("eventId", eventId);
		return map;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public String getFirstPrize() {
		return firstPrize;
	}

	public void setFirstPrize(String firstPrize) {
		this.firstPrize = firstPrize;
	}

	public String getSecondPrize() {
		return secondPrize;
	}

	public void setSecondPrize(String secondPrize) {
		this.secondPrize = secondPrize;
	}

	public String getThirdPrize() {
		return thirdPrize;
	}

	public void setThirdPrize(String thirdPrize) {
		this.thirdPrize = thirdPrize;
	}

	public List<UserDetailsDto> getEventCoordinaters() {
		return eventCoordinaters;
	}

	public void setEventCoordinaters(List<UserDetailsDto> eventCoordinaters) {
		this.eventCoordinaters = eventCoordinaters;
	}

	public List<UserDetailsDto> getEventParticipants() {
		return eventParticipants;
	}

	public void setEventParticipants(List<UserDetailsDto> eventParticipants) {
		this.eventParticipants = eventParticipants;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public EventDetailsDto getEventDetail() {
		return eventDetail;
	}
	public void setEventDetail(EventDetailsDto eventDetail) {
		this.eventDetail = eventDetail;
	}
	public EventManager getManager() {
		return manager;
	}
	public void setManager(EventManager manager) {
		this.manager = manager;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
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
	
}

