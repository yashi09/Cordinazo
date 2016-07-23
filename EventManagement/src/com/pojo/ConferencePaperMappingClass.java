package com.pojo;

import java.io.Serializable;

public class ConferencePaperMappingClass implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int conferenceId;
	private int paperId;
	
	public int getConferenceId() {
		return conferenceId;
	}
	public void setConferenceId(int conferenceId) {
		this.conferenceId = conferenceId;
	}
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	
}
