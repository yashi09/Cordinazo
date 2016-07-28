package com.manager.impl;

import java.util.List;

import com.dao.WorkshopDao;
import com.manager.WorkshopManager;
import com.pojo.WorkshopDetailsDto;

public class WorkshopManagerImpl implements WorkshopManager{
	WorkshopDao workshopDao;
	@Override
	public void addWorkshop(WorkshopDetailsDto workshopDto) {
		workshopDao.addWorkshop(workshopDto);
	}

	@Override
	public WorkshopDetailsDto getWorkshop(int workshopId) {
		return workshopDao.getWorkshopById(workshopId);
	}

	@Override
	public List<WorkshopDetailsDto> getAllWorkshops() {
		return workshopDao.getAllWorkshop();
	}

	@Override
	public void updateWorkshop(WorkshopDetailsDto workshopDto) {
		workshopDao.updateWorkshop(workshopDto);
	}

	@Override
	public void deleteWorkshop(int workshhopId) {
		workshopDao.deleteWorkshopById(workshhopId);
	}

	public WorkshopDao getWorkshopDao() {
		return workshopDao;
	}

	public void setWorkshopDao(WorkshopDao workshopDao) {
		this.workshopDao = workshopDao;
	}
	
}
