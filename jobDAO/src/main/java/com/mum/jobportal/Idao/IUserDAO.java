package com.mum.jobportal.Idao;

import java.util.List;

import com.mum.jobportal.domain.User;

public interface IUserDAO {
	public void create(User user);
	public void update(User user);
	public void delete(User user);
	public User get(long id);
	public List<User> getAll();
}
