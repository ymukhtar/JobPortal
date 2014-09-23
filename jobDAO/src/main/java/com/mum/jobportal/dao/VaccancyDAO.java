package com.mum.jobportal.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IVaccancyDAO;
import com.mum.jobportal.domain.Vaccancy;
/**
 * 
 * @author yasirmukhtar
 *
 */

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class VaccancyDAO extends AbstractJobPortalDAO implements IVaccancyDAO{
	
	public void create(Vaccancy vaccancy) {
		sessionFactory.getCurrentSession().persist(vaccancy);
	}
	public void update(Vaccancy vaccancy) {
		sessionFactory.getCurrentSession().update(vaccancy);
	}
	public void delete(Vaccancy vaccancy) {
		sessionFactory.getCurrentSession().delete(vaccancy);
	}
	public Vaccancy get(long id) {
		return (Vaccancy)sessionFactory.getCurrentSession().get(Vaccancy.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Vaccancy> getAll() {
		return sessionFactory.getCurrentSession().createQuery("From Vaccancy").list();
	}
	@SuppressWarnings("unchecked")
	public List<Vaccancy> getAllVacancyByEmployer(long employerID) {
		Query query=sessionFactory.getCurrentSession().createQuery("From Vaccancy v where v.employer.id=:empID");
		query.setLong("empID", employerID);
		return query.list();
	}
}
