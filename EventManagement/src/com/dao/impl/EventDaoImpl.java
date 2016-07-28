package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.dao.EventDao;
import com.pojo.AuthorDetailsDto;
import com.pojo.ConferenceDetailsDto;
import com.pojo.ConferencePaperMappingClass;
import com.pojo.EventDetailsDto;
import com.pojo.EventParticipantMappingClass;
import com.pojo.EventUserMappingClass;
import com.pojo.EventVolunteerMappingClass;
import com.pojo.PaperAuthorMappingClass;
import com.pojo.PaperDetailsDto;
import com.pojo.TypeDetailsDto;

public class EventDaoImpl extends BaseDao implements EventDao{

	@Override
	public void addEvent(EventDetailsDto detailsDto) {
		try{
			Session session = getSession();
			session.saveOrUpdate(detailsDto);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public EventDetailsDto getEventById(int eventId) {
		EventDetailsDto dto=new EventDetailsDto();
		try{
			Session session = getSession();
			dto = (EventDetailsDto)session.get(EventDetailsDto.class, eventId);
			
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return dto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventDetailsDto> getEventsByType(int typeId) {
		System.out.println("inside getEventsByType. typeId = "+typeId);
		List<EventDetailsDto> list = new ArrayList<EventDetailsDto>();
		try{
			Session session = getSession();
			TypeDetailsDto typeDetails = (TypeDetailsDto)session.get(TypeDetailsDto.class, typeId);
			list = session.createCriteria(EventDetailsDto.class).add(Restrictions.eq("eventTypeDetails", typeDetails)).list();
			System.out.println("got events list. list = "+list);
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return list;
	}

	@Override
	public List<EventDetailsDto> getEventsByScope(int scopeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventDetailsDto> getAllEvents() {
		System.out.println("inside getAllEvents in eventDaoImpl");
		List<EventDetailsDto> list = new ArrayList<EventDetailsDto>();
		try{
			Session session = getSession();
			list = session.createCriteria(EventDetailsDto.class).list();
			for(EventDetailsDto dto: list){
				Hibernate.initialize(dto.getEventTypeDetails());
				Hibernate.initialize(dto.getScopeDto());
			}
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
		System.out.println(list);
		return list;
	}

	@Override
	public void updateEvent(EventDetailsDto detailsDto) {
		System.out.println("inside updateEvent in EventDaoImpl. detailsDto = "+ detailsDto);
		try{
			Session session = getSession();
			session.saveOrUpdate(detailsDto);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void deleteEventById(int eventId) {
		System.out.println("inside deleteEventById in eventDaoImpl");
		try{
		Session session = getSession();
		EventDetailsDto dto = (EventDetailsDto)session.get(EventDetailsDto.class, eventId);
		session.delete(dto);
		commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void deleteEventByScope(int scopeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEventByType(int typeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllEvents() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteUserOfEvent(EventUserMappingClass eventUser) {
		try{
			Session session = getSession();
			session.delete(eventUser);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void addUserToEvent(EventUserMappingClass eventUser) {
		try{
			Session session = getSession();
			session.saveOrUpdate(eventUser);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteAllUsersOfEvent(int eventId) {
		try{
			Session session = getSession();
			List<EventUserMappingClass> eventUsers = session.createCriteria(EventUserMappingClass.class).add(Restrictions.eq("eventId", eventId)).list();
			for(EventUserMappingClass eu : eventUsers){
				session.delete(eu);
			}
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void addVolunteerToEvent(EventVolunteerMappingClass eventVolunteer) {
		try{
			Session session = getSession();
			session.saveOrUpdate(eventVolunteer);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void addParticipantToEvent(EventParticipantMappingClass eventParticipant) {
		try{
			Session session = getSession();
			session.saveOrUpdate(eventParticipant);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void deleteVolunteerOfEvent(EventVolunteerMappingClass eventVolunteer) {
		try{
			Session session = getSession();
			session.delete(eventVolunteer);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void deleteParticipantOfEvent(EventParticipantMappingClass eventParticipant) {
		try{
			Session session = getSession();
			session.delete(eventParticipant);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventUserMappingClass> getEventsOfCoordinator(int userId) {
		List<EventUserMappingClass> list = null;
		try{
			Session session = getSession();
			list = session.createCriteria(EventUserMappingClass.class).add(Restrictions.eq("userId", userId)).list();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return list;
	}

	@Override
	public void addConference(ConferenceDetailsDto conference) {
		try{
			Session session = getSession();
			session.saveOrUpdate(conference);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConferenceDetailsDto> getAllConferences() {
		List<ConferenceDetailsDto> conferences = new ArrayList<ConferenceDetailsDto>();
		try{
			Session session = getSession();
			conferences = session.createCriteria(ConferenceDetailsDto.class).list();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return conferences;
	}

	@Override
	public ConferenceDetailsDto getConferenceById(int conferenceId) {
		ConferenceDetailsDto conference = new ConferenceDetailsDto();
		try{
			Session session = getSession();
			conference = (ConferenceDetailsDto)session.get(ConferenceDetailsDto.class, conferenceId);
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return conference;
	}

	@Override
	public void updateConference(ConferenceDetailsDto conference) {
		try{
			Session session = getSession();
			session.saveOrUpdate(conference);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void addPaperToConference(ConferencePaperMappingClass conferencePaper) {
		try{
			Session session = getSession();
			session.saveOrUpdate(conferencePaper);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void addAuthorToPaper(PaperAuthorMappingClass paperAuthor) {
		try{
			Session session = getSession();
			session.saveOrUpdate(paperAuthor);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void addPaper(PaperDetailsDto paper) {
		try{
			Session session = getSession();
			session.saveOrUpdate(paper);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void addAuthor(AuthorDetailsDto author) {
		try{
			Session session = getSession();
			session.saveOrUpdate(author);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuthorDetailsDto> getAuthorsInConference(int conferenceId) {
		List<AuthorDetailsDto> authors = new ArrayList<AuthorDetailsDto>();
		try{
			Session session = getSession();
			authors = session.createCriteria(AuthorDetailsDto.class).add(Restrictions.eq("conferenceId", conferenceId)).list();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return authors;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteAllParticipantsOfEvent(int eventId) {
		try{
			Session session = getSession();
			List<EventParticipantMappingClass> eventParticipants = session.createCriteria(EventParticipantMappingClass.class).add(Restrictions.eq("eventId", eventId)).list();
			for(EventParticipantMappingClass dto : eventParticipants){
				session.delete(dto);
			}
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteAllVolunteersOfEvent(int eventId) {
		try{
			Session session = getSession();
			List<EventVolunteerMappingClass> eventVolunteers = session.createCriteria(EventVolunteerMappingClass.class).add(Restrictions.eq("eventId", eventId)).list();
			for(EventVolunteerMappingClass dto : eventVolunteers){
				session.delete(dto);
			}
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}
}
