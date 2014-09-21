package com.mum.jobportal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
/**
 * @author aTariq
 * @author ymukhtar
 *
 */
@Entity
public class Employer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8076493347374820087L;
	@GeneratedValue
	@Id
	private long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String description;
	@Embedded
	private Address address;
	@URL(message="WebSite URL is not valid!")
	private String website;
	@Pattern(regexp="^(\\([0-9]{3}\\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$",message="Phone Number is invalid")
	private String phoneNumber;

	@OneToMany(mappedBy="employer",cascade=CascadeType.ALL)
	List<Vaccancy> vaccancyList=new ArrayList<Vaccancy>();
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userName")
	private User user;
	
	public Employer() {
		super();
	}

	public Employer( String name, String description, Address address,
			String website, String phoneNumber) {
		super();
		this.name = name;
		this.description = description;
		this.address = address;
		this.website = website;
		this.phoneNumber = phoneNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	public List<Vaccancy> getVaccancyList() {
		return vaccancyList;
	}

	public void setVaccancyList(List<Vaccancy> vaccancyList) {
		this.vaccancyList = vaccancyList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", name=" + name + ", description="
				+ description + ", address=" + address + ", website=" + website
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
}
