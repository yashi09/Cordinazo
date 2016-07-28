package com.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.EventManager;
import com.manager.GuestLectureManager;
import com.pojo.GuestLectureDetailsDto;

public class AdminGuestLecture extends BasePage{
	private EventManager eventManager;
	private GuestLectureManager manager;
	private String work;
	private int guestLectureId;
	private List<GuestLectureDetailsDto> guestLectures;
	
	@Override
	public void preProcess(Map<String, Object> map) {
		 guestLectures = manager.getAllGuestLectures();
	}

	@Override
	public Map<String, Object> postProcess() {
		Map<String,Object> map = null;
		if(work!=null && !work.isEmpty()){
			map = new HashMap<String, Object>();
			map.put("eventId", guestLectureId);
			if(work.equals("del")){
				eventManager.deleteAllUsersOfEvent(guestLectureId);
				eventManager.deleteAllParticipantsOfEvent(guestLectureId);
				eventManager.deleteAllVolunteersOfEvent(guestLectureId);
				manager.deleteGuestLecture(guestLectureId);
			}
		}
		return map;
	}

	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public int getGuestLectureId() {
		return guestLectureId;
	}

	public void setGuestLectureId(int guestLectureId) {
		this.guestLectureId = guestLectureId;
	}

	public List<GuestLectureDetailsDto> getGuestLectures() {
		return guestLectures;
	}

	public void setGuestLectures(List<GuestLectureDetailsDto> guestLectures) {
		this.guestLectures = guestLectures;
	}

	public GuestLectureManager getManager() {
		return manager;
	}

	public void setManager(GuestLectureManager manager) {
		this.manager = manager;
	}
	
}
