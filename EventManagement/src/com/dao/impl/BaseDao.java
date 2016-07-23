package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BaseDao {
	private static SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	{
		System.out.println("baseDao created. static called");
	}
	
	static{
		try{
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public Session getSession(){
		if(factory!=null){
			session = factory.openSession();
		} else {
			if(factory==null){
				factory = new Configuration().configure().buildSessionFactory();
				session = factory.openSession();
			}
		}
		beginTransaction();
		return session;
	}
	public void beginTransaction(){
		if(factory!=null){
			session = factory.openSession();
		}
		transaction = session.beginTransaction();
	}
	public void commitTransaction(){
		if(factory!=null){
			session = factory.openSession();
		}
		transaction.commit();
	}
	public void rollBack(){
		if(factory!=null){
			session = factory.openSession();
		}
		if(transaction!=null){
			transaction.rollback();
		}
	}
	public void closeSession(){
		session.close();
	}
	
	
}
