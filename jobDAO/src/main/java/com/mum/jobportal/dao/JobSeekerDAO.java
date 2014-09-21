package com.mum.jobportal.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IJobSeekerDAO;
import com.mum.jobportal.domain.JobSeeker;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class JobSeekerDAO implements IJobSeekerDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
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
	public List<JobSeeker> getAll() {
		return sessionFactory.getCurrentSession().createQuery("From JobSeeker").list();
	}
}
