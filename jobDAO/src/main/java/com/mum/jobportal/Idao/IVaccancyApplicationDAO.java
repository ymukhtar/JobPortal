package com.mum.jobportal.Idao;

import java.util.List;

import com.mum.jobportal.domain.Vaccancy;
import com.mum.jobportal.domain.VaccancyApplication;
import com.mum.jobportal.utils.VaccancyCount;

public interface IVaccancyApplicationDAO {
	public void create(VaccancyApplication vaccancyApplication);
	public void update(VaccancyApplication vaccancyApplication);
	public void delete(VaccancyApplication vaccancyApplication);
	public VaccancyApplication get(long id);
	public List<VaccancyApplication> getAll();
	public List<VaccancyApplication> getAllVacancyByJobSeekerApplications(String username);
	public long getAllVacancyByJobSeekerCount(String username);
	public List<VaccancyApplication> getAllVacancyByEmployerApplications(String username);
	public long getAllVacancyByEmployerCount(String username);
}
