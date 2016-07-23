package com.pojo;

import java.io.Serializable;
import java.util.Set;

public class PaperDetailsDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int conferenceId;
	private int paperId;
	private int paperStatus;
	private Set<AuthorDetailsDto> authors;
	private String title;
	private String abstractOfPaper;
	
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public Set<AuthorDetailsDto> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<AuthorDetailsDto> authors) {
		this.authors = authors;
	}
	public int getConferenceId() {
		return conferenceId;
	}
	public void setConferenceId(int conferenceId) {
		this.conferenceId = conferenceId;
	}
	public int getPaperStatus() {
		return paperStatus;
	}
	public void setPaperStatus(int paperStatus) {
		this.paperStatus = paperStatus;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbstractOfPaper() {
		return abstractOfPaper;
	}
	public void setAbstractOfPaper(String abstractOfPaper) {
		this.abstractOfPaper = abstractOfPaper;
	}  
	
}
