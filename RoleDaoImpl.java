package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Resource;
import com.model.Role;
import com.model.Team;
@Repository
public class RoleDaoImpl implements RoleDao{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public Role createRole(Role role) throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
	    session.save(role);
		tx.commit();
		session.close();
		return role;
	}

	@Override
	public boolean deleteRole(Resource resource) throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("delete role 3"+resource.getResourceId());
		session.createQuery("delete from Role where resourceId = :id").setInteger("id", resource.getResourceId()).executeUpdate();
		tx.commit();
		session.close();
		System.out.println("delete role 4");
		return true;
	}

	@Override
	public Role updateRole(Role role) throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("dao "+role);
	    session.update(role);
		tx.commit();
		session.close();
		System.out.println("dao end"+role);
		return role;
		
	}
	/*public Role getRoleById(Role role) throws Exception {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		role = (Role) session.get(Role.class, role.getRoleId());
		role.getResource();
		
		return role;
	}*/

}
