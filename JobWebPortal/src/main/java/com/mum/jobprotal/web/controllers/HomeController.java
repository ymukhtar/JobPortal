package com.mum.jobprotal.web.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

import com.mum.jobportal.domain.Category;
import com.mum.jobportal.domain.Employer;
import com.mum.jobportal.domain.Vaccancy;
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
		UserDetails userDetails =
				 (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.info("ROLE_USER"+request.isUserInRole(JobPortalAuthorities.ROLE_ADMIN));
		if(request.isUserInRole(JobPortalAuthorities.ROLE_ADMIN)){
			List<Category> catList=service.getAllCategory();
			model.addAttribute("catList", catList);
			model.addAttribute("category", new Category());
			return "adminHome";
		}
		else if(request.isUserInRole(JobPortalAuthorities.ROLE_JOB_SEEKER)){
			return "jobSeekerHome";
		}else if(request.isUserInRole(JobPortalAuthorities.ROLE_EMPLOYER)){
			Employer employer=service.getEmployer(userDetails.getUsername());
			request.getSession().setAttribute(Employer.class.getSimpleName(), employer);
			//model.addAttribute("vacancy_", new Vaccancy());
			model.addAttribute("vaccancyList", employer.getVaccancyList());
			return "employerHome";
		}
		return "home";
	}
	

	@Secured(JobPortalAuthorities.ROLE_EMPLOYER)
	@RequestMapping(value="/addVacancy",method=RequestMethod.GET)
	public String getVacancyAddPage(Model model,HttpServletRequest request){
		List<Category> catList=service.getAllCategory();
		model.addAttribute("catList", catList);
		model.addAttribute("vaccancy", new Vaccancy());
		return "addVacancyForm";
	}
	
	@Secured(JobPortalAuthorities.ROLE_EMPLOYER)
	@RequestMapping(value="/addVacancy",method=RequestMethod.POST)
	public String addVacancy(Model model,@Valid Vaccancy vaccancy,BindingResult result,RedirectAttributes redirectAttr,HttpServletRequest request)	{
		if(result.hasFieldErrors()){
			List<Category> catList=service.getAllCategory();
			model.addAttribute("catList", catList);
			return "addVacancyForm";
		}
		Employer employer=(Employer)request.getSession().getAttribute(Employer.class.getSimpleName());
		vaccancy.setEmployer(employer);
		service.createVaccancy(vaccancy);
		redirectAttr.addFlashAttribute("message", "Vacancy has been successfully created");
		return "redirect:/home";
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
