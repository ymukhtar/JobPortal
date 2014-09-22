package com.mum.jobportal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author ymukhtar
 * @author aTariq
 */
@Entity
public class Authorities {
	@Id
	@GeneratedValue
	private long user_role_id;
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	@Column(length = 45)
	private String role;
	
	
	
	public Authorities() {
		super();
	}
	public Authorities(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}
	public long getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(long user_role_id) {
		this.user_role_id = user_role_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Authorities [user_role_id=" + user_role_id + ", user=" + user
				+ ", role=" + role + "]";
	}
}
