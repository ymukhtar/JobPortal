package com.mum.jobportal.service;

import java.util.List;

import com.mum.jobportal.domain.Administrator;
import com.mum.jobportal.domain.Authorities;
import com.mum.jobportal.domain.Category;
import com.mum.jobportal.domain.Employer;
import com.mum.jobportal.domain.JobSeeker;
import com.mum.jobportal.domain.User;
import com.mum.jobportal.domain.Vaccancy;
import com.mum.jobportal.domain.VaccancyApplication;
import com.mum.jobportal.utils.VaccancyCount;
/**
 * 
 * @author Awais Tariq
 *
 */

public interface IJobPortalService {
	
	public void createEmployer(Employer employer);
	public void updateEmployer(Employer employer);
	public void deleteEmployer(Employer employer);
	public Employer getEmployer(long id);
	public Employer getEmployer(String userName);
	public List<Employer> getAllEmployer();
	
	
	public void createAdministrator(Administrator admin);
	public void updateAdministrator(Administrator admin);
	public void deleteAdministrator(Administrator admin);
	public Administrator getAdministrator(long admin);
	public Administrator getAdministrator(String adminUser);
	public List<Administrator> getAllAdministrators();
	
	public void createJobSeeker(JobSeeker jobSeeker);
	public void updateJobSeeker(JobSeeker jobSeeker);
	public void deleteJobSeeker(JobSeeker jobSeeker);
	public JobSeeker getJobSeeker(long id);
	public List<JobSeeker> getAllJobSeeker();
	public JobSeeker get(String userName);
	
	public void createCategory(Category category);
	public void updateJobSeeker(Category category);
	public void deleteJobSeeker(Category category);
	public Category getCategory(long id);
	public List<Category> getAllCategory();
	
	public void createUser(User user);
	public void updateJobSeeker(User user);
	public void deleteJobSeeker(User user);
	public User getUser(String userName);
	public List<User> getAllUser();
	
	public void createAuthorities(Authorities authorities);
	public void updateJobSeeker(Authorities authorities);
	public void deleteJobSeeker(Authorities authorities);
	public Authorities getAuthorities(long id);
	public List<Authorities> getAllAuthorities();
	
	public void createVaccancy(Vaccancy vaccancy);
	public void updateVaccancy(Vaccancy vaccancy);
	public void deleteVaccancy(Vaccancy vaccancy);
	public Vaccancy getVaccancy(long id);
	public List<Vaccancy> getAllVaccancy();
	public List<Vaccancy> getAllVaccancyByEmployer(long employerID);
	public long getPagedVaccanyListCount(String searchCriteria, String addressSearch);
	public List<Vaccancy> getPagedVaccanyList(int start,int fetchSize,String addressString,String criteriaString);
	
	public void create(VaccancyApplication vaccancyApplication);
	public void update(VaccancyApplication vaccancy);
	public void delete(VaccancyApplication vaccancy);
	public VaccancyApplication get(long id);
	public List<VaccancyApplication> getAll();
	public List<VaccancyApplication> getAllVacancyByEmployer(long employerID);
	
	public List<VaccancyCount> getAllVacancyByEmployerAndCountApplications(long employerID);
	public List<VaccancyApplication> getAllVacancyByJobSeekerApplications(String username);
	public long getAllVacancyByJobSeekerCount(String username);
	
	public List<VaccancyApplication> getAllVacancyByEmployerApplications(String username);
	public long getAllVacancyByEmployerCount(String username);
	
}
