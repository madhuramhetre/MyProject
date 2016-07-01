package com.dao;

import java.util.List;


import com.model.Team;

public interface TeamDao
{

	public Team createTeam(Team team)throws Exception;
	public boolean deleteTeam(Team team)throws Exception;
	public Team updateTeam(Team team)throws Exception;
	public List<Team> listTeam()throws Exception;
	public Team getTeamById(Team team)throws Exception;
	
	
}
