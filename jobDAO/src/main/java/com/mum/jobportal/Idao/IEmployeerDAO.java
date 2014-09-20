package com.mum.jobportal.Idao;

import com.mum.jobportal.domain.Employer;

public interface IEmployeerDAO {
	public void create(Employer employer);
	public void update(Employer employer);
	public void delete(Employer employer);
	public void get(long id);
	public void getAll();
}
