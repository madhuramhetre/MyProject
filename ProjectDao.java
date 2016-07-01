package com.dao;

import java.util.List;

import com.model.Project;


public interface ProjectDao {
	public Project createProject(Project project)throws Exception;
	public boolean deleteProject(Project project)throws Exception;
	public Project updateProject(Project project)throws Exception;
	public List<Project> listProject()throws Exception;
	public Project getProjectById(Project project)throws Exception;
	
	

}
