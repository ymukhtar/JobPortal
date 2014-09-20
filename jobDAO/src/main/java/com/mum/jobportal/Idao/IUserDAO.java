package com.mum.jobportal.Idao;

import com.mum.jobportal.domain.User;

public interface IUserDAO {
	public void create(User user);
	public void update(User user);
	public void delete(User user);
	public void get(long id);
	public void getAll();
}
