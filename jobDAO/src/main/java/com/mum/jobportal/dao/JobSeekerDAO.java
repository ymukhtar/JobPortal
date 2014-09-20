package com.mum.jobportal.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IJobSeekerDAO;
import com.mum.jobportal.domain.Authorities;
import com.mum.jobportal.domain.JobSeeker;

public class JobSeekerDAO implements IJobSeekerDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void create(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(jobSeeker);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void update(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(jobSeeker);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public void delete(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(jobSeeker);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public JobSeeker get(long id) {
		// TODO Auto-generated method stub
		return (JobSeeker)sessionFactory.getCurrentSession().get(JobSeeker.class, id);
	}
	@Transactional(propagation=Propagation.MANDATORY)
	public List<JobSeeker> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From JobSeeker").list();
	}

}
