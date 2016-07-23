package com.pojo;

import java.io.Serializable;

public class PaperAuthorMappingClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int paperId;
	private int authorId;
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
}
