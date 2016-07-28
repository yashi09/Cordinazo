package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.GuestLectureManager;
import com.pojo.GuestLectureDetailsDto;

public class GuestLecturesHome extends BasePage{
	private GuestLectureManager manager;
	private List<GuestLectureDetailsDto> guestLectures;
	private int guestLectureId;  

	@Override
	public void preProcess(Map<String, Object> map) {
		guestLectures = new ArrayList<GuestLectureDetailsDto>();
		guestLectures = manager.getAllGuestLectures();
		System.out.println("guestLectures = "+guestLectures);
	}

	@Override
	public Map<String, Object> postProcess() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("guestLectureId", guestLectureId);
		return map;
	}

	public GuestLectureManager getManager() {
		return manager;
	}

	public void setManager(GuestLectureManager manager) {
		this.manager = manager;
	}

	public List<GuestLectureDetailsDto> getGuestLectures() {
		return guestLectures;
	}

	public void setGuestLectures(List<GuestLectureDetailsDto> guestLectures) {
		this.guestLectures = guestLectures;
	}

	public int getGuestLectureId() {
		return guestLectureId;
	}

	public void setGuestLectureId(int guestLectureId) {
		this.guestLectureId = guestLectureId;
	}

}
