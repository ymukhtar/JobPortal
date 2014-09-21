package com.mum.jobportal.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IAdministratorDAO;
import com.mum.jobportal.domain.Administrator;
import com.mum.jobportal.domain.Authorities;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class AdministratorDAO implements IAdministratorDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void create(Administrator adminstrator) {
		
		sessionFactory.getCurrentSession().persist(adminstrator);
	}
	public void update(Administrator adminstrator) {
		
		sessionFactory.getCurrentSession().update(adminstrator);
	}
	public void delete(Administrator adminstrator) {
		
		sessionFactory.getCurrentSession().delete(adminstrator);
	}
	public Administrator get(long id) {
		
		return (Administrator)sessionFactory.getCurrentSession().get(Administrator.class, id);
	}
	public List<Administrator> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("From Administrator").list();
	}

}
