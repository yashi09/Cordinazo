package com.manager;

import java.util.List;

import com.pojo.WorkshopDetailsDto;

public interface WorkshopManager {
	public void addWorkshop(WorkshopDetailsDto workshopDto);
	public WorkshopDetailsDto getWorkshop(int workshopId);
	public List<WorkshopDetailsDto> getAllWorkshops();
	public void updateWorkshop(WorkshopDetailsDto workshopDto);
	public void deleteWorkshop(int workshhopId);
}
