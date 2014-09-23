package com.mum.jobportal.Idao;

import java.util.List;

import com.mum.jobportal.domain.Administrator;

public interface IAdministratorDAO {
	public void create(Administrator admininstrator);
	public void update(Administrator admininstrator);
	public void delete(Administrator admininstrator);
	public Administrator get(long id);
	public List<Administrator> getAll();
	public Administrator get(String userName);
}
