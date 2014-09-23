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
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createEmployer(Employer employer) {
		employerDAO.create(employer);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateEmployer(Employer employer) {
		
		employerDAO.update(employer);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteEmployer(Employer employer) {
		
		employerDAO.delete(employer);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Employer getEmployer(long id) {
		
		return employerDAO.get(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Employer getEmployer(String userName) {
		
		return employerDAO.get(userName);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Employer> getAllEmployer() {
		
		return employerDAO.getAll();
	}
	
	//Administrator
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createAdministrator(Administrator admin) {
		administratorDAO.create(admin);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateAdministrator(Administrator admin) {
		administratorDAO.update(admin);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteAdministrator(Administrator admin) {
		
		administratorDAO.delete(admin);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Administrator getAdministrator(long id) {
		
		return administratorDAO.get(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Administrator getAdministrator(String userName) {
		
		return administratorDAO.get(userName);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Administrator> getAllAdministrators() {
		
		return administratorDAO.getAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createJobSeeker(JobSeeker jobSeeker) {
		
		jobSeekerDAO.create(jobSeeker);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateJobSeeker(JobSeeker jobSeeker) {
		
		jobSeekerDAO.update(jobSeeker);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteJobSeeker(JobSeeker jobSeeker) {
		
		jobSeekerDAO.delete(jobSeeker);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public JobSeeker getJobSeeker(long id) {
		
		return jobSeekerDAO.get(id);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<JobSeeker> getAllJobSeeker() {
		
		return jobSeekerDAO.getAll();
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public JobSeeker get(String userName){
		
		return jobSeekerDAO.get(userName);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createCategory(Category category) {
		
		categoryDAO.create(category);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateJobSeeker(Category category) {
		
		categoryDAO.update(category);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteJobSeeker(Category category) {
		
		categoryDAO.delete(category);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Category getCategory(long id) {
		
		return categoryDAO.get(id);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Category> getAllCategory() {
		
		return categoryDAO.getAll();
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createUser(User user) {
		
		userDAO.create(user);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateJobSeeker(User user) {
		
		userDAO.update(user);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteJobSeeker(User user) {
		
		userDAO.delete(user);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User getUser(String userName) {
		
		return userDAO.get(userName);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<User> getAllUser() {
		
		return userDAO.getAll();
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createAuthorities(Authorities authorities) {
		
		authoritiesDAO.create(authorities);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateJobSeeker(Authorities authorities) {
		
		authoritiesDAO.update(authorities);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteJobSeeker(Authorities authorities) {
		
		authoritiesDAO.delete(authorities);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Authorities getAuthorities(long id) {
		
		return authoritiesDAO.get(id);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Authorities> getAllAuthorities() {
		
		return authoritiesDAO.getAll();
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createVaccancy(Vaccancy vaccancy) {
		
		vaccancyDAO.create(vaccancy);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateVaccancy(Vaccancy vaccancy) {
		
		vaccancyDAO.update(vaccancy);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteVaccancy(Vaccancy vaccancy) {
		
		vaccancyDAO.delete(vaccancy);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Vaccancy getVaccancy(long id) {
		
		return vaccancyDAO.get(id);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Vaccancy> getAllVaccancy() {
		
		return vaccancyDAO.getAll();
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Vaccancy> getAllVaccancyByEmployer(long employerID) {
		
		return vaccancyDAO.getAllVacancyByEmployer(employerID);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public long getPagedVaccanyListCount(String searchCriteria, String addressSearch){
		return vaccancyDAO.getPagedVaccanyListCount(addressSearch, searchCriteria);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<Vaccancy> getPagedVaccanyList(int start,int fetchSize,String addressString,String criteriaString){
		return vaccancyDAO.getPagedVaccanyList(start, fetchSize, addressString, criteriaString);
	}

	public void create(VaccancyApplication vaccancyApplication) {
		// TODO Auto-generated method stub
		
	}

	public void update(VaccancyApplication vaccancy) {
		// TODO Auto-generated method stub
		
	}

	public void delete(VaccancyApplication vaccancy) {
		// TODO Auto-generated method stub
		
	}

	public VaccancyApplication get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<VaccancyApplication> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<VaccancyApplication> getAllVacancyByEmployer(long employerID) {
		// TODO Auto-generated method stub
		return null;
	}
}
