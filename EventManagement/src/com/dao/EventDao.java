package com.dao;

import java.util.List;

import com.pojo.AuthorDetailsDto;
import com.pojo.ConferenceDetailsDto;
import com.pojo.ConferencePaperMappingClass;
import com.pojo.EventDetailsDto;
import com.pojo.EventParticipantMappingClass;
import com.pojo.EventUserMappingClass;
import com.pojo.EventVolunteerMappingClass;
import com.pojo.PaperAuthorMappingClass;
import com.pojo.PaperDetailsDto;

public interface EventDao {
	public void addEvent(EventDetailsDto detailsDto);
	public void addConference(ConferenceDetailsDto conference);
	public void addPaper(PaperDetailsDto paper);
	public void addAuthor(AuthorDetailsDto author);
	public void addUserToEvent(EventUserMappingClass eventUser);
	public void addVolunteerToEvent(EventVolunteerMappingClass eventVolunteer);
	public void addParticipantToEvent(EventParticipantMappingClass eventParticipant);
	public void addPaperToConference(ConferencePaperMappingClass conferencePaper);
	public void addAuthorToPaper(PaperAuthorMappingClass paperAuthor);
	public EventDetailsDto getEventById(int eventId);
	public ConferenceDetailsDto getConferenceById(int conferenceId);
	public List<AuthorDetailsDto> getAuthorsInConference(int conferenceId);
	public List<EventDetailsDto> getEventsByType(int typeId);
	public List<ConferenceDetailsDto> getAllConferences();
	public List<EventDetailsDto> getEventsByScope(int scopeId);
	public List<EventDetailsDto> getAllEvents();
	public List<EventUserMappingClass> getEventsOfCoordinator(int userId);
	public void updateEvent(EventDetailsDto detailsDto);
	public void deleteEventById(int eventId);
	public void deleteEventByScope(int scopeId);
	public void deleteEventByType(int typeId);
	public void deleteAllEvents();
	public void deleteUserOfEvent(EventUserMappingClass eventUser);
	public void deleteVolunteerOfEvent(EventVolunteerMappingClass eventVolunteer);
	public void deleteParticipantOfEvent(EventParticipantMappingClass eventParticipant);
	public void deleteAllUsersOfEvent(int eventId);
	public void updateConference(ConferenceDetailsDto conference);
}
