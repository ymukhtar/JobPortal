package com.mum.jobportal.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IEmployerDAO;
import com.mum.jobportal.domain.Employer;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class EmployerDAO extends AbstractJobPortalDAO implements IEmployerDAO{
	
	public void create(Employer employer) {
		sessionFactory.getCurrentSession().persist(employer);
	}
	public void update(Employer employer) {
		sessionFactory.getCurrentSession().update(employer);
	}
	public void delete(Employer employer) {
		sessionFactory.getCurrentSession().delete(employer);
	}
	public Employer get(long id) {
		return (Employer)sessionFactory.getCurrentSession().get(Employer.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Employer> getAll() {
		return sessionFactory.getCurrentSession().createQuery("From Employer").list();
	}
	public Employer get(String userName) {
		Query query= sessionFactory.getCurrentSession().createQuery("From Employer e where e.user.userName=:user");
		query.setParameter("user",userName);
		return (Employer)query.uniqueResult();
	}
}
