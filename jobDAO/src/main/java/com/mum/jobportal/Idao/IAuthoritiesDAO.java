package com.mum.jobportal.Idao;

import com.mum.jobportal.domain.Authorities;

public interface IAuthoritiesDAO {
	public void create(Authorities authorities);
	public void update(Authorities authorities);
	public void delete(Authorities authorities);
	public void get(long id);
	public void getAll();
}
