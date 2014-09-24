package com.mum.jobportal.dao;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IVaccancyApplicationDAO;
import com.mum.jobportal.dao.AbstractJobPortalDAO;
import com.mum.jobportal.domain.JobSeeker;
import com.mum.jobportal.domain.Vaccancy;
import com.mum.jobportal.domain.VaccancyApplication;
import com.mum.jobportal.utils.VaccancyCount;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class VaccancyAppliacationDAO extends AbstractJobPortalDAO implements IVaccancyApplicationDAO{

	public void create(VaccancyApplication vaccancyApplication) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(vaccancyApplication);
	}

	public void update(VaccancyApplication vaccancyApplication) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(vaccancyApplication);
	}

	public void delete(VaccancyApplication vaccancyApplication) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(vaccancyApplication);
	}

	public VaccancyApplication get(long id) {
		// TODO Auto-generated method stub
		return (VaccancyApplication)sessionFactory.getCurrentSession().get(VaccancyApplication.class, id);
	}

	public List<VaccancyApplication> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From VaccancyApplication").list();
	}

	public List<VaccancyApplication> getAllVacancyByJobSeekerApplications(String username) {
		Query query=sessionFactory.getCurrentSession().createQuery("from JobSeeker  j where j.user.userName=:u");
		query.setParameter("u", username);
		JobSeeker seeker=(JobSeeker) query.uniqueResult();
		return seeker.getApplicationList();
	}
	
	public long getAllVacancyByJobSeekerCount(String username) {
		Query query=sessionFactory.getCurrentSession().createQuery("select count(j.id) from JobSeeker j where j.user.userName=:u");
		query.setParameter("u", username);
		return (Long) query.uniqueResult();
	}

	public List<VaccancyApplication> getAllVacancyByEmployerApplications(
			String username) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery("select v.applicationList from Vaccancy v where v.employer.user.userName=:u");
		query.setParameter("u", username);
		return query.list();
	}

	public long getAllVacancyByEmployerCount(String username) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery("select count(v.applicationList) from Vaccancy v where v.employer.user.userName=:u");
		query.setParameter("u", username);
		return (Long) query.uniqueResult();
	}
	

}
