package com.mum.jobportal.Idao;

import java.util.List;

import com.mum.jobportal.domain.Vaccancy;
import com.mum.jobportal.domain.VaccancyApplication;

public interface IVaccancyApplicationDAO {
	public void create(VaccancyApplication vaccancyApplication);
	public void update(VaccancyApplication vaccancy);
	public void delete(VaccancyApplication vaccancy);
	public VaccancyApplication get(long id);
	public List<VaccancyApplication> getAll();
	public List<VaccancyApplication> getAllVacancyByEmployer(long employerID);
}
