package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Resource;

@Repository
public class RsourceDaoImpl implements ResourceDao{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public boolean createResource(Resource resource) throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(resource);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public List<Resource> listResource() throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Resource> resourceList = session.createCriteria(Resource.class).list();
		for (Resource resource : resourceList) {
			
			resource.getRoles();
			//resource.getProjects();
			resource.getTeam();
			System.out.println(resource);
		}
		System.out.println("resource list :" + resourceList);
		tx.commit();
		session.close();
		return resourceList;
	}

	@Override
	public Resource getResource(Resource resource) throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		resource = (Resource)session.get(Resource.class, resource.getResourceId());
		tx.commit();
		session.close();
		return resource;
	}

	@Override
	public boolean deleteResource(Resource resource) throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(resource);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean updateResource(Resource resource) throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(resource);
		tx.commit();
		session.close();
		return true;
	}

}
