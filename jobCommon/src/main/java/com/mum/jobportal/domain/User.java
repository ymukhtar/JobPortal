package com.mum.jobportal.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
/**
 * 
 * @author ymukhtar
 * @author aTariq
 *
 */
@Entity
public class User {
	@Id
	@Column(length=45)
	private String userName;
	@Column(length=45)
	@NotEmpty
	private String password;
	@OneToMany(mappedBy="user")
	private List<Authorities> authoritiesList=new ArrayList<Authorities>();
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
