/**
 * 
 */
package com.mum.jobportal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.ICatogoryDAO;
import com.mum.jobportal.domain.Category;

/**
 * @author atariq
 * @author yasirmukhtar
 *
 */

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class CatogaryDAO extends AbstractJobPortalDAO implements ICatogoryDAO {
	public void create(Category category) {
		sessionFactory.getCurrentSession().save(category);
	}
	public void update(Category category) {
		sessionFactory.getCurrentSession().update(category);
	}
	public void delete(Category category) {
		sessionFactory.getCurrentSession().delete(category);
	}
	public Category get(long id) {
		return (Category)sessionFactory.getCurrentSession().get(Category.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Category> getAll() {
		return sessionFactory.getCurrentSession().createQuery("From Category").list();
	}
}
