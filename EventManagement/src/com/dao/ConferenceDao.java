package com.dao;

import com.pojo.PaperDetailsDto;

public interface ConferenceDao {
	public PaperDetailsDto getPaperById(int paperId);
	public void updatePaper(PaperDetailsDto paperDto);
}
