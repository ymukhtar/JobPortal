package com.mum.jobportal.Idao;

import com.mum.jobportal.domain.Category;

public interface ICatogoryDAO {
	public void create(Category category);
	public void update(Category category);
	public void delete(Category category);
	public void get(long id);
	public void getAll();
}
