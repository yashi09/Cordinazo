package com.pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.model.SelectItem;
import com.manager.EventManager;
import com.manager.UserManager;
import com.pojo.ConferenceDetailsDto;
import com.pojo.EventUserMappingClass;
import com.pojo.ScopeDetailsDto;
import com.pojo.UserDetailsDto;
import com.util.EventUtil;

public class AddConferencePage extends BasePage{
	private EventManager eventManager;
	private UserManager userManager;
	private String confName;
	private String acronym;
	private String startDate;
	private String endDate;
	private String submissionStart;
	private String submissionEnd;
	private String acceptance;
	private String registration;
	private String confDescription;
	private String topic1;
	private String topic2;
	private String topic3;
	private String topic4;
	private String topic5;
	private List<SelectItem> organizers;
	private int organizer1;
	private String work;
	private String venue;
	private int scope;
	
	@Override
	public void preProcess(Map<String, Object> map) {
		System.out.println("inside preProcess in addConference");
		List<UserDetailsDto> organizers = userManager.getAllOrganizers();
		System.out.println("organizers = "+organizers);
		this.organizers = new ArrayList<SelectItem>();
		for(UserDetailsDto dto : organizers){
			SelectItem itm = new SelectItem(dto.getUserId(), dto.getFirstName()+" "+dto.getLastName());
			this.organizers.add(itm);
		}
	}

	@Override
	public Map<String, Object> postProcess() {
		if(work!=null && work.equals("addConference")){
			ConferenceDetailsDto conference = new ConferenceDetailsDto();
			conference.setSubmissionStart(EventUtil.getDate(submissionStart));
			conference.setSubmissionEnd(EventUtil.getDate(submissionEnd));
			conference.setAcceptanceDate(EventUtil.getDate(acceptance));
			conference.setRegistrationDate(EventUtil.getDate(registration));
			conference.setStartDate(EventUtil.getDate(startDate));
			conference.setEndDate(EventUtil.getDate(endDate));
			conference.setEventName(confName);
			conference.setAcronym(acronym);
			conference.setEventDescription(confDescription);
			conference.setVenue(venue);
			Set<String> topics = new HashSet<String>();
			if(topic1!=null && !topic1.isEmpty()){
				topics.add(topic1);
			}
			if(topic2!=null && !topic2.isEmpty()){
				topics.add(topic2);
			}
			if(topic3!=null && !topic3.isEmpty()){
				topics.add(topic3);
			}
			if(topic4!=null && !topic4.isEmpty()){
				topics.add(topic4);
			}
			if(topic5!=null && !topic5.isEmpty()){
				topics.add(topic5);
			}
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
			conference.setConferenceTopics(topics);
			conference.setScopeDto(scopeDto);
			eventManager.addConference(conference);
			EventUserMappingClass eventUser = new EventUserMappingClass();
			eventUser.setEventId(conference.getEventId());
			eventUser.setUserId(organizer1);
			eventManager.addUserToEvent(eventUser);
		}
		return null;
	}

	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
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

	public String getTopic1() {
		return topic1;
	}

	public void setTopic1(String topic1) {
		this.topic1 = topic1;
	}

	public String getTopic2() {
		return topic2;
	}

	public void setTopic2(String topic2) {
		this.topic2 = topic2;
	}

	public String getTopic3() {
		return topic3;
	}

	public void setTopic3(String topic3) {
		this.topic3 = topic3;
	}

	public String getTopic4() {
		return topic4;
	}

	public void setTopic4(String topic4) {
		this.topic4 = topic4;
	}

	public String getTopic5() {
		return topic5;
	}

	public void setTopic5(String topic5) {
		this.topic5 = topic5;
	}

	public List<SelectItem> getOrganizers() {
		return organizers;
	}

	public void setOrganizers(List<SelectItem> organizers) {
		this.organizers = organizers;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public int getOrganizer1() {
		return organizer1;
	}

	public void setOrganizer1(int organizer1) {
		this.organizer1 = organizer1;
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
