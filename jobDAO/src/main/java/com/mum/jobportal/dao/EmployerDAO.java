package com.mum.jobportal.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IEmployerDAO;
import com.mum.jobportal.domain.Category;
import com.mum.jobportal.domain.Employer;

public class EmployerDAO implements IEmployerDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void create(Employer employer) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(employer);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void update(Employer employer) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(employer);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void delete(Employer employer) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(employer);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public Employer get(long id) {
		// TODO Auto-generated method stub
		return (Employer)sessionFactory.getCurrentSession().get(Employer.class, id);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public List<Employer> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Employer").list();
	}

}
