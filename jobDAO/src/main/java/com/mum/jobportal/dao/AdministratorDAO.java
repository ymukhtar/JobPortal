package com.mum.jobportal.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IAdministratorDAO;
import com.mum.jobportal.domain.Administrator;
import com.mum.jobportal.domain.Authorities;

public class AdministratorDAO implements IAdministratorDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void create(Administrator adminstrator) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(adminstrator);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void update(Administrator adminstrator) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(adminstrator);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void delete(Administrator adminstrator) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(adminstrator);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public Administrator get(long id) {
		// TODO Auto-generated method stub
		return (Administrator)sessionFactory.getCurrentSession().get(Administrator.class, id);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public List<Administrator> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Administrator").list();
	}

}
