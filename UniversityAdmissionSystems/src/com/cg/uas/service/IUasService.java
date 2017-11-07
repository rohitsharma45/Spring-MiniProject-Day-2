package com.cg.uas.service;


import java.util.List;

import com.cg.uas.bean.ApplicantBean;


public interface IUasService {


	List<String> retrieveUniversity();

	List<String> retrieveProgram(String universityName);

	int addDetails(ApplicantBean application);

	String retreiveProgramId(String programName);

	String retrieveStatus(int applicationId);

	

}
