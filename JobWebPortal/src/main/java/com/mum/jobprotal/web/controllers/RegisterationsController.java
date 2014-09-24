package com.mum.jobprotal.web.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.jobportal.domain.Authorities;
import com.mum.jobportal.domain.Employer;
import com.mum.jobportal.domain.JobSeeker;
import com.mum.jobportal.domain.User;
import com.mum.jobportal.domain.Vaccancy;
import com.mum.jobportal.domain.VaccancyApplication;
import com.mum.jobportal.service.IJobPortalService;
import com.mum.jobportal.service.SpringMailSender;
import com.mum.jobportal.utils.JobApplicationStatus;
import com.mum.jobportal.utils.JobPortalAuthorities;

@Controller
public class RegisterationsController {
	
	private static Logger logger=Logger.getLogger(RegisterationsController.class);
	@Resource
	private IJobPortalService jobPortalService;
	@Autowired 
	private SpringMailSender mailSender;
	
	@RequestMapping(value="/registerEmployer",method=RequestMethod.GET)
	public String getRegisterEmployerPage(Model model){
		logger.info("**** Request for Registeration received");
		model.addAttribute("employer",new Employer());
		return "registerEmployer";
	}
	
	@RequestMapping(value="/registerationSuccess",method=RequestMethod.GET)
	public String getRegisterationSuccess(Model model){
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
	@RequestMapping(value="/saveJobSeeker",method=RequestMethod.POST)
	public String registerJobSeeker(@Valid JobSeeker jobSeeker,BindingResult result,RedirectAttributes redirectAttr){
		User user=jobPortalService.getUser(jobSeeker.getUser().getUserName());
		if(user!=null){
			logger.info("User is not null");
			result.rejectValue("user.userName", "error.user.userName", "An account already exists for this UserName.");
		}
		if(result.hasFieldErrors()){
			return "registerJobSeeker";
		}else{
			//Add Authorities
			 user=jobSeeker.getUser();
			
			user.addAuthority(new Authorities(user,JobPortalAuthorities.ROLE_USER));
			user.addAuthority(new Authorities(user,JobPortalAuthorities.ROLE_JOB_SEEKER));
			jobPortalService.createJobSeeker(jobSeeker);
			mailSender.sendMail("Registered "+user.getUserName(), "Your account has been created.", new String[]{jobSeeker.getEmailAddress()});
			redirectAttr.addFlashAttribute("message", "JobSeeker has been successfully registered with userName:"+jobSeeker.getUser().getUserName());
		}
		return "redirect:/registerationSuccess";
	}
	
	@RequestMapping(value="/registerJobSeeker",method=RequestMethod.GET)
	public String regesterJobSeeker(Model model){
		model.addAttribute("jobSeeker",new JobSeeker());
		return "registerJobSeeker";
	}
	
	@RequestMapping(value="/apply/{id}",method=RequestMethod.GET)
	public String applyForJob(Model model,@PathVariable long id,RedirectAttributes redirectAttr){
		UserDetails userDetails =(UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Vaccancy vaccancy=jobPortalService.getVaccancy(id);
		JobSeeker jobSeeker=jobPortalService.get(userDetails.getUsername());
		
		VaccancyApplication application=new VaccancyApplication(vaccancy, jobSeeker, new Date(), JobApplicationStatus.RECIEVED);
		jobPortalService.create(application);
		
		redirectAttr.addFlashAttribute("message", "Your application for "+ vaccancy.getTitle()+" vaccancy sent to employer successfully");
		return "redirect:/applyJobSuccess";
	}
	
	@RequestMapping(value="/resume/{id}",method=RequestMethod.GET)
	public String viewApplicantsResume(Model model,@PathVariable long id,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttr){
		UserDetails userDetails =(UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		JobSeeker jobSeeker=jobPortalService.getJobSeeker(id);
		String path="";
		try {

			File file=new File(request.getServletContext().getRealPath("/resources/resume.doc"));
			writeBytesToFile(file, jobSeeker.getResume());
			path=file.getAbsolutePath();
            String filePathToBeServed = path;
                    File fileToDownload = new File(filePathToBeServed);
                    InputStream inputStream = new FileInputStream(fileToDownload);
                    response.setContentType("application/force-download");
                    response.setHeader("Content-Disposition", "attachment; filename=resume.doc"); 
                    IOUtils.copy(inputStream, response.getOutputStream());
                      response.flushBuffer();
			logger.info("file written at "+file.getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String fileURL = path;
	    
	    FileInputStream fileInputStream = null;
	    BufferedInputStream bufferedInputStream = null;

		return "";
	}
	public static void writeBytesToFile(File theFile, byte[] bytes) throws IOException {
		BufferedOutputStream bos = null;

		try {
			
			FileOutputStream fos = new FileOutputStream(theFile);
			bos = new BufferedOutputStream(fos); 
			bos.write(bytes);
			
		}finally {
			if(bos != null) {
				try  {
					//flush and close the BufferedOutputStream
					bos.flush();
					bos.close();
				} catch(Exception e){}
			}
		}
      }
	@RequestMapping(value="/applyJobSuccess",method=RequestMethod.GET)
	public String getJobApplySuccess(Model model){
		return "applyJobSuccess";
	}
}
