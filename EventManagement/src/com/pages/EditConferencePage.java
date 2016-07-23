package com.pages;

import java.util.Map;

import com.manager.EventManager;
import com.pojo.ConferenceDetailsDto;
import com.pojo.ScopeDetailsDto;
import com.util.EventUtil;

public class EditConferencePage extends BasePage{
	private EventManager manager;
	private int conferenceId;
	private ConferenceDetailsDto conference;
	private String confName;
	private String acronym;
	private String startDate;
	private String endDate;
	private String submissionStart;
	private String submissionEnd;
	private String acceptance;
	private String registration;
	private String confDescription;
	private String work;
	private String venue;
	private int scope;
/*	private Set<UserDetailsDto> eventUsers;
	private Set<UserDetailsDto> eventVolunteers;
	private Set<String> topics;
	private Set<ConferencePaper> papers;
	private Set<UserDetailsDto> eventParticipants;*/
	
	@Override
	public void preProcess(Map<String, Object> map) {
		conferenceId = (int)map.get("conferenceId");
		conference = manager.getConference(conferenceId);
		getContext().put("conferenceDto", conference);
		confName = conference.getEventName();
		confDescription = conference.getEventDescription();
		acronym = conference.getAcronym();
		startDate = conference.getStartDate().toString();
		endDate = conference.getEndDate().toString();
		submissionStart = conference.getSubmissionStart().toString();
		submissionEnd = conference.getSubmissionEnd().toString();
		acceptance = conference.getAcceptanceDate().toString();
		registration = conference.getRegistrationDate().toString();
		venue = conference.getVenue();
		scope = conference.getScopeDto().getScopeId();
	}

	@Override
	public Map<String, Object> postProcess() {
		if(work!=null && work.equals("save")){
			conference=(ConferenceDetailsDto)getContext().get("conferenceDto");
			getContext().remove("conferenceDto");
			conference.setEventId(conferenceId);
			conference.setAcceptanceDate(EventUtil.getDate(acceptance));
			conference.setAcronym(acronym);
			conference.setEndDate(EventUtil.getDate(endDate));
			conference.setStartDate(EventUtil.getDate(startDate));
			conference.setEventDescription(confDescription);
			conference.setEventName(confName);
			conference.setRegistrationDate(EventUtil.getDate(registration));
			conference.setVenue(venue);
			conference.setSubmissionStart(EventUtil.getDate(submissionStart));
			conference.setSubmissionEnd(EventUtil.getDate(submissionEnd));
			ScopeDetailsDto scopeDto = new ScopeDetailsDto();
			scopeDto.setScopeId(scope);
			if(scope==101){
				scopeDto.setScope("Intra-college");
			} else if(scope==102){
				scopeDto.setScope("Intra-state");
			} else if(scope == 103){
				scopeDto.setScope("National");
			} else if(scope == 104){
				scopeDto.setScope("International");
			}
			conference.setScopeDto(scopeDto);
			manager.updateConference(conference);
		}
		return null;
	}

	public EventManager getManager() {
		return manager;
	}

	public void setManager(EventManager manager) {
		this.manager = manager;
	}

	public int getConferenceId() {
		return conferenceId;
	}

	public void setConferenceId(int conferenceId) {
		this.conferenceId = conferenceId;
	}

	public ConferenceDetailsDto getConference() {
		return conference;
	}

	public void setConference(ConferenceDetailsDto conference) {
		this.conference = conference;
	}

	public String getConfName() {
		return confName;
	}

	public void setConfName(String confName) {
		this.confName = confName;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getSubmissionStart() {
		return submissionStart;
	}

	public void setSubmissionStart(String submissionStart) {
		this.submissionStart = submissionStart;
	}

	public String getSubmissionEnd() {
		return submissionEnd;
	}

	public void setSubmissionEnd(String submissionEnd) {
		this.submissionEnd = submissionEnd;
	}

	public String getAcceptance() {
		return acceptance;
	}

	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getConfDescription() {
		return confDescription;
	}

	public void setConfDescription(String confDescription) {
		this.confDescription = confDescription;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}
}
