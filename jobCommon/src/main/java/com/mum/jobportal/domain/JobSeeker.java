package com.mum.jobportal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
/**
 * @author aTariq
 * @author ymukhtar
 *
 */
@Entity
public class JobSeeker extends Person  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6044910806884038568L;
	private String qualification;
	@Lob
	private String skills;
	@Lob
	private String experience;
	@Lob
	private byte[] resume;
	
	@OneToMany(mappedBy="seeker")
	private List<VaccancyApplication> applicationList=new ArrayList<VaccancyApplication>();
	
	@OneToOne
	private User user;
	
	public JobSeeker() {
		super();
	}
	
	public JobSeeker(String firstName, String lastName, String phoneNumber,
			String emailAddress,String qualification, String skills, String experience,
			byte[] resume) {
		super(firstName,lastName,phoneNumber,emailAddress);
		this.qualification = qualification;
		this.skills = skills;
		this.experience = experience;
		this.resume = resume;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public List<VaccancyApplication> getApplicationList() {
		return applicationList;
	}

	public void setApplicationList(List<VaccancyApplication> applicationList) {
		this.applicationList = applicationList;
	}
	
	
}
