package com.pojo;

import java.util.Date;
import java.util.Set;

public class ConferenceDetailsDto extends EventDetailsDto{
	private String acronym;
	private Date submissionStart;
	private Date submissionEnd;
	private Date acceptanceDate;
	private Date registrationDate;
	private String refEmail;
	private Set<String> conferenceTopics;
	private Set<PaperDetailsDto> conferencePapers;
	
	public Date getSubmissionStart() {
		return submissionStart;
	}
	public void setSubmissionStart(Date submissionStart) {
		this.submissionStart = submissionStart;
	}
	public Date getAcceptanceDate() {
		return acceptanceDate;
	}
	public void setAcceptanceDate(Date acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}
	public Set<String> getConferenceTopics() {
		return conferenceTopics;
	}
	public void setConferenceTopics(Set<String> conferenceTopics) {
		this.conferenceTopics = conferenceTopics;
	}
	public Date getSubmissionEnd() {
		return submissionEnd;
	}
	public void setSubmissionEnd(Date submissionEnd) {
		this.submissionEnd = submissionEnd;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Set<PaperDetailsDto> getConferencePapers() {
		return conferencePapers;
	}
	public void setConferencePapers(Set<PaperDetailsDto> conferencePapers) {
		this.conferencePapers = conferencePapers;
	}
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	public String getRefEmail() {
		return refEmail;
	}
	public void setRefEmail(String refEmail) {
		this.refEmail = refEmail;
	}
	
}
