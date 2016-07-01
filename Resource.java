package com.model;

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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.model.Role;



@Entity
public class Resource {

	private Integer resourceId;
	private String resourceName;
	private String resourceStatus;
	private List<Role> roles;
	//private List<Project> projects;
	private Team team;
	
	public Resource() {
		System.out.println("resource created");
	}
	
	public Resource(String resourceName, String resourceStatus, List<Role> roles, List<Project> projects, Team team) {
		super();
		this.resourceName = resourceName;
		this.resourceStatus = resourceStatus;
		this.roles = roles;
		//this.projects = projects;
		this.team = team;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	
	
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
	
	public String getResourceStatus() {
		return resourceStatus;
	}
	public void setResourceStatus(String resourceStatus) {
		this.resourceStatus = resourceStatus;
	}
	
	
	@OneToMany(targetEntity=Role.class,mappedBy="resource",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@Fetch(value=FetchMode.SUBSELECT)
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	/*@OneToMany(targetEntity=Project.class,mappedBy="resource",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@Fetch(value=FetchMode.SUBSELECT)
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
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
		return "Resource [resourceId=" + resourceId + ", resourceName=" + resourceName + ", resourceStatus="
				+ resourceStatus + "role "+ roles;
	}
	
	
	
}
