package com.mum.jobportal.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * @author ymukhtar
 * @author aTariq
 */
@Entity
public class VaccancyApplication implements Serializable{
	
	private static final long serialVersionUID = -8501735485513971863L;
	
	@GeneratedValue
	@Id
	private long applicationId;
	@ManyToOne
	@JoinColumn(name="vaccancy_id")
	private Vaccancy vaccancy;
	@ManyToOne
	@JoinColumn(name="seeker_id")
	private JobSeeker seeker;
	@Temporal(TemporalType.DATE)
	private Date applicationDate;
	/**
	 * <ul>
	 * <li>0- Applied</li>
	 * <li>1- Rejected</li>
	 * <li>2- ON_REVIEW</li>
	 * <li>3- SHORT_LISTED</li>
	 * <li>4- Approved</li>
	 * </ul> 
	 *
	 */
	private char status;
	
	
	public VaccancyApplication() {
		super();
	}
	public VaccancyApplication(Vaccancy vaccancy, JobSeeker seeker,
			Date applicationDate, char status) {
		super();
		this.vaccancy = vaccancy;
		this.seeker = seeker;
		this.applicationDate = applicationDate;
		this.status = status;
	}
	public long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}
	public Vaccancy getVaccancy() {
		return vaccancy;
	}
	public void setVaccancy(Vaccancy vaccancy) {
		this.vaccancy = vaccancy;
	}
	public JobSeeker getSeeker() {
		return seeker;
	}
	public void setSeeker(JobSeeker seeker) {
		this.seeker = seeker;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
}
