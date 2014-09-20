package com.mum.jobportal.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IVaccancyDAO;
import com.mum.jobportal.domain.Vaccancy;

public class VaccancyDAO implements IVaccancyDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(propagation=Propagation.MANDATORY)
	public void create(Vaccancy vaccancy) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(vaccancy);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void update(Vaccancy vaccancy) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(vaccancy);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void delete(Vaccancy vaccancy) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(vaccancy);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public Vaccancy get(long id) {
		// TODO Auto-generated method stub
		return (Vaccancy)sessionFactory.getCurrentSession().get(Vaccancy.class, id);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public List<Vaccancy> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Vaccancy").list();
	}

}
