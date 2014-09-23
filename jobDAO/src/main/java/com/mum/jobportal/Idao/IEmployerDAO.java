package com.mum.jobportal.Idao;

import java.util.List;

import com.mum.jobportal.domain.Employer;

public interface IEmployerDAO {
	public void create(Employer employer);
	public void update(Employer employer);
	public void delete(Employer employer);
	public Employer get(long id);
	public List<Employer> getAll();
	public Employer get(String userName);
}
