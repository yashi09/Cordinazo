package com.manager.impl;

import java.util.List;

import com.dao.GuestLectureDao;
import com.manager.GuestLectureManager;
import com.pojo.GuestLectureDetailsDto;

public class GuestLectureManagerImpl implements GuestLectureManager{
	private GuestLectureDao guestLectureDao;
	@Override
	public void addGuestLecture(GuestLectureDetailsDto guestLectureDto) {
		guestLectureDao.addGuestLecture(guestLectureDto);
	}

	@Override
	public GuestLectureDetailsDto getGuestLecture(int guestLectureId) {
		return guestLectureDao.getGuestLectureById(guestLectureId);
	}

	@Override
	public List<GuestLectureDetailsDto> getAllGuestLectures() {
		return guestLectureDao.getAllGuestLectures();
	}

	@Override
	public void updateGuestLecture(GuestLectureDetailsDto guestLectureDto) {
		guestLectureDao.updateGuestLecture(guestLectureDto);
	}

	@Override
	public void deleteGuestLecture(int guestLectureId) {
		guestLectureDao.deleteGuestLectureById(guestLectureId);
	}

	public GuestLectureDao getGuestLectureDao() {
		return guestLectureDao;
	}

	public void setGuestLectureDao(GuestLectureDao guestLectureDao) {
		this.guestLectureDao = guestLectureDao;
	}
	
}
