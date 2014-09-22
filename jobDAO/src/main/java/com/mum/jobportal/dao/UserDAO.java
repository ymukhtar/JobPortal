package com.mum.jobportal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IUserDAO;
import com.mum.jobportal.domain.User;
/**
 * 
 * @author yasirmukhtar
 *
 */

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class UserDAO extends AbstractJobPortalDAO implements IUserDAO{
	
	
	public void create(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}
	public User get(String userName) {
		return (User)sessionFactory.getCurrentSession().get(User.class, userName);
	}
	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return sessionFactory.getCurrentSession().createQuery("From user").list();
	}
}
