package com.mum.jobportal.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IAuthoritiesDAO;
import com.mum.jobportal.domain.Authorities;

public class AuthoritiesDAO implements IAuthoritiesDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void create(Authorities authorities) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(authorities);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void update(Authorities authorities) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(authorities);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void delete(Authorities authorities) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(authorities);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public Authorities get(long id) {
		// TODO Auto-generated method stub
		return (Authorities)sessionFactory.getCurrentSession().get(Authorities.class, id);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public List<Authorities> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Authorities").list();
	}

}
