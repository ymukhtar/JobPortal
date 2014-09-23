package com.mum.jobportal.Idao;

import java.util.List;

import com.mum.jobportal.domain.Employer;
import com.mum.jobportal.domain.JobSeeker;

public interface IJobSeekerDAO {
	public void create(JobSeeker jobSeeker);
	public void update(JobSeeker jobSeeker);
	public void delete(JobSeeker jobSeeker);
	public JobSeeker get(long id);
	public List<JobSeeker> getAll();
	public JobSeeker get(String userName);
}
