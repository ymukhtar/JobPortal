package com.mum.jobprotal.web.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Secured("ROLE_USER")
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String getAllBooks(Model model){
		//model.addAttribute("booksList", bookDao.getAll());
		return "home";
	}
	
}
