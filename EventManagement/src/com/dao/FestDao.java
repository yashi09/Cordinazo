package com.dao;

import java.util.List;

import com.pojo.FestDetailsDto;
import com.pojo.FestEventMappingClass;

public interface FestDao {
	public void addFest(FestDetailsDto detailsDto);
	public void addEventToFest(FestEventMappingClass festEvent);
	public FestDetailsDto getFestById(int festId);
	public List<FestDetailsDto> getFestByScope(int scopeId);
	public List<FestDetailsDto> getAllFest();
	public void updateFest(FestDetailsDto detailsDto);
	public void deleteFestById(int festId);
	public void deleteEventOfFest(FestEventMappingClass festEvent);
	public void deleteAllFest();
	public void deleteAllEventsOfFest(int festId);
}
