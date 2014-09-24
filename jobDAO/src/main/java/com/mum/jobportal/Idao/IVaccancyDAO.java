package com.mum.jobportal.Idao;

import java.util.List;

import com.mum.jobportal.domain.Vaccancy;
import com.mum.jobportal.domain.VaccancyApplication;
import com.mum.jobportal.utils.VaccancyCount;

public interface IVaccancyDAO {
	public void create(Vaccancy vaccancy);
	public void update(Vaccancy vaccancy);
	public void delete(Vaccancy vaccancy);
	public Vaccancy get(long id);
	public List<Vaccancy> getAll();
	public List<Vaccancy> getAllVacancyByEmployer(long employerID);
	public long getPagedVaccanyListCount(String addressString,String criteriaString);
	public List<Vaccancy> getPagedVaccanyList(int start,int fetchSize,String addressString,String criteriaString);
	public List<VaccancyCount> getAllVacancyByEmployerAndCountApplications(long employerID);
}
