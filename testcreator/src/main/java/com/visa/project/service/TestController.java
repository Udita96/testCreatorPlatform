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
import com.visa.project.domain.Option;
import com.visa.project.domain.Question;
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
		int tid= t.getTestId();
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession() ; 
		TestCreator tc = (TestCreator) session.getAttribute("loggedin") ; 
		String id = tc.getCreatorEmailId() ; 
		session.setAttribute("testid", tid);
	testdao.addNewTest(t, testTitle, testdescription, testLink , id );
	return "edittest";
	}
	

	@RequestMapping(value= "/addquestion", method = RequestMethod.GET)
	public String addingQuestion(@RequestParam("questionText")String questionText,
			@RequestParam("option1")String option1Text, 
			@RequestParam("option2")String option2Text,
			@RequestParam("option3")String option3Text,
			@RequestParam("option4")String option4Text, @RequestParam("correctoption") String correctoption)
			
	{
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession() ; 
		int tid= (Integer) session.getAttribute("testid") ; 
		Question q= new Question(questionText, 1, 0);
		
		Option o1= new Option(option1Text, getVal(correctoption.equals("o1")));
		Option o2= new Option(option1Text, getVal(correctoption.equals("o2")));
		Option o3= new Option(option1Text, getVal(correctoption.equals("o3")));
		Option o4= new Option(option1Text, getVal(correctoption.equals("o4")));
		
		testdao.addNewEverything(tid, q, questionText, o1, o2, o3, o4);
		
		
		
	return "edittest";
	}

	private int getVal(boolean equals) {
		// TODO Auto-generated method stub
		if(equals)
		{
			return 1;
		}
		else return 0;
	}

}
