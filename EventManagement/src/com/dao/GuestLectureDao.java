package com.dao;

import java.util.List;

import com.pojo.GuestLectureDetailsDto;

public interface GuestLectureDao {
	public void addGuestLecture(GuestLectureDetailsDto guestLectureDto);
	public GuestLectureDetailsDto getGuestLectureById(int guestLectureId);
	public List<GuestLectureDetailsDto> getAllGuestLectures();
	public void updateGuestLecture(GuestLectureDetailsDto guestLectureDto);
	public void deleteGuestLectureById(int guestLectureId);
}
