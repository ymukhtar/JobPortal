package com.mum.jobprotal.web.controllers;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.jobportal.domain.Authorities;
import com.mum.jobportal.domain.Employer;
import com.mum.jobportal.domain.User;
import com.mum.jobportal.service.IJobPortalService;
import com.mum.jobportal.utils.JobPortalAuthorities;

@Controller
public class RegisterationsController {
	
	private static Logger logger=Logger.getLogger(RegisterationsController.class);
	@Resource
	private IJobPortalService jobPortalService;
	
	@RequestMapping(value="/registerEmployer",method=RequestMethod.GET)
	public String getRegisterEmployerPage(Model model){
		logger.info("**** Request for Registeration received");
		model.addAttribute("employer",new Employer());
		return "registerEmployer";
	}
	
	@RequestMapping(value="/registerationSuccess",method=RequestMethod.GET)
	public String getRegisterationSuccess(Model model){
		model.addAttribute("employer",new Employer());
		return "registerationSuccess";
	}
	
	@RequestMapping(value="/registerEmployer",method=RequestMethod.POST)
	public String registerEmployer(@Valid Employer employer,BindingResult result,RedirectAttributes redirectAttr){
		//Check User name is already taken or not
		User user=jobPortalService.getUser(employer.getUser().getUserName());
		if(user!=null){
			logger.info("User is not null");
			result.rejectValue("user.userName", "error.user.userName", "An account already exists for this UserName.");
		}
		if(result.hasFieldErrors()){
			return "registerEmployer";
		}else{
			//Add Authorities
			 user=employer.getUser();
			
			user.addAuthority(new Authorities(user,JobPortalAuthorities.ROLE_USER));
			user.addAuthority(new Authorities(user,JobPortalAuthorities.ROLE_EMPLOYER));
			jobPortalService.createEmployer(employer);
			redirectAttr.addFlashAttribute("message", "Employer has been successfully registered with userName:"+employer.getUser().getUserName());
		}
		return "redirect:/registerationSuccess";
	}
}
