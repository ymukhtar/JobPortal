package com.mum.jobportal.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
/**
 * 
 * @author ymukhtar
 * @author aTariq
 *
 */
@Entity
public class Administrator extends Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8572681971127552401L;

	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userName")
	private User user;
	
	public Administrator(){
		
	}
	
	public Administrator(String firstName, String lastName, String phoneNumber,
			String emailAddress,User user){
		super(firstName,lastName,phoneNumber,emailAddress);
		this.user=user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
