package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.dao.WorkshopDao;
import com.pojo.WorkshopDetailsDto;

public class WorkshopDaoImpl extends BaseDao implements WorkshopDao{

	@Override
	public void addWorkshop(WorkshopDetailsDto workshopDto) {
		try{
			Session session = getSession();
			session.saveOrUpdate(workshopDto);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

	@Override
	public WorkshopDetailsDto getWorkshopById(int workshopId) {
		WorkshopDetailsDto workshopDto = null;
		try{
		Session session = getSession();
		workshopDto = (WorkshopDetailsDto)session.get(WorkshopDetailsDto.class, workshopId);
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
		return workshopDto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkshopDetailsDto> getAllWorkshop() {
		List<WorkshopDetailsDto> workshops = new ArrayList<WorkshopDetailsDto>();
		try{
		Session session = getSession();
		workshops = session.createCriteria(WorkshopDetailsDto.class).list();
		} catch(Exception e){
			e.printStackTrace();
			rollBack();
		} finally{
			closeSession();
		}
		return workshops;
	}

	@Override
	public void updateWorkshop(WorkshopDetailsDto workshopDto) {
		try{
			Session session = getSession();
			session.saveOrUpdate(workshopDto);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			System.out.println("inside finally in workshopDetailsDto.");
			closeSession();
		}
	}

	@Override
	public void deleteWorkshopById(int workshopId) {
		try{
			Session session = getSession();
			WorkshopDetailsDto workshopDto = (WorkshopDetailsDto)session.get(WorkshopDetailsDto.class, workshopId);
			session.delete(workshopDto);
			commitTransaction();
		} catch(Exception e){
			rollBack();
			e.printStackTrace();
		} finally{
			closeSession();
		}
	}

}
