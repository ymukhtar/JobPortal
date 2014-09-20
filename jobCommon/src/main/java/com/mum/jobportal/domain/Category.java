package com.mum.jobportal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5597105244836235320L;
	@GeneratedValue
	@Id
	private long categoryId;
	@NotEmpty
	private String title;
	@NotEmpty
	private String description;
	@OneToMany(mappedBy="category")
	private List<Vaccancy> vaccancyList=new ArrayList<Vaccancy>();
	
	
	public Category() {
		super();
	}
	
	public Category(String title, String description) {
		super();
		
		this.title = title;
		this.description = description;
	}
	
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", title=" + title
				+ ", description=" + description + "]";
	}
	
	
}
