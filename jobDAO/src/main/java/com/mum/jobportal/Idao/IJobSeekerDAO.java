package com.mum.jobportal.Idao;

import com.mum.jobportal.domain.JobSeeker;

public interface IJobSeekerDAO {
	public void create(JobSeeker jobSeeker);
	public void update(JobSeeker jobSeeker);
	public void delete(JobSeeker jobSeeker);
	public void get(long id);
	public void getAll();
}
