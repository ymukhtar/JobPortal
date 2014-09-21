package com.mum.jobportal.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IUserDAO;
import com.mum.jobportal.domain.Authorities;
import com.mum.jobportal.domain.User;
/**
 * 
 * @author yasirmukhtar
 *
 */

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class UserDAO implements IUserDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}
	public User get(long id) {
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
	}
	public List<User> getAll() {
		return sessionFactory.getCurrentSession().createQuery("From user").list();
	}
}
