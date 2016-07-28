package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.EventManager;
import com.manager.GuestLectureManager;
import com.pojo.EventParticipantMappingClass;
import com.pojo.EventVolunteerMappingClass;
import com.pojo.GuestLectureDetailsDto;
import com.pojo.UserDetailsDto;

public class GuestLecturePage extends BasePage{
	private GuestLectureManager manager;
	private EventManager eventManager;
	private GuestLectureDetailsDto guestLectureDto;
	private int guestLectureId;
	private boolean volunteer;
	private boolean interested;
	private String work;
	
	@Override
	public void preProcess(Map<String, Object> map) {
		if(map!=null && !map.isEmpty()){
			guestLectureId = (int)map.get("guestLectureId");
			guestLectureDto = manager.getGuestLecture(guestLectureId);
			getContext().put("guestLectureDto", guestLectureDto);
			UserDetailsDto userDto = (UserDetailsDto)getContext().get("userKaObject");
			List<UserDetailsDto> interesteds = new ArrayList<UserDetailsDto>(guestLectureDto.getEventParticipants());		
			for(UserDetailsDto dto : interesteds){
				if(userDto.getUserId() == dto.getUserId()){
					interested = true;
					break;
				}
			}
			List<UserDetailsDto> volunteers = new ArrayList<UserDetailsDto>(guestLectureDto.getEventVolunteers());
			for(UserDetailsDto dto : volunteers){
				if(userDto.getUserId() == dto.getUserId()){
					volunteer = true;
					break;
				}
			}
		}
	}

	@Override
	public Map<String, Object> postProcess() {
		Map<String,Object> map = new HashMap<String, Object>();
		guestLectureDto = (GuestLectureDetailsDto)getContext().get("guestLectureDto");
		guestLectureId = guestLectureDto.getEventId();
		map.put("guestLectureId", guestLectureId);
		getContext().remove("guestLectureDto");
		UserDetailsDto userDto = (UserDetailsDto)getContext().get("userKaObject");
		if(work!=null && !work.isEmpty()){
			if(work.equals("volunteer")){
				EventVolunteerMappingClass eventVolunteer = new EventVolunteerMappingClass();
				eventVolunteer.setUserId(userDto.getUserId());
				eventVolunteer.setEventId(guestLectureId);
				eventManager.addVolunteerToEvent(eventVolunteer);
			} else if(work.equals("interested")){
				EventParticipantMappingClass eventParticipant = new EventParticipantMappingClass();
				eventParticipant.setEventId(guestLectureId);
				eventParticipant.setUserId(userDto.getUserId());
				eventManager.addParticipantToEvent(eventParticipant);
			} else if(work.equals("withdrawVolunteering")){
				EventVolunteerMappingClass eventVolunteer = new EventVolunteerMappingClass();
				eventVolunteer.setEventId(guestLectureId);
				eventVolunteer.setUserId(userDto.getUserId());
				eventManager.deleteVolunteerOfEvent(eventVolunteer);
			} else if(work.equals("notInterested")){
				EventParticipantMappingClass eventParticipant = new EventParticipantMappingClass();
				eventParticipant.setEventId(guestLectureId);
				eventParticipant.setUserId(userDto.getUserId());
				eventManager.deleteParticipantOfEvent(eventParticipant);
			}
		}
		return map;
	}

	public GuestLectureManager getManager() {
		return manager;
	}

	public void setManager(GuestLectureManager manager) {
		this.manager = manager;
	}

	public GuestLectureDetailsDto getGuestLectureDto() {
		return guestLectureDto;
	}

	public void setGuestLectureDto(GuestLectureDetailsDto guestLectureDto) {
		this.guestLectureDto = guestLectureDto;
	}

	public int getGuestLectureId() {
		return guestLectureId;
	}

	public void setGuestLectureId(int guestLectureId) {
		this.guestLectureId = guestLectureId;
	}

	public boolean isVolunteer() {
		return volunteer;
	}

	public void setVolunteer(boolean volunteer) {
		this.volunteer = volunteer;
	}

	public boolean isInterested() {
		return interested;
	}

	public void setInterested(boolean interested) {
		this.interested = interested;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
	
}
