package com.service;

import java.util.List;

import com.model.Project;
import com.model.Resource;
import com.model.Role;
import com.model.Team;

public interface ProjectManagerService {

	public boolean allocateProjectToTeam(Team team,Project project) throws Exception;//.
	public boolean deallocateProjectfromTeam(Project project) throws Exception;//??
	public boolean addResourceToTeam(Resource resource,Team team)throws Exception;//
	public boolean removeResourceFromTeam(Resource resource)throws Exception;//
	public boolean createTeam(Team team) throws Exception;//
	public boolean createProject(Project project) throws Exception;//
	public boolean deleteTeam(Team team)throws Exception;//................
	public Team updateTeam(Team team)throws Exception;//
	public List<Team> listTeam()throws Exception;//
	public Team getTeamById(Team team)throws Exception;//
	public boolean deleteProject(Project project)throws Exception;//
	public Project updateProject(Project project)throws Exception;//
	public List<Project> listProject()throws Exception;//
	public Project getProjectById(Project project)throws Exception;//
	
	public boolean addRoleToResource(Resource resource,Role role) throws Exception;
	public Role updateRole(Role role) throws Exception;
	public boolean removeRoleFromResource(Resource resource) throws Exception ;
}
