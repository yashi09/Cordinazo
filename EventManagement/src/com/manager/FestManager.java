package com.manager;

import java.util.List;

import com.pojo.FestDetailsDto;
import com.pojo.FestEventMappingClass;

public interface FestManager {
	public void addFest(FestDetailsDto detailsDto);
	public void addEventToFest(FestEventMappingClass festEvent);
	public FestDetailsDto getFest(int festId);
	public List<FestDetailsDto> getAllFest();
	public void updateFest(FestDetailsDto detailsDto);
	public void deleteFest(int festId);
	public void deleteEventOfFest(FestEventMappingClass festevent);
	public void deleteAllFest();
	public void deleteAllEventsOfFest(int festId);
}
