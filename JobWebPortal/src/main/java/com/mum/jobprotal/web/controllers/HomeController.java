package com.mum.jobprotal.web.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.jobportal.domain.Category;
import com.mum.jobportal.service.IJobPortalService;
import com.mum.jobportal.utils.JobPortalAuthorities;

@Controller
public class HomeController {

	@Resource
	private IJobPortalService service;
	
	private static Logger logger=Logger.getLogger(HomeController.class); 
	@Secured(JobPortalAuthorities.ROLE_USER)
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String getHome(Model model,HttpServletRequest request){
		logger.info("ROLE_USER"+request.isUserInRole(JobPortalAuthorities.ROLE_ADMIN));
		if(request.isUserInRole(JobPortalAuthorities.ROLE_ADMIN)){
			return "adminHome";
		}
		return "home";
	}
	
	@Secured(JobPortalAuthorities.ROLE_ADMIN)
	@RequestMapping(value="/Categories",method=RequestMethod.GET)
	public String getCategories(Model model,HttpServletRequest request){
		List<Category> catList=service.getAllCategory();
		model.addAttribute("catList", catList);
		return "allCategories";
	}
}
