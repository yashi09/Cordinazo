package com.pojo;

public class GuestLectureDetailsDto extends EventDetailsDto{
	private int guestLectureId;
	private String time;

	public int getGuestLectureId() {
		return guestLectureId;
	}

	public void setGuestLectureId(int guestLectureId) {
		this.guestLectureId = guestLectureId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
