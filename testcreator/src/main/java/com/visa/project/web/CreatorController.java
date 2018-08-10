package com.visa.project.web;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.visa.project.domain.TestCreator;
import com.visa.project.service.CreatorService;

@Controller
public class CreatorController {
	@Autowired
	CreatorService service;
	
	@RequestMapping(value="/creatorlogin",method = RequestMethod.POST)
	public String login(HttpServletRequest req, @RequestParam("creatorEmail")String emailId,@RequestParam("creatorPassword")String password){
		TestCreator tc = service.findOne(emailId);
		if(tc!=null)
		{
			if(tc.getPassword().equals(password))
				
				{
				String x= tc.getCreatorEmailId();
				req.getSession().setAttribute("creatoremailid", x);
				
				return "createtest";
				
				}
			else
				return "index";
		}
		else
			return "index";
	}
	
	@RequestMapping(value="/creatorsignup",method=RequestMethod.POST)
	public String signup(@RequestParam("creatorEmail")String emailId,@RequestParam("creatorPassword")String password,@RequestParam("creatorName")String name){
		TestCreator tc = new TestCreator(emailId,name,password);
		TestCreator aux = service.addNew(tc);
		if(aux!=null)
			return "index";
		else
			return "registrationfailed";
	}

}
