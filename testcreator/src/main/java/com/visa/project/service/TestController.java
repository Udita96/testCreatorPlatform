package com.visa.project.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.visa.project.dal.QuestionDAO;
import com.visa.project.domain.Test;
import com.visa.project.domain.TestCreator;

@Controller
public class TestController {

	@Autowired
	QuestionDAO testdao;

	@RequestMapping(value= "/testcreation", method = RequestMethod.GET)
	public String testcreated(@RequestParam("testTitle")String testTitle,
			@RequestParam("testDescription")String testdescription, @RequestParam("testLink")String testLink )
	{
		
		Test t= new Test(testTitle, testdescription);
		t.setTestLink(testLink);
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession() ; 
		TestCreator tc = (TestCreator) session.getAttribute("loggedin") ; 
		String id = tc.getCreatorEmailId() ; 
	testdao.addNewTest(t, testTitle, testdescription, testLink , id );
	return "edittest";
	}
	
	
}
