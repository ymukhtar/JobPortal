package com.mum.jobportal.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IUserDAO;
import com.mum.jobportal.domain.Authorities;
import com.mum.jobportal.domain.User;

public class UserDAO implements IUserDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(propagation=Propagation.MANDATORY)
	public void create(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(user);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void update(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(user);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void delete(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(user);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public User get(long id) {
		// TODO Auto-generated method stub
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From user").list();
	}

}
