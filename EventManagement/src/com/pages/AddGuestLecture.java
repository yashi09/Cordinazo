package com.pages;

import java.util.Date;
import java.util.Map;

import com.manager.GuestLectureManager;
import com.pojo.GuestLectureDetailsDto;
import com.pojo.ScopeDetailsDto;
import com.util.EventUtil;

public class AddGuestLecture extends BasePage{
	private GuestLectureManager manager;
	private String time;
	private String desc;
	private String date;
	private String venue;
	private int scope;
	private String glName;
	private String work;
	
	@Override
	public void preProcess(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> postProcess() {
		if(work!=null && !work.isEmpty()){
			if(work.equals("addGuestLecture")){
				GuestLectureDetailsDto guestLectureDto = new GuestLectureDetailsDto();
				guestLectureDto.setEventName(glName);
				guestLectureDto.setEventDescription(desc);
				Date date = EventUtil.getDate(this.date);
				guestLectureDto.setStartDate(date);
				guestLectureDto.setTime(time);
				ScopeDetailsDto scopeDto = new ScopeDetailsDto();
				scopeDto.setScopeId(this.scope);
				guestLectureDto.setScopeDto(scopeDto);
				guestLectureDto.setVenue(venue);
				manager.addGuestLecture(guestLectureDto);
			}
		}
		return null;
	}

	public GuestLectureManager getManager() {
		return manager;
	}

	public void setManager(GuestLectureManager manager) {
		this.manager = manager;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	public String getGlName() {
		return glName;
	}

	public void setGlName(String glName) {
		this.glName = glName;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
	
}
