package com.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Team {

	private Integer teamId;
	private String teamName;
	private String teamStatus;
	private Date startDate;
	private Date endDate;
	private List<Resource> resources;
	private List<Project> projects;
	
	public Team() {
		System.out.println("team created");
	}
	
	public Team(String teamName, String teamStatus, Date startDate, Date endDate, List<Resource> resources,
			List<Project> projects) {
		super();
		this.teamName = teamName;
		this.teamStatus = teamStatus;
		this.startDate = startDate;
		this.endDate = endDate;
		this.resources = resources;
		this.projects = projects;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
	public String getTeamStatus() {
		return teamStatus;
	}
	public void setTeamStatus(String teamStatus) {
		this.teamStatus = teamStatus;
	}
	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	

	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@OneToMany(targetEntity=Resource.class,cascade=CascadeType.ALL,mappedBy="team",fetch=FetchType.EAGER)
	@Fetch(value=FetchMode.SUBSELECT)
	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
	@OneToMany(targetEntity=Project.class,cascade=CascadeType.ALL,mappedBy="team",fetch=FetchType.EAGER)
	@Fetch(value=FetchMode.SUBSELECT)
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", teamStatus=" + teamStatus + ", startDate="
				+ startDate + ", endDate=" + endDate + "projects=" +projects+" ]";
	}
	
	
	
}
