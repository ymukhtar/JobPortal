package com.mum.jobprotal.web.controllers;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.jobportal.domain.Employer;
import com.mum.jobportal.service.IJobPortalService;

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
	public String registerEmployer(@Valid Employer employer,BindingResult result){
		if(result.hasFieldErrors()){
			return "registerEmployer";
		}else{
			jobPortalService.createEmployer(employer);
			System.out.println("Saving employer"+employer.toString());
		}
		return "redirect:/registerationSuccess";
	}
}
