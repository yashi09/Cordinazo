package com.manager;

import com.pojo.PaperDetailsDto;

public interface ConferenceManager {
	public PaperDetailsDto getPaper(int paperId);
	public void updatePaper(PaperDetailsDto paperDto);
}
