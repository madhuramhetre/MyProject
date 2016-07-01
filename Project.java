package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Project {

	private Integer projectId;
	private String projectName;
	//private Resource resource;
	private Team team;
	
	public Project() {
		System.out.println("project created");
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	/*@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="resourceId")
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}*/
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="teamId")
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + "]";
	}

	
	
	
}
