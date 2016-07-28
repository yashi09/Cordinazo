package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.ConferenceManager;
import com.manager.EventManager;
import com.pojo.ConferenceDetailsDto;
import com.pojo.PaperDetailsDto;

public class AdminPapersOfConf extends BasePage{
	private ConferenceManager confManager;
	private EventManager manager;
	private int conferenceId;
	private ConferenceDetailsDto conferenceDto;
	private List<PaperDetailsDto> papers;
	private String work;
	private int paperId;
	
	@Override
	public void preProcess(Map<String, Object> map) {
		if(map!=null && !map.isEmpty()){
			conferenceId = (int)map.get("conferenceId");
			conferenceDto = manager.getConference(conferenceId);
			papers = new ArrayList<PaperDetailsDto>(conferenceDto.getConferencePapers());
			getContext().put("conferenceDto", conferenceDto);
		}
	}

	@Override
	public Map<String, Object> postProcess() {
		Map<String,Object> map = new HashMap<String, Object>();
		if(work!=null && !work.isEmpty()){
			conferenceDto = (ConferenceDetailsDto)getContext().get("conferenceDto");
			getContext().remove("conferenceDto");
			if(work.equals("acceptPaper")){
				PaperDetailsDto paperDto = confManager.getPaper(paperId);
				paperDto.setPaperStatus(2);
				confManager.updatePaper(paperDto);
			} else if(work.equals("registerPaper")){
				PaperDetailsDto paperDto = confManager.getPaper(paperId);
				paperDto.setPaperStatus(3);
				confManager.updatePaper(paperDto);
			}
		}
		map.put("conferenceId", conferenceDto.getEventId());
		return map;
	}

	public ConferenceManager getConfManager() {
		return confManager;
	}

	public void setConfManager(ConferenceManager confManager) {
		this.confManager = confManager;
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

	public ConferenceDetailsDto getConferenceDto() {
		return conferenceDto;
	}

	public void setConferenceDto(ConferenceDetailsDto conferenceDto) {
		this.conferenceDto = conferenceDto;
	}

	public List<PaperDetailsDto> getPapers() {
		return papers;
	}

	public void setPapers(List<PaperDetailsDto> papers) {
		this.papers = papers;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public int getPaperId() {
		return paperId;
	}

	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	
}
