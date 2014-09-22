package com.mum.jobportal.service;

import java.util.List;

import com.mum.jobportal.domain.Authorities;
import com.mum.jobportal.domain.Category;
import com.mum.jobportal.domain.Employer;
import com.mum.jobportal.domain.JobSeeker;
import com.mum.jobportal.domain.User;
import com.mum.jobportal.domain.Vaccancy;
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
	public List<Employer> getAllEmployer();
	
	public void createJobSeeker(JobSeeker jobSeeker);
	public void updateJobSeeker(JobSeeker jobSeeker);
	public void deleteJobSeeker(JobSeeker jobSeeker);
	public JobSeeker getJobSeeker(long id);
	public List<JobSeeker> getAllJobSeeker();
	
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
}
