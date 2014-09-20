package com.mum.jobportal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * 
 * @author yasirmukhtar
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8270340077867540975L;
	
	@GeneratedValue
	@Id
	private long personId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	
	public Person(){
		
	}
	public Person(String firstName, String lastName, String phoneNumber,
			String emailAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", emailAddress="
				+ emailAddress + "]";
	}
	
	
	
}
