package com.manager.impl;

import com.dao.ConferenceDao;
import com.manager.ConferenceManager;
import com.pojo.PaperDetailsDto;

public class ConferenceManagerImpl implements ConferenceManager{
	private ConferenceDao conferenceDao;
	@Override
	public PaperDetailsDto getPaper(int paperId) {
		return conferenceDao.getPaperById(paperId);
	}
	public ConferenceDao getConferenceDao() {
		return conferenceDao;
	}
	public void setConferenceDao(ConferenceDao conferenceDao) {
		this.conferenceDao = conferenceDao;
	}
	@Override
	public void updatePaper(PaperDetailsDto paperDto) {
		conferenceDao.updatePaper(paperDto);
	}

}
