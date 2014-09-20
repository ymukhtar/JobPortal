package com.mum.jobportal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class JobSeeker extends Person {
	
	private String qualification;
	@Lob
	private String skills;
	@Lob
	private String experience;
	@Lob
	private byte[] resume;
	
}
