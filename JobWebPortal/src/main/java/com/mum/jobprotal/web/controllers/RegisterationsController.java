package com.mum.jobprotal.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterationsController {
	
	@RequestMapping(value="/registerEmployer",method=RequestMethod.GET)
	public String getAllBooks(Model model){
		//model.addAttribute("booksList", bookDao.getAll());
		return "registerEmployer";
	}
}
