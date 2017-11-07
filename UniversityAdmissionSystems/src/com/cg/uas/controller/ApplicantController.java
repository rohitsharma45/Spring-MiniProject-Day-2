package com.cg.uas.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.uas.bean.ApplicantBean;
import com.cg.uas.bean.LoginBean;
import com.cg.uas.service.IUasService;

@Controller
public class ApplicantController {

	@Autowired
	IUasService service;
	
	@RequestMapping("/index")
	public String front(){
		
		return "frontPage";
	}
	
	@RequestMapping("/frontPage")
	public ModelAndView start(){
	
	List<String> uniList=service.retrieveUniversity();
	
	return new ModelAndView ("homepage","list",uniList);
	}
@RequestMapping("/offered")
public ModelAndView selectPgm(@RequestParam("universityName")String universityName,HttpServletRequest request){

	List<String> pgmList=service.retrieveProgram(universityName);
	HttpSession session = request.getSession();
	session.setAttribute("uniName", universityName);
	
	return new ModelAndView("programList","list",pgmList);
}
@RequestMapping("/courseSelected")
public String selectCourse(@RequestParam("programName")String programName,Model model, HttpServletRequest request){
	String programId=service.retreiveProgramId(programName);
	
	
	HttpSession session = request.getSession(false);
	session.setAttribute("pgmId", programId);
	
	model.addAttribute("bean",new ApplicantBean());
return "form";
}

@RequestMapping("/register")
public String registerForm(@ModelAttribute("bean") @Valid ApplicantBean application,BindingResult br,Model model, HttpServletRequest request ){
	if(br.hasErrors()){
		
		return "form";
		}
		else{
			HttpSession session = request.getSession(false);
			String progamId = session.getAttribute("pgmId").toString();
			String university=session.getAttribute("uniName").toString();
			application.setProgramId(progamId);
			application.setStatus("Applied");
			application.setInterviewDate(null);
			application.setUniversity(university);
		int id=service.addDetails(application);
		model.addAttribute("appId",id);
		return "success";
	}
}
		@RequestMapping("/checkStatus")
		public String checkStat(Model model){
			
			model.addAttribute("appId",new ApplicantBean());
			return "status";
		}
		
		@RequestMapping("/statusCheck")
		public String statcheck(@RequestParam("applicationId")int applicationId,Model model){
			
			String statusCheck=null;
			
				try{
				 statusCheck=service.retrieveStatus(applicationId);
				System.out.println(statusCheck);
				}catch(Exception e){
				if(statusCheck==null){
					model.addAttribute("appId",applicationId);
					return "error";
				}}
				
				model.addAttribute("successStatus",statusCheck);
				return "successStatus";		
		} 
			
		@RequestMapping("/login")
		public String login(Model model){
			
			model.addAttribute("login",new LoginBean());
			return "successLogin";
		}
		
		}
		
			
	
		
	

