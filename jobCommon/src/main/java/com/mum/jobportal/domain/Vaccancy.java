package com.mum.jobportal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotEmpty;
/**
 * 
 * @author ymukhtar
 * @author aTariq
 *
 */
@Entity
public class Vaccancy implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6660474875241017683L;
	@GeneratedValue
	@Id
	private long id;
	@NotEmpty
	private String title;
	@Lob
	@NotEmpty
	private String description;
	@NotEmpty
	private String location;
	
	private String salaryRange;
	@Temporal(TemporalType.DATE)
	private Date vaccancyCreationDate;
	@Temporal(TemporalType.DATE)
	private Date vaccnayExpiryDate;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;

	@OneToMany(mappedBy="vaccancy")
	private List<VaccancyApplication> applicationList=new ArrayList<VaccancyApplication>();
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	
	public Vaccancy(String title, String description, String location,
			String salaryRange, Date vaccancyCreationDate,
			Date vaccnayExpiryDate) {
		super();
		this.title = title;
		this.description = description;
		this.location = location;
		this.salaryRange = salaryRange;
		this.vaccancyCreationDate = vaccancyCreationDate;
		this.vaccnayExpiryDate = vaccnayExpiryDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSalaryRange() {
		return salaryRange;
	}

	public void setSalaryRange(String salaryRange) {
		this.salaryRange = salaryRange;
	}

	public Date getVaccancyCreationDate() {
		return vaccancyCreationDate;
	}

	public void setVaccancyCreationDate(Date vaccancyCreationDate) {
		this.vaccancyCreationDate = vaccancyCreationDate;
	}

	public Date getVaccnayExpiryDate() {
		return vaccnayExpiryDate;
	}

	public void setVaccnayExpiryDate(Date vaccnayExpiryDate) {
		this.vaccnayExpiryDate = vaccnayExpiryDate;
	}

	public List<VaccancyApplication> getApplicationList() {
		return applicationList;
	}

	public void setApplicationList(List<VaccancyApplication> applicationList) {
		this.applicationList = applicationList;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
