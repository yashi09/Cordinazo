package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.GuestLectureDao;
import com.pojo.GuestLectureDetailsDto;

public class GuestLectureDaoImpl extends BaseDao implements GuestLectureDao{

	@Override
	public void addGuestLecture(GuestLectureDetailsDto guestLectureDto) {
		try{
			Session session = getSession();
			session.saveOrUpdate(guestLectureDto);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public GuestLectureDetailsDto getGuestLectureById(int guestLectureId) {
		GuestLectureDetailsDto guestLectureDto = new GuestLectureDetailsDto();
		try{
			Session session = getSession();
			guestLectureDto = (GuestLectureDetailsDto)session.get(GuestLectureDetailsDto.class, guestLectureId);
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return guestLectureDto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GuestLectureDetailsDto> getAllGuestLectures() {
		List<GuestLectureDetailsDto> guestLectures = null;
		try{
			Session session = getSession();
			guestLectures = session.createCriteria(GuestLectureDetailsDto.class).list();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return guestLectures;
	}

	@Override
	public void updateGuestLecture(GuestLectureDetailsDto guestLectureDto) {
		try{
			Session session = getSession();
			session.saveOrUpdate(guestLectureDto);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void deleteGuestLectureById(int guestLectureId) {
		try{
			Session session = getSession();
			GuestLectureDetailsDto guestLectureDto =(GuestLectureDetailsDto) session.get(GuestLectureDetailsDto.class, guestLectureId);
			session.delete(guestLectureDto);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

}
