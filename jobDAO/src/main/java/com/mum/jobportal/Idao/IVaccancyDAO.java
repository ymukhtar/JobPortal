package com.mum.jobportal.Idao;

import com.mum.jobportal.domain.Vaccancy;

public interface IVaccancyDAO {
	public void create(Vaccancy vaccancy);
	public void update(Vaccancy vaccancy);
	public void delete(Vaccancy vaccancy);
	public void get(long id);
	public void getAll();
}
