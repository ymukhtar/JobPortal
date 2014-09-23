package com.mum.jobportal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IVaccancyDAO;
import com.mum.jobportal.domain.Address;
import com.mum.jobportal.domain.Category;
import com.mum.jobportal.domain.Vaccancy;
import com.mum.jobportal.utils.VaccancyCount;
/**
 * 
 * @author yasirmukhtar
 *
 */

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class VaccancyDAO extends AbstractJobPortalDAO implements IVaccancyDAO{
	
	public void create(Vaccancy vaccancy) {
		sessionFactory.getCurrentSession().persist(vaccancy);
	}
	public void update(Vaccancy vaccancy) {
		sessionFactory.getCurrentSession().update(vaccancy);
	}
	public void delete(Vaccancy vaccancy) {
		sessionFactory.getCurrentSession().delete(vaccancy);
	}
	public Vaccancy get(long id) {
		return (Vaccancy)sessionFactory.getCurrentSession().get(Vaccancy.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Vaccancy> getAll() {
		Query query=sessionFactory.getCurrentSession().createQuery("From Vaccancy");
		return query.list();
	}
	@SuppressWarnings("unchecked")
	public List<Vaccancy> getPagedVaccanyList(int start,int fetchSize,String addressString,String criteriaString) {
		
		String q="From Vaccancy v where 1=1";
		if(addressString!=null && addressString.length()>0)
		{
			q+=" AND v.address.city like :vAdd or v.address.state like :vState or v.address.zip=:vzip";
			
		}
		if(criteriaString!=null && criteriaString.length()>0)
		{
			q+=" AND v.employer.name like :vEmp or v.title like :cTitle or v.description like :vDesc";
		}
		Query query=sessionFactory.getCurrentSession().createQuery(q);
		
		if(addressString!=null && addressString.length()>0){
			query.setParameter("vAdd", "%"+addressString+"%");
			query.setParameter("vState", "%"+addressString+"%");
			query.setParameter("vzip", addressString);
		}
		if(criteriaString!=null && criteriaString.length()>0){
			query.setParameter("vEmp", "%"+criteriaString+"%");
			query.setParameter("cTitle", "%"+criteriaString+"%");
			query.setParameter("vDesc", "%"+criteriaString+"%");
		}
		
		query.setFirstResult(start);
		query.setMaxResults(fetchSize);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	public List<Vaccancy> getAllVacancyByEmployer(long employerID) {
		Query query=sessionFactory.getCurrentSession().createQuery(" From Vaccancy v where v.employer.id=:empID");
		query.setLong("empID", employerID);
		return query.list();
	}
	
	/*
	 * SELECT v.*,count(a.applicationId) 
FROM jobportal.vaccancy v 
left outer join jobportal.vaccancyapplication a on v.id=a.vaccancy_id
group by v.id;
	 * */
	@SuppressWarnings("unchecked")
	public List<VaccancyCount> getAllVacancyByEmployerAndCountApplications(long employerID) {
		Query query=sessionFactory.getCurrentSession().createQuery("Select new com.mum.jobportal.utils.VaccancyCount(v,COUNT(app.applicationId)) From Vaccancy v LEFT OUTER JOIN v.applicationList app  where v.employer.id=:empID group by v.id");
		query.setLong("empID", employerID);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public long getPagedVaccanyListCount(String addressString,String criteriaString) {
		
		String q="select count(v.id) From Vaccancy v where 1=1 ";
		if(addressString!=null && addressString.length()>0)
		{
			q+=" AND v.address.city like :vAdd or v.address.state like :vState or v.address.zip=:vzip";
			
		}
		if(criteriaString!=null && criteriaString.length()>0)
		{
			q+=" AND v.employer.name like :vEmp or v.title like :cTitle or v.description like :vDesc";
		}
		Query query=sessionFactory.getCurrentSession().createQuery(q);
		
		if(addressString!=null && addressString.length()>0){
			query.setParameter("vAdd", "%"+addressString+"%");
			query.setParameter("vState", "%"+addressString+"%");
			query.setParameter("vzip", addressString);
		}
		if(criteriaString!=null && criteriaString.length()>0){
			query.setParameter("vEmp", "%"+criteriaString+"%");
			query.setParameter("cTitle", "%"+criteriaString+"%");
			query.setParameter("vDesc", "%"+criteriaString+"%");
		}
	
		return (Long) query.uniqueResult();
	}
}
