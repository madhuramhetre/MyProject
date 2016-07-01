package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao {
	@Autowired
	private SessionFactory factory;
	
	
	@SuppressWarnings("unused")
	@Override
	public Project createProject(Project project) throws Exception {
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("dao "+project);
	    Integer id = (Integer) session.save(project);
		tx.commit();
		session.close();
		System.out.println("dao end"+project);
		return project;
		
	}
	
	@Override
	public boolean deleteProject(Project project) throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("dao "+project);
	    session.delete(project);
		tx.commit();
		session.close();
		System.out.println("dao end"+project);
		return true;
	}
	
	@Override
	public Project updateProject(Project project) throws Exception {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("dao "+project);
	    session.update(project);
		tx.commit();
		session.close();
		System.out.println("dao end"+project);
		return project;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> listProject() throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<Project> projectList = session.createCriteria(Project.class).list();
	    
		tx.commit();
		session.close();
		
		return projectList;
	}
	
	@SuppressWarnings("unused")
	@Override
	public Project getProjectById(Project project) throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		project = (Project) session.get(Project.class, project.getProjectId());
		return project;
	}

}
