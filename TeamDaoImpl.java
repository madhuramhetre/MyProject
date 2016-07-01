package com.dao;



import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Team;

@Repository
public class TeamDaoImpl implements TeamDao
{
  @Autowired
  private SessionFactory factory;
	
    @SuppressWarnings("unused")
	@Override
	public Team createTeam(Team team) throws Exception {
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("dao "+team);
	    Integer id = (Integer) session.save(team);
		tx.commit();
		session.close();
		System.out.println("dao end"+team);
		return team;
	}

	@Override
	public boolean deleteTeam(Team team) throws Exception
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("dao "+team);
	    session.delete(team);
		tx.commit();
		session.close();
		System.out.println("dao end"+team);
		return true;
	}

	@Override
	public Team updateTeam(Team team) throws Exception {
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("dao "+team);
	    session.update(team);
		tx.commit();
		session.close();
		System.out.println("dao end"+team);
		return team;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> listTeam() throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<Team> teamList = session.createCriteria(Team.class).list();
	    
		tx.commit();
		session.close();
		System.out.println(teamList);
		return teamList;
		
	}

	@Override
	public Team getTeamById(Team team) throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		team = (Team) session.get(Team.class, team.getTeamId());
		team.getProjects();
		team.getResources();
				tx.commit();
				session.close();
		return team;
		
	}

	
  

	
}
