package com.mum.jobportal.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	@NotEmpty(message="User Name must be specified.")
	private String userName;
	@Column(length=45)
	@NotEmpty
	private String password;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Authorities> authoritiesList=new ArrayList<Authorities>();
	
	private short enabled;
	
	public User(){
		enabled=1;
	}
	
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		enabled=1;
	}


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
	public List<Authorities> getAuthoritiesList() {
		return authoritiesList;
	}
	public void setAuthoritiesList(List<Authorities> authoritiesList) {
		this.authoritiesList = authoritiesList;
	}
	public short getEnabled() {
		return enabled;
	}
	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}
	
	public void addAuthority(Authorities authority){
		this.authoritiesList.add(authority);
	}
	
}
