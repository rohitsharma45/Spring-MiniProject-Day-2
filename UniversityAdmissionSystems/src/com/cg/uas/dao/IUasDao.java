package com.cg.uas.dao;


import java.util.List;

import com.cg.uas.bean.ApplicantBean;


public interface IUasDao {


	List<String> retrieveUniversity();

	List<String> retrieveProgram(String universityName);

	int addDetails(ApplicantBean application);

	String retrieveProgramId(String programName);

	String retrieveStatus(int applicationId);


}
