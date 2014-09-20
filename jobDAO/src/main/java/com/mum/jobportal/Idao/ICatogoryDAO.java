package com.mum.jobportal.Idao;

import java.util.List;

import com.mum.jobportal.domain.Category;

public interface ICatogoryDAO {
	public void create(Category category);
	public void update(Category category);
	public void delete(Category category);
	public Category get(long id);
	public List<Category> getAll();
}
