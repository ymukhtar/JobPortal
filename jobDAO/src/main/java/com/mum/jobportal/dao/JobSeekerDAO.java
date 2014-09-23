package com.mum.jobportal.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IJobSeekerDAO;
import com.mum.jobportal.domain.Employer;
import com.mum.jobportal.domain.JobSeeker;
/**
 * 
 * @author yasirmukhtar
 *
 */
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class JobSeekerDAO extends AbstractJobPortalDAO implements IJobSeekerDAO{
	
	public void create(JobSeeker jobSeeker) {
		sessionFactory.getCurrentSession().persist(jobSeeker);
	}
	public void update(JobSeeker jobSeeker) {
		sessionFactory.getCurrentSession().update(jobSeeker);
	}
	public void delete(JobSeeker jobSeeker) {
		sessionFactory.getCurrentSession().delete(jobSeeker);
	}
	public JobSeeker get(long id) {
		return (JobSeeker)sessionFactory.getCurrentSession().get(JobSeeker.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<JobSeeker> getAll() {
		return sessionFactory.getCurrentSession().createQuery("From JobSeeker").list();
	}
	public JobSeeker get(String userName) {
		// TODO Auto-generated method stub
		Query query= sessionFactory.getCurrentSession().createQuery("From JobSeeker j where j.user.userName=:user");
		query.setParameter("user",userName);
		return (JobSeeker)query.uniqueResult();
	}
}
