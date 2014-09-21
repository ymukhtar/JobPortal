package com.mum.jobprotal.web.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.jobportal.domain.Employer;

@Controller
public class RegisterationsController {
	
	@RequestMapping(value="/registerEmployer",method=RequestMethod.GET)
	public String getAllBooks(Model model){
		model.addAttribute("employer",new Employer());
		return "registerEmployer";
	}
	
	@RequestMapping(value="/registerEmployer",method=RequestMethod.POST)
	public String registerEmployer(@Valid Employer employer){
		
		return "redirect:/registerationSuccess";
	}
}
