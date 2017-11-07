package com.cg.uas.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Programs_Scheduled")
@NamedQuery(name="retrieveProgramId",query="SELECT schedulePgmId FROM ProgramsScheduledBean pgmSchBean where pgmSchBean.programName=:pgmId")
public class ProgramsScheduledBean {

	@Id
	@Column(name="Scheduled_program_id")
	private String schedulePgmId;
	private String programName,location,university;
	private Date startDate,endDate;
	private int sessionsPerWeek;
	
	
	public String getSchedulePgmId() {
		return schedulePgmId;
	}
	public void setSchedulePgmId(String schedulePgmId) {
		this.schedulePgmId = schedulePgmId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getSessionsPerWeek() {
		return sessionsPerWeek;
	}
	public void setSessionsPerWeek(int sessionsPerWeek) {
		this.sessionsPerWeek = sessionsPerWeek;
	}
	
	
}
