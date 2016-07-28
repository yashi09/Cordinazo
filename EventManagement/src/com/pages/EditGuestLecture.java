package com.pages;

import java.util.Date;
import java.util.Map;

import com.manager.GuestLectureManager;
import com.pojo.GuestLectureDetailsDto;
import com.pojo.ScopeDetailsDto;
import com.util.EventUtil;

public class EditGuestLecture extends BasePage{
	private GuestLectureManager manager;
	private GuestLectureDetailsDto guestLectureDto;
	private int guestLectureId;
	private String glName;
	private String date;
	private String time;
	private String desc;
	private int scope;
	private String venue;
	private String work;
	
	@Override
	public void preProcess(Map<String, Object> map) {
		if(map!=null && !map.isEmpty()){
			guestLectureId = (int)map.get("eventId");
			guestLectureDto = manager.getGuestLecture(guestLectureId);
			getContext().put("guestLectureDto", guestLectureDto);
			glName = guestLectureDto.getEventName();
			desc = guestLectureDto.getEventDescription();
			date = guestLectureDto.getStartDate().toString();
			time = guestLectureDto.getTime();
			scope = guestLectureDto.getScopeDto().getScopeId();
			venue = guestLectureDto.getVenue();
		}
	}

	@Override
	public Map<String, Object> postProcess() {
		guestLectureDto =(GuestLectureDetailsDto) getContext().get("guestLectureDto");
		getContext().remove("guestLectureDto");
		if(work!=null && !work.isEmpty()){
			if(work.equals("update")){
				Date date = EventUtil.getDate(this.date);
				guestLectureDto.setStartDate(date);
				guestLectureDto.setTime(time);
				guestLectureDto.setEventName(glName);
				guestLectureDto.setEventDescription(desc);
				guestLectureDto.setVenue(venue);
				ScopeDetailsDto scopeDto = new ScopeDetailsDto();
				scopeDto.setScopeId(this.scope);
				guestLectureDto.setScopeDto(scopeDto);
				manager.updateGuestLecture(guestLectureDto);
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

	public String getGlName() {
		return glName;
	}

	public void setGlName(String glName) {
		this.glName = glName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
	public void setWork(String work){
		this.work = work;
	}
	public String getWork(){
		return work;
	}
}
