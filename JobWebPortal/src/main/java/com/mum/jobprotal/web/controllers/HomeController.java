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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.jobportal.domain.Category;
import com.mum.jobportal.domain.Employer;
import com.mum.jobportal.domain.Vaccancy;
import com.mum.jobportal.domain.VaccancyApplication;
import com.mum.jobportal.service.IJobPortalService;
import com.mum.jobportal.utils.CommonUtility;
import com.mum.jobportal.utils.JobPortalAuthorities;
import com.mum.jobportal.utils.VaccancyCount;

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
			model.addAttribute("currentPage",1);
			return "jobSeekerHome";
		}else if(request.isUserInRole(JobPortalAuthorities.ROLE_EMPLOYER)){
			Employer employer=service.getEmployer(userDetails.getUsername());
			request.getSession().setAttribute(Employer.class.getSimpleName(), employer);
			List<VaccancyCount> vacanyCountList =service.getAllVacancyByEmployerAndCountApplications(employer.getId());
			//model.addAttribute("vacancy_", new Vaccancy());
			model.addAttribute("vaccancyList", vacanyCountList);
			return "employerHome";
		}
		return "home";
	}
	
	@RequestMapping(value="/JobSearch",method=RequestMethod.GET)
	public String getJobSeekerHome(Model model,HttpServletRequest request,@RequestParam("currentPage") int currentPage,@RequestParam("searchString") String searchString,@RequestParam("searchAddress") String searchAddress){
		
		long count=service.getPagedVaccanyListCount(searchString, searchAddress);
		int totalPages=(int)Math.ceil(1.0*count/CommonUtility.FETCH_SIZE);
		model.addAttribute("searchString", searchString);
		model.addAttribute("searchAddress", searchAddress);
		if(count==0){
			model.addAttribute("message", "No jobs found matching your criteria!");
		}else{
			model.addAttribute("count", count);
			int startIndex=(currentPage-1)*CommonUtility.FETCH_SIZE;
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("fetchSize", CommonUtility.FETCH_SIZE);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("message", "Total jobs found matching your criteria "+count);
			int fetchSize=(int)( (startIndex+CommonUtility.FETCH_SIZE)<count?CommonUtility.FETCH_SIZE:(count-startIndex));
			
			List<Vaccancy> vaccancyList=service.getPagedVaccanyList(startIndex, fetchSize, searchAddress, searchString);
			model.addAttribute("vaccancyList", vaccancyList);
		}
		
		return "jobSeekerHome";
	}
	
	@RequestMapping(value="/viewAllApplication",method=RequestMethod.GET)
	public String getAllApplications(Model model,@RequestParam("currentPage") int currentPage){
		
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		long count=service.getAllVacancyByJobSeekerCount(userDetails.getUsername());
		int totalPages=(int)Math.ceil(1.0*count/CommonUtility.FETCH_SIZE);
		if(count==0){
			model.addAttribute("message", "No jobs found matching your criteria!");
		}else{
			model.addAttribute("count", count);
			int startIndex=(currentPage-1)*CommonUtility.FETCH_SIZE;
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("fetchSize", CommonUtility.FETCH_SIZE);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("message", "Total application you applied for "+count);
			int fetchSize=(int)( (startIndex+CommonUtility.FETCH_SIZE)<count?CommonUtility.FETCH_SIZE:(count-startIndex));
			
			List<VaccancyApplication> vaccancyApplicationList=service.getAllVacancyByJobSeekerApplications(userDetails.getUsername());
			model.addAttribute("applicationList", vaccancyApplicationList);
		}
		
		return "alljobApplication";
	}
	
	
	@RequestMapping(value="/viewAllApplicationRecieved",method=RequestMethod.GET)
	public String getAllApplicationsRecieved(Model model,@RequestParam("currentPage") int currentPage){
		
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		long count=service.getAllVacancyByEmployerCount(userDetails.getUsername());
		int totalPages=(int)Math.ceil(1.0*count/CommonUtility.FETCH_SIZE);
		if(count==0){
			model.addAttribute("message", "No applications found!");
		}else{
			model.addAttribute("count", count);
			int startIndex=(currentPage-1)*CommonUtility.FETCH_SIZE;
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("fetchSize", CommonUtility.FETCH_SIZE);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("message", "Total applications received "+count);
			int fetchSize=(int)( (startIndex+CommonUtility.FETCH_SIZE)<count?CommonUtility.FETCH_SIZE:(count-startIndex));
			
			List<VaccancyApplication> vaccancyApplicationList=service.getAllVacancyByEmployerApplications(userDetails.getUsername(),startIndex,fetchSize);
			model.addAttribute("applicationList", vaccancyApplicationList);
		}
		
		return "alljobApplication";
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
