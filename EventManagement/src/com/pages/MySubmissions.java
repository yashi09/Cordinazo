package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.manager.ConferenceManager;
import com.manager.EventManager;
import com.manager.UserManager;
import com.pojo.AuthorDetailsDto;
import com.pojo.ConferenceDetailsDto;
import com.pojo.PaperDetailsDto;
import com.pojo.UserDetailsDto;

public class MySubmissions extends BasePage{
	private EventManager eventManager;
	private UserManager userManager;
	private ConferenceManager confManager;
	private ConferenceDetailsDto conferenceDto;
	private int conferenceId;
	private List<AuthorDetailsDto> authors;
	private List<PaperDetailsDto> papers;
	private UserDetailsDto user;
	@Override
	public void preProcess(Map<String, Object> map) {
		conferenceId = (int)map.get("conferenceId");
		conferenceDto = eventManager.getConference(conferenceId);
		authors = eventManager.getAuthorsInConference(conferenceId);
		user = (UserDetailsDto)getContext().get("userKaObject");
		papers = new ArrayList<PaperDetailsDto>();
		for(AuthorDetailsDto dto : authors){
			if(dto.getEmail().equals(user.getEmail())){
				papers.add(confManager.getPaper(dto.getPaperId()));
			}
		}
	}

	@Override
	public Map<String, Object> postProcess() {
		// TODO Auto-generated method stub
		return null;
	}

	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public ConferenceDetailsDto getConferenceDto() {
		return conferenceDto;
	}

	public void setConferenceDto(ConferenceDetailsDto conferenceDto) {
		this.conferenceDto = conferenceDto;
	}

	public int getConferenceId() {
		return conferenceId;
	}

	public void setConferenceId(int conferenceId) {
		this.conferenceId = conferenceId;
	}

	public List<AuthorDetailsDto> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorDetailsDto> authors) {
		this.authors = authors;
	}

	public List<PaperDetailsDto> getPapers() {
		return papers;
	}

	public void setPapers(List<PaperDetailsDto> papers) {
		this.papers = papers;
	}

	public ConferenceManager getConfManager() {
		return confManager;
	}

	public void setConfManager(ConferenceManager confManager) {
		this.confManager = confManager;
	}

	public UserDetailsDto getUser() {
		return user;
	}

	public void setUser(UserDetailsDto user) {
		this.user = user;
	}
	
}
