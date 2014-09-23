package com.mum.jobportal.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IVaccancyApplicationDAO;
import com.mum.jobportal.dao.AbstractJobPortalDAO;
import com.mum.jobportal.domain.VaccancyApplication;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class VaccancyAppliacationDAO extends AbstractJobPortalDAO implements IVaccancyApplicationDAO{

	public void create(VaccancyApplication vaccancyApplication) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(vaccancyApplication);
	}

	public void update(VaccancyApplication vaccancyApplication) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(vaccancyApplication);
	}

	public void delete(VaccancyApplication vaccancyApplication) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(vaccancyApplication);
	}

	public VaccancyApplication get(long id) {
		// TODO Auto-generated method stub
		return (VaccancyApplication)sessionFactory.getCurrentSession().get(VaccancyApplication.class, id);
	}

	public List<VaccancyApplication> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From VaccancyApplication").list();
	}

}
