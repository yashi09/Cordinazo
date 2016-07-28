package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.manager.EventManager;
import com.pojo.ConferenceDetailsDto;

public class AdminConfResearchAreas extends BasePage{
	private EventManager manager;
	private int conferenceId;
	private ConferenceDetailsDto conference;
	private List<String> topics;
	private String topic;
	private String work;
	@Override
	public void preProcess(Map<String, Object> map) {
		conferenceId = (int)map.get("conferenceId");
		conference = manager.getConference(conferenceId);
		getContext().put("conferenceDto", conference);
		topics = new ArrayList<String>(conference.getConferenceTopics());

	}

	@Override
	public Map<String, Object> postProcess() {
		Map<String,Object> map = null;
		conference =(ConferenceDetailsDto) getContext().get("conferenceDto");
		getContext().remove("conferenceDto");
		if(work!=null){
			map = new HashMap<String, Object>();
			map.put("conferenceId", conference.getEventId());
			if(work.equals("addTopic")){
				conference.getConferenceTopics().add(topic);
				manager.updateConference(conference);
			} else if(work.equals("delTopic")){
				Set<String> topics = conference.getConferenceTopics();
				Set<String> newTopics = new HashSet<String>();
				Iterator<String> i =topics.iterator();
				while(i.hasNext()){
					String t = i.next();
					if(!(t.equals(topic)))
						newTopics.add(t);
				}
				conference.setConferenceTopics(newTopics);
				manager.updateConference(conference);
			}
		}
		return map;
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

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
}
