package com.mum.jobprotal.web.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.jobportal.domain.Authorities;
import com.mum.jobportal.domain.Category;
import com.mum.jobportal.domain.Employer;
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
			List<Category> catList=service.getAllCategory();
			model.addAttribute("catList", catList);
			model.addAttribute("category", new Category());
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
	@Secured(JobPortalAuthorities.ROLE_ADMIN)
	@RequestMapping(value="/saveCategory",method=RequestMethod.POST)
	public String saveCategories(Model model,@Valid Category category,BindingResult result){

		if(result.hasFieldErrors()){
			model.addAttribute("catList", service.getAllCategory());
			return "adminHome";
		}else{
			//Add categories
			service.createCategory(category);
		}
		return "redirect:/home";
	}
}
