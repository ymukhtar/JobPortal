package com.mum.jobportal.utils;

import com.mum.jobportal.domain.Vaccancy;

public class VaccancyCount {
	private Vaccancy vacancy;
	private Long count;
	
	public VaccancyCount(Vaccancy vac,Long count){
		this.vacancy=vac;
		this.count=count;
	}

	public Vaccancy getVacancy() {
		return vacancy;
	}

	public void setVacancy(Vaccancy vacancy) {
		this.vacancy = vacancy;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
	
}
