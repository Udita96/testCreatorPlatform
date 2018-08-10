package com.visa.project.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.visa.project.domain.Question;
import com.visa.project.domain.Option;
import com.visa.project.domain.Test;
import com.visa.project.domain.TestCreator;

@Component
@Transactional
public class QuestionDAO {

	@Autowired
	EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void delete(int id) {

	}

	public void changePrice(int id, float newPrice) {

	}

	public Test addNewTest(Test t, String titleOfTest, String description, String testLink, String creatorId) {
		TestCreator tc = em.find(TestCreator.class, creatorId);
		t.setTestCreator(tc);
		em.persist(t);
		return t;

	}

	public void addNewEverything(int testid, Question q, String qtext, Option o1, Option o2, Option o3, Option o4) {
		
		em.persist(q);
		o1.setQuestion(q);
		o2.setQuestion(q);
		o3.setQuestion(q);
		o4.setQuestion(q);
		em.persist(o1);
		em.persist(o2);
		em.persist(o3);
		em.persist(o4);
		
		
		
	}

	public Question addNewQuestion(Question q, String questionText) {
		q.setQuestionText(questionText);
		em.persist(q);

		return q;
	}

	public Option addNewOption(Option o, int isCorrect, String optionText) {
		o.setFlagForCorrectOption(isCorrect);
		o.setOptionText(optionText);
		em.persist(o);
		return o;
	}
}
