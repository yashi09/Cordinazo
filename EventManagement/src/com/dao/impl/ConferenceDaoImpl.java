package com.dao.impl;

import org.hibernate.Session;

import com.dao.ConferenceDao;
import com.pojo.PaperDetailsDto;

public class ConferenceDaoImpl extends BaseDao implements ConferenceDao{

	@Override
	public PaperDetailsDto getPaperById(int paperId) {
		PaperDetailsDto paperDto = new PaperDetailsDto();
		try{
			Session session = getSession();
			paperDto = (PaperDetailsDto)session.get(PaperDetailsDto.class, paperId);
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return paperDto;
	}

}
