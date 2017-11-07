package com.cg.uas.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Universities")
@NamedQuery(name="retrieveUniversity",query="SELECT universityName FROM UniversityBean university")
public class UniversityBean {

	@Id
	@Column(name="University_name")
	private String universityName;
	@Column(name="university_code")
	private String code;
	
	
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
