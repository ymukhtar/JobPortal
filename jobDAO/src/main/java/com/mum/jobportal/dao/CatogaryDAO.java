/**
 * 
 */
package com.mum.jobportal.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.ICatogoryDAO;
import com.mum.jobportal.domain.Authorities;
import com.mum.jobportal.domain.Category;

/**
 * @author atariq
 *
 */
public class CatogaryDAO implements ICatogoryDAO {
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void create(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(category);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void update(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(category);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void delete(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(category);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public Category get(long id) {
		// TODO Auto-generated method stub
		return (Category)sessionFactory.getCurrentSession().get(Category.class, id);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Category").list();
	}

}
