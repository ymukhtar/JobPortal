package com.mum.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IAuthoritiesDAO;
import com.mum.jobportal.Idao.ICatogoryDAO;
import com.mum.jobportal.Idao.IEmployerDAO;
import com.mum.jobportal.Idao.IJobSeekerDAO;
import com.mum.jobportal.Idao.IUserDAO;
import com.mum.jobportal.Idao.IVaccancyDAO;
import com.mum.jobportal.domain.Authorities;
import com.mum.jobportal.domain.Category;
import com.mum.jobportal.domain.Employer;
import com.mum.jobportal.domain.JobSeeker;
import com.mum.jobportal.domain.User;
import com.mum.jobportal.domain.Vaccancy;
@Service
public class JobPortalService implements IJobPortalService {

	@Autowired
	private IAuthoritiesDAO authoritiesDAO;
	@Autowired
	private ICatogoryDAO categoryDAO;
	@Autowired
	private IEmployerDAO employerDAO;
	@Autowired
	private IJobSeekerDAO jobSeekerDAO;
	@Autowired
	private IUserDAO userDAO;
	@Autowired
	private IVaccancyDAO vaccancyDAO;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createEmployer(Employer employer) {
		// TODO Auto-generated method stub
		employerDAO.create(employer);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateEmployer(Employer employer) {
		// TODO Auto-generated method stub
		employerDAO.update(employer);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteEmployer(Employer employer) {
		// TODO Auto-generated method stub
		employerDAO.delete(employer);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Employer getEmployer(long id) {
		// TODO Auto-generated method stub
		return employerDAO.get(id);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Employer> getAllEmployer() {
		// TODO Auto-generated method stub
		return employerDAO.getAll();
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createJobSeeker(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		jobSeekerDAO.create(jobSeeker);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateJobSeeker(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		jobSeekerDAO.update(jobSeeker);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteJobSeeker(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		jobSeekerDAO.delete(jobSeeker);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public JobSeeker getJobSeeker(long id) {
		// TODO Auto-generated method stub
		return jobSeekerDAO.get(id);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<JobSeeker> getAllJobSeeker() {
		// TODO Auto-generated method stub
		return jobSeekerDAO.getAll();
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDAO.create(category);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateJobSeeker(Category category) {
		// TODO Auto-generated method stub
		categoryDAO.update(category);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteJobSeeker(Category category) {
		// TODO Auto-generated method stub
		categoryDAO.delete(category);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Category getCategory(long id) {
		// TODO Auto-generated method stub
		return categoryDAO.get(id);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryDAO.getAll();
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userDAO.create(user);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateJobSeeker(User user) {
		// TODO Auto-generated method stub
		userDAO.update(user);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteJobSeeker(User user) {
		// TODO Auto-generated method stub
		userDAO.delete(user);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User getUser(long id) {
		// TODO Auto-generated method stub
		return userDAO.get(id);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDAO.getAll();
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createAuthorities(Authorities authorities) {
		// TODO Auto-generated method stub
		authoritiesDAO.create(authorities);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateJobSeeker(Authorities authorities) {
		// TODO Auto-generated method stub
		authoritiesDAO.update(authorities);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteJobSeeker(Authorities authorities) {
		// TODO Auto-generated method stub
		authoritiesDAO.delete(authorities);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Authorities getAuthorities(long id) {
		// TODO Auto-generated method stub
		return authoritiesDAO.get(id);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Authorities> getAllAuthorities() {
		// TODO Auto-generated method stub
		return authoritiesDAO.getAll();
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createVaccancy(Vaccancy vaccancy) {
		// TODO Auto-generated method stub
		vaccancyDAO.create(vaccancy);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateVaccancy(Vaccancy vaccancy) {
		// TODO Auto-generated method stub
		vaccancyDAO.update(vaccancy);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteVaccancy(Vaccancy vaccancy) {
		// TODO Auto-generated method stub
		vaccancyDAO.delete(vaccancy);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Vaccancy getVaccancy(long id) {
		// TODO Auto-generated method stub
		return vaccancyDAO.get(id);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Vaccancy> getAllVaccancy() {
		// TODO Auto-generated method stub
		return vaccancyDAO.getAll();
	}

}
