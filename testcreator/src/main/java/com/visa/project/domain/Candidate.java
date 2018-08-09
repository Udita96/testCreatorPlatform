package com.visa.project.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Candidate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int candidateId;
	String candidateEmailId;
	String candidateName;
	String organization;
	long mobileNumber;
	@ManyToOne(cascade=(CascadeType.PERSIST),fetch=FetchType.LAZY)
	@JoinColumn(name="testId")
	Test test;
	@OneToMany(mappedBy="Test")
	List<SubmissionId> submissionId;
	int marks;
	
	public Candidate(){
		
	}

	public Candidate(String candidateEmailId, String candidateName, String organization, long mobileNumber, int marks) {
		super();
		this.candidateEmailId = candidateEmailId;
		this.candidateName = candidateName;
		this.organization = organization;
		this.mobileNumber = mobileNumber;
		this.marks = marks;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateEmailId() {
		return candidateEmailId;
	}

	public void setCandidateEmailId(String candidateEmailId) {
		this.candidateEmailId = candidateEmailId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

}
