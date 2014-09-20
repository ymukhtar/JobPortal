package com.mum.jobportal.Idao;

import java.util.List;

import com.mum.jobportal.domain.Authorities;

public interface IAuthoritiesDAO {
	public void create(Authorities authorities);
	public void update(Authorities authorities);
	public void delete(Authorities authorities);
	public Authorities get(long id);
	public List<Authorities> getAll();
}
