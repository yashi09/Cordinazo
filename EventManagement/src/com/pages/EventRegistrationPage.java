package com.pages;

import java.util.Map;

import com.manager.EventManager;
import com.pojo.EventDetailsDto;

public class EventRegistrationPage extends BasePage{
	private EventDetailsDto eventDto;
	private int eventId;
	private EventManager eventManager;
	private String eventName;
	private String firstName;
	private String lastName;
	private String email;
	private int role;
	private long phoneNo;
	private String pwd;
	private String work;
	
	
	@Override
	public void preProcess(Map map) {
		this.eventId=(int)map.get("eventId");
		System.out.println("inside preProcess in eventRegistrationPage. eventId = "+eventId);

	}

	@Override
	public Map postProcess() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public EventDetailsDto getEventDto() {
		return eventDto;
	}
	public void setEventDto(EventDetailsDto eventDto) {
		this.eventDto = eventDto;
	}
	public int getEventId() {
		return eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public EventManager getEventManager() {
		return eventManager;
	}
	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
}
