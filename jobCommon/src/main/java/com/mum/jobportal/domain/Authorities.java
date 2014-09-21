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

}
