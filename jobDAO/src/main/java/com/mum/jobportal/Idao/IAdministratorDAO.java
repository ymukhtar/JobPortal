package com.mum.jobportal.Idao;

import com.mum.jobportal.domain.Administrator;

public interface IAdministratorDAO {
	public void create(Administrator admininstrator);
	public void update(Administrator admininstrator);
	public void delete(Administrator admininstrator);
	public void get(long id);
	public void getAll();
}
