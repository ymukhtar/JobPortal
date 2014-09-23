package com.mum.jobprotal.web.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mum.jobportal.domain.Address;
import com.mum.jobportal.domain.Administrator;
import com.mum.jobportal.domain.Authorities;
import com.mum.jobportal.domain.Category;
import com.mum.jobportal.domain.Employer;
import com.mum.jobportal.domain.User;
import com.mum.jobportal.domain.Vaccancy;
import com.mum.jobportal.service.IJobPortalService;
import com.mum.jobportal.utils.JobPortalAuthorities;

@Controller
public class TestDataInserter {

	private static Logger logger=Logger.getLogger(TestDataInserter.class);
	@Autowired
	IJobPortalService jobPortalService;
	
//	@PostConstruct
	public void init() throws ParseException{
		
		logger.info("------------------Creating admin user------------------");
		User user=new User("admin","admin");
		
		List<Authorities> authList=new ArrayList<Authorities>();
		
		authList.add(new Authorities(user, JobPortalAuthorities.ROLE_USER));
		authList.add(new Authorities(user, JobPortalAuthorities.ROLE_ADMIN));
		
		Administrator administrator=new Administrator("admin","admin","570-362-6627","yasir1@gmail.com",user);
		jobPortalService.createAdministrator(administrator);
		
		logger.info("----------------creating moi employer----------------");
		Employer employer=new Employer("MOI", "PUBLIC Services", new Address("Street 2000","Fairfield","IA","52556"), "http://www.moi.gov", "570-362-6627");
		
		user=new User("moi","moi");
		
		authList=new ArrayList<Authorities>();
		
		authList.add(new Authorities(user, JobPortalAuthorities.ROLE_USER));
		authList.add(new Authorities(user, JobPortalAuthorities.ROLE_EMPLOYER));
		employer.setUser(user);
		jobPortalService.createEmployer(employer);
		logger.info("------------------------Creating categories-----------------");
		
		Category category=new Category("IT Engineer", "IT Engineer");
		jobPortalService.createCategory(category);
		
		for(int i=0;i<5;i++){
			jobPortalService.createCategory(new Category("Java Developer"+i," Java Development Resp"));
			
		}

		logger.info("------------------------Creating vacancies-----------------");
		List<Category> catList=jobPortalService.getAllCategory();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		Date expiry=sdf.parse("01/01/2016");
		Address add=new Address( "2000 N Court Street","Fairfield","IA","52556");
		Vaccancy vaccancy=null;
		Category cat=null;
		for(int i=0;i<100;i++){
			int r=(int)(Math.random()*(catList.size()-1));
			cat=catList.get(r);
			vaccancy=new Vaccancy(cat.getTitle(), cat.getDescription(),add, "8000-50000",expiry , employer, cat);
			jobPortalService.createVaccancy(vaccancy);
		}
		
		logger.info("Generated Test Data");
		
	}
}
