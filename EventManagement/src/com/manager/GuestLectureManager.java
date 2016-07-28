package com.manager;

import java.util.List;

import com.pojo.GuestLectureDetailsDto;

public interface GuestLectureManager {
	public void addGuestLecture(GuestLectureDetailsDto guestLectureDto);
	public GuestLectureDetailsDto getGuestLecture(int guestLectureId);
	public List<GuestLectureDetailsDto> getAllGuestLectures();
	public void updateGuestLecture(GuestLectureDetailsDto guestLectureDto);
	public void deleteGuestLecture(int guestLectureId);
	
}
