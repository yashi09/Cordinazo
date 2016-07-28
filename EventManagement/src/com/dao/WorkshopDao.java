package com.dao;

import java.util.List;

import com.pojo.WorkshopDetailsDto;

public interface WorkshopDao {
	public void addWorkshop(WorkshopDetailsDto workshopDto);
	public WorkshopDetailsDto getWorkshopById(int workshopId);
	public List<WorkshopDetailsDto> getAllWorkshop();
	public void updateWorkshop(WorkshopDetailsDto workshopDto);
	public void deleteWorkshopById(int workshopId);
}
