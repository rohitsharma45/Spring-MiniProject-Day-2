package com.cg.uas.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.uas.bean.ApplicantBean;


@Repository
@Transactional
public class UasDaoImpl implements IUasDao{

	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<String> retrieveUniversity() {

	
		TypedQuery<String> query = entityManager.createNamedQuery("retrieveUniversity", String.class);
		List<String> idList = query.getResultList();
		System.out.println(idList);
		return idList;

		}


	@Override
	public List<String> retrieveProgram(String universityName) {
		//String qstr="SELECT programName from ProgramsOfferedBean pgmBean";
		TypedQuery<String> query=entityManager.createNamedQuery("retreiveProgram",String.class).setParameter("pgmName", universityName);;
		List<String> pgmList=query.getResultList();
		return pgmList;
	}


	@Override
	public int addDetails(ApplicantBean application) {
		entityManager.persist(application);
		entityManager.flush();
		return application.getApplicationId();
	}


	@Override
	public String retrieveProgramId(String programName) {
		Query query=entityManager.createNamedQuery("retrieveProgramId",String.class ).setParameter("pgmId",programName);
		String programId=(String) query.getSingleResult();
		
		return programId;
	}





	@Override
	public String retrieveStatus(int applicationId) {
		Query query=entityManager.createNamedQuery("retrieveStatus",String.class ).setParameter("appId",applicationId);
		String status=(String) query.getSingleResult();
		System.out.println(status);
		return status;
	}
	


}
