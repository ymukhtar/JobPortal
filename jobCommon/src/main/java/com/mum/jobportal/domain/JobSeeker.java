package com.mum.jobportal.domain;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
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
	@NotEmpty(message="Qualification should not bey empty!")
	private String qualification;
	@Lob
	@NotEmpty(message="skills should not bey empty!")
	private String skills;
	@Lob
	@NotEmpty(message="Experience should not bey empty!")
	private String experience;
	@Lob
	@NotEmpty(message="Upload resume!")
	private byte[] resume;
	@Transient
	private MultipartFile webFile;
	
	@OneToMany(mappedBy="seeker")
	private List<VaccancyApplication> applicationList=new ArrayList<VaccancyApplication>();
	
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	public JobSeeker() {
		super();
	}
	
	public JobSeeker(String firstName, String lastName, String phoneNumber,
			String emailAddress,String qualification, String skills, String experience,
			MultipartFile resume) {
		super(firstName,lastName,phoneNumber,emailAddress);
		this.qualification = qualification;
		this.skills = skills;
		this.experience = experience;
		this.webFile = webFile;
		try {
			setResume(webFile.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public MultipartFile getWebFile() {
		return webFile;
	}

	public void setWebFile(MultipartFile webFile) {
		this.webFile = webFile;
		try {
			setResume(webFile.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public byte[] getResume() {
		return resume;
	}

	public List<VaccancyApplication> getApplicationList() {
		return applicationList;
	}

	public void setApplicationList(List<VaccancyApplication> applicationList) {
		this.applicationList = applicationList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
