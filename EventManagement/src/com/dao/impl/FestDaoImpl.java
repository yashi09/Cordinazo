package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.dao.FestDao;
import com.pojo.EventDetailsDto;
import com.pojo.FestDetailsDto;
import com.pojo.FestEventMappingClass;

public class FestDaoImpl extends BaseDao implements FestDao{

	@Override
	public void addFest(FestDetailsDto detailsDto) {
		try{
			Session session = getSession();
			session.saveOrUpdate(detailsDto);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public FestDetailsDto getFestById(int festId) {
		FestDetailsDto detailsDto = new FestDetailsDto();
		try{
			Session session=getSession();
			detailsDto = (FestDetailsDto)session.get(FestDetailsDto.class, festId);
			System.out.println("inside getFestById in festDaoImpl.festId = "+festId+" festDto = "+detailsDto);
			for(EventDetailsDto dto : detailsDto.getEvents()){
				Hibernate.initialize(dto.getScopeDto());
				Hibernate.initialize(dto.getEventTypeDetails());
				Hibernate.initialize(dto);
				Hibernate.initialize(dto.getEndDate());
				Hibernate.initialize(dto.getEventDescription());
				Hibernate.initialize(dto.getEventId());
				Hibernate.initialize(dto.getEventName());
				Hibernate.initialize(dto.getEventUsers());
				Hibernate.initialize(dto.getFirstPrize());
				Hibernate.initialize(dto.getSecondPrize());
				Hibernate.initialize(dto.getStartDate());
				Hibernate.initialize(dto.getThirdPrize());
				Hibernate.initialize(dto.getVenue());
			}
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return detailsDto;
	}

	@Override
	public List<FestDetailsDto> getFestByScope(int scopeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FestDetailsDto> getAllFest() {
		List<FestDetailsDto> list = new ArrayList<FestDetailsDto>();
		try{
			Session session = getSession();
			session.flush();
			session.clear();
			list =session.createCriteria(FestDetailsDto.class).list();
			/*System.out.println("inside getAllFest in festDaoImpl. list = "+list);
			System.out.println("festId = "+list.get(0).getFestId());
			System.out.println("festName = "+list.get(0).getFestName());
			System.out.println("endDate = "+list.get(0).getEndDate());
			System.out.println("scopeId = "+list.get(0).getScopeDto().getScopeId());
			System.out.println("startDate = "+list.get(0).getStartDate());
			System.out.println("typeId = "+list.get(0).getTypeDto().getEventTypeId());
			*/
			for(FestDetailsDto fest : list){
				Hibernate.initialize(fest.getEvents());
				Hibernate.initialize(fest.getScopeDto());
				Hibernate.initialize(fest.getTypeDto());
			}
			
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return list;
	}

	@Override
	public void updateFest(FestDetailsDto detailsDto) {
		Session session = getSession();
		try{
			session.flush();
			session.clear();
			session.saveOrUpdate(detailsDto);
			commitTransaction();
		} catch(Exception e){
			e.printStackTrace();
			rollBack();
		} finally{
			closeSession();
		}
	}

	@Override
	public void deleteFestById(int festId) {
		Session session = getSession();
		try{
			FestDetailsDto festDto = (FestDetailsDto)session.get(FestDetailsDto.class, festId);
			session.delete(festDto);
			commitTransaction();			
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void deleteAllFest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEventToFest(FestEventMappingClass festEvent) {
		try{
			Session session = getSession();
			session.saveOrUpdate(festEvent);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public void deleteEventOfFest(FestEventMappingClass festEvent) {
		try{
			Session session = getSession();
			session.delete(festEvent);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public void deleteAllEventsOfFest(int festId) {
		try{
			Session session = getSession();
			List<FestEventMappingClass> festEvents = session.createCriteria(FestEventMappingClass.class).add(Restrictions.eq("festId", festId)).list();
			for(FestEventMappingClass fe : festEvents){
				session.delete(fe);
			}
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

}
