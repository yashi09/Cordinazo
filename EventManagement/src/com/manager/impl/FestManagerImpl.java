package com.manager.impl;

import java.util.List;

import com.dao.FestDao;
import com.manager.FestManager;
import com.pojo.FestDetailsDto;
import com.pojo.FestEventMappingClass;

public class FestManagerImpl implements FestManager{
	FestDao festDao;
	@Override
	public void addFest(FestDetailsDto detailsDto) {
		festDao.addFest(detailsDto);
	}

	@Override
	public FestDetailsDto getFest(int festId) {
		return festDao.getFestById(festId);
	}

	@Override
	public List<FestDetailsDto> getAllFest() {
		return festDao.getAllFest();
	}

	@Override
	public void updateFest(FestDetailsDto detailsDto) {
		festDao.updateFest(detailsDto);
	}

	@Override
	public void deleteFest(int festId) {
		festDao.deleteFestById(festId);
	}

	@Override
	public void deleteAllFest() {
		// TODO Auto-generated method stub
		
	}

	public FestDao getFestDao() {
		return festDao;
	}

	public void setFestDao(FestDao festDao) {
		this.festDao = festDao;
	}

	@Override
	public void addEventToFest(FestEventMappingClass festEvent) {
		festDao.addEventToFest(festEvent);
	}

	@Override
	public void deleteEventOfFest(FestEventMappingClass festevent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllEventsOfFest(int festId) {
		festDao.deleteAllEventsOfFest(festId);
	}
	

}
