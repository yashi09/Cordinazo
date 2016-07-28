package com.manager.impl;

import java.util.List;

import com.dao.EventDao;
import com.manager.EventManager;
import com.pojo.AuthorDetailsDto;
import com.pojo.ConferenceDetailsDto;
import com.pojo.ConferencePaperMappingClass;
import com.pojo.EventDetailsDto;
import com.pojo.EventParticipantMappingClass;
import com.pojo.EventUserMappingClass;
import com.pojo.EventVolunteerMappingClass;
import com.pojo.PaperAuthorMappingClass;
import com.pojo.PaperDetailsDto;

public class EventManagerImpl implements EventManager{
	EventDao eventDao;

	@Override
	public void addEvent(EventDetailsDto detailsDto) {
		eventDao.addEvent(detailsDto);
	}

	@Override
	public EventDetailsDto getEvent(int eventId) {	
		return eventDao.getEventById(eventId);
	}

	@Override
	public List<ConferenceDetailsDto> getAllConferences() {
		return eventDao.getAllConferences();
	}

	@Override
	public List<EventDetailsDto> getAllWorkshops() {
		return eventDao.getEventsByType(202);
	}

	@Override
	public List<EventDetailsDto> getAllGuestLectures() {
		return eventDao.getEventsByType(203);
	}

	@Override
	public List<EventDetailsDto> getAllCampusEvents() {
		return eventDao.getEventsByType(204);
	}

	@Override
	public List<EventDetailsDto> getAllEvents() {
		return eventDao.getAllEvents();
	}

	@Override
	public void updateEvent(EventDetailsDto detailsDto) {
		eventDao.updateEvent(detailsDto);
	}

	@Override
	public void deleteEvent(int eventId) {
		eventDao.deleteEventById(eventId);
	}

	@Override
	public void deleteAllConferences() {
		eventDao.deleteEventByType(201);
	}

	@Override
	public void deleteAllWorkshops() {
		eventDao.deleteEventByType(202);
	}

	@Override
	public void deleteAllGuestLectures() {
		eventDao.deleteEventByType(203);
	}

	@Override
	public void deleteAllParties() {
		eventDao.deleteEventByType(204);
	}

	@Override
	public void deleteAllEvents() {
		eventDao.deleteAllEvents();
	}

	public EventDao getEventDao() {
		return eventDao;
	}
	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	@Override
	public void deleteUserOfEvent(EventUserMappingClass eventUser) {
		eventDao.deleteUserOfEvent(eventUser);
	}

	@Override
	public void addUserToEvent(EventUserMappingClass eventUser) {
		eventDao.addUserToEvent(eventUser);
	}

	@Override
	public void deleteAllUsersOfEvent(int eventId) {
		eventDao.deleteAllUsersOfEvent(eventId);
	}

	@Override
	public void addVolunteerToEvent(EventVolunteerMappingClass eventVolunteer) {
		eventDao.addVolunteerToEvent(eventVolunteer);
	}

	@Override
	public void addParticipantToEvent(EventParticipantMappingClass eventParticipant) {
		eventDao.addParticipantToEvent(eventParticipant);
	}

	@Override
	public void deleteVolunteerOfEvent(EventVolunteerMappingClass eventVolunteer) {
		eventDao.deleteVolunteerOfEvent(eventVolunteer);
	}

	@Override
	public void deleteParticipantOfEvent(EventParticipantMappingClass eventParticipant) {
		eventDao.deleteParticipantOfEvent(eventParticipant);

	}

	@Override
	public List<EventUserMappingClass> getEventsOfCoordinator(int userId) {
		return eventDao.getEventsOfCoordinator(userId);
	}

	@Override
	public void addConference(ConferenceDetailsDto conference) {
		eventDao.addConference(conference);
	}

	@Override
	public ConferenceDetailsDto getConference(int conferenceId) {
		return eventDao.getConferenceById(conferenceId);
	}

	@Override
	public void updateConference(ConferenceDetailsDto conference) {
		eventDao.updateConference(conference);
	}

	@Override
	public void addPaperToConference(ConferencePaperMappingClass conferencePaper) {
		eventDao.addPaperToConference(conferencePaper);
	}

	@Override
	public void addAuthorToPaper(PaperAuthorMappingClass paperAuthor) {
		eventDao.addAuthorToPaper(paperAuthor);
	}

	@Override
	public void addPaper(PaperDetailsDto paper) {
		eventDao.addPaper(paper);
	}

	@Override
	public void addAuthor(AuthorDetailsDto author) {
		eventDao.addAuthor(author);
		
	}

	@Override
	public List<AuthorDetailsDto> getAuthorsInConference(int conferenceId) {
		return eventDao.getAuthorsInConference(conferenceId);
	}

	@Override
	public void deleteAllParticipantsOfEvent(int eventId) {
		eventDao.deleteAllParticipantsOfEvent(eventId);
	}

	@Override
	public void deleteAllVolunteersOfEvent(int eventId) {
		eventDao.deleteAllVolunteersOfEvent(eventId);
	}

}
