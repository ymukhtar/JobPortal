package com.mum.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IAdministratorDAO;
import com.mum.jobportal.Idao.IAuthoritiesDAO;
import com.mum.jobportal.Idao.ICatogoryDAO;
import com.mum.jobportal.Idao.IEmployerDAO;
import com.mum.jobportal.Idao.IJobSeekerDAO;
import com.mum.jobportal.Idao.IUserDAO;
import com.mum.jobportal.Idao.IVaccancyApplicationDAO;
import com.mum.jobportal.Idao.IVaccancyDAO;
import com.mum.jobportal.domain.Administrator;
import com.mum.jobportal.domain.Authorities;
import com.mum.jobportal.domain.Category;
import com.mum.jobportal.domain.Employer;
import com.mum.jobportal.domain.JobSeeker;
import com.mum.jobportal.domain.User;
import com.mum.jobportal.domain.Vaccancy;
import com.mum.jobportal.domain.VaccancyApplication;

/**
 * @author awais-tariq
 * @author ymukhtar
 *
 */
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
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
	@Autowired
	private IAdministratorDAO administratorDAO;
	@Autowired
	private IVaccancyApplicationDAO vaccancyApplicationDAO;
	

	public void createEmployer(Employer employer) {
		employerDAO.create(employer);
	}


	public void updateEmployer(Employer employer) {
		
		employerDAO.update(employer);
	}


	public void deleteEmployer(Employer employer) {
		
		employerDAO.delete(employer);
	}


	public Employer getEmployer(long id) {
		
		return employerDAO.get(id);
	}
	

	public Employer getEmployer(String userName) {
		
		return employerDAO.get(userName);
	}
	

	public List<Employer> getAllEmployer() {
		
		return employerDAO.getAll();
	}
	
	//Administrator

	public void createAdministrator(Administrator admin) {
		administratorDAO.create(admin);
	}


	public void updateAdministrator(Administrator admin) {
		administratorDAO.update(admin);
	}


	public void deleteAdministrator(Administrator admin) {
		
		administratorDAO.delete(admin);
	}


	public Administrator getAdministrator(long id) {
		
		return administratorDAO.get(id);
	}
	

	public Administrator getAdministrator(String userName) {
		
		return administratorDAO.get(userName);
	}
	

	public List<Administrator> getAllAdministrators() {
		
		return administratorDAO.getAll();
	}
	

	public void createJobSeeker(JobSeeker jobSeeker) {
		
		jobSeekerDAO.create(jobSeeker);
	}

	public void updateJobSeeker(JobSeeker jobSeeker) {
		
		jobSeekerDAO.update(jobSeeker);
	}

	public void deleteJobSeeker(JobSeeker jobSeeker) {
		
		jobSeekerDAO.delete(jobSeeker);
	}

	public JobSeeker getJobSeeker(long id) {
		
		return jobSeekerDAO.get(id);
	}

	public List<JobSeeker> getAllJobSeeker() {
		
		return jobSeekerDAO.getAll();
	}

	public JobSeeker get(String userName){
		
		return jobSeekerDAO.get(userName);
	}

	public void createCategory(Category category) {
		
		categoryDAO.create(category);
	}

	public void updateJobSeeker(Category category) {
		
		categoryDAO.update(category);
	}

	public void deleteJobSeeker(Category category) {
		
		categoryDAO.delete(category);
	}

	public Category getCategory(long id) {
		
		return categoryDAO.get(id);
	}

	public List<Category> getAllCategory() {
		
		return categoryDAO.getAll();
	}

	public void createUser(User user) {
		
		userDAO.create(user);
	}

	public void updateJobSeeker(User user) {
		
		userDAO.update(user);
	}

	public void deleteJobSeeker(User user) {
		
		userDAO.delete(user);
	}

	public User getUser(String userName) {
		
		return userDAO.get(userName);
	}

	public List<User> getAllUser() {
		
		return userDAO.getAll();
	}

	public void createAuthorities(Authorities authorities) {
		
		authoritiesDAO.create(authorities);
	}

	public void updateJobSeeker(Authorities authorities) {
		
		authoritiesDAO.update(authorities);
	}

	public void deleteJobSeeker(Authorities authorities) {
		
		authoritiesDAO.delete(authorities);
	}

	public Authorities getAuthorities(long id) {
		
		return authoritiesDAO.get(id);
	}

	public List<Authorities> getAllAuthorities() {
		
		return authoritiesDAO.getAll();
	}

	public void createVaccancy(Vaccancy vaccancy) {
		
		vaccancyDAO.create(vaccancy);
	}

	public void updateVaccancy(Vaccancy vaccancy) {
		
		vaccancyDAO.update(vaccancy);
	}

	public void deleteVaccancy(Vaccancy vaccancy) {
		
		vaccancyDAO.delete(vaccancy);
	}

	public Vaccancy getVaccancy(long id) {
		
		return vaccancyDAO.get(id);
	}

	public List<Vaccancy> getAllVaccancy() {
		
		return vaccancyDAO.getAll();
	}


	public List<Vaccancy> getAllVaccancyByEmployer(long employerID) {
		
		return vaccancyDAO.getAllVacancyByEmployer(employerID);
	}
	

	public long getPagedVaccanyListCount(String searchCriteria, String addressSearch){
		return vaccancyDAO.getPagedVaccanyListCount(addressSearch, searchCriteria);
	}
	

	public List<Vaccancy> getPagedVaccanyList(int start,int fetchSize,String addressString,String criteriaString){
		return vaccancyDAO.getPagedVaccanyList(start, fetchSize, addressString, criteriaString);
	}

	public void create(VaccancyApplication vaccancyApplication) {
		// TODO Auto-generated method stub
		vaccancyApplicationDAO.create(vaccancyApplication);
	}

	public void update(VaccancyApplication vaccancyApplication) {
		// TODO Auto-generated method stub
		vaccancyApplicationDAO.update(vaccancyApplication);
	}

	public void delete(VaccancyApplication vaccancyApplication) {
		// TODO Auto-generated method stub
		vaccancyApplicationDAO.delete(vaccancyApplication);
	}

	public VaccancyApplication get(long id) {
		// TODO Auto-generated method stub
		return vaccancyApplicationDAO.get(id);
	}

	public List<VaccancyApplication> getAll() {
		// TODO Auto-generated method stub
		return vaccancyApplicationDAO.getAll();
	}
}
