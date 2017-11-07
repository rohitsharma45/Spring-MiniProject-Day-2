package com.cg.uas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.uas.bean.ApplicantBean;
import com.cg.uas.dao.IUasDao;

@Service
@Transactional
public class UasServiceImpl implements IUasService{

	@Autowired
	IUasDao dao;
	
	
	@Override
	public List<String> retrieveUniversity() {
		
		return dao.retrieveUniversity();
	}

	@Override
	public List<String> retrieveProgram(String universityName) {
		
		return dao.retrieveProgram(universityName);
	}

	@Override
	public int addDetails(ApplicantBean application) {
		
		return dao.addDetails(application);
	}

	@Override
	public String retreiveProgramId(String programName) {
		
		return dao.retrieveProgramId(programName);
	}

	@Override
	public String retrieveStatus(int applicationId) {
		
		return dao.retrieveStatus(applicationId);
	}
	
	

}
