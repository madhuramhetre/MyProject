package com.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.User;

@Repository
public class UserDaoImpl implements UserDao
{

	@Autowired
	private SessionFactory factory;
	@Override
	public boolean validate(User user)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		/*User user1 = (User)session.get(User.class, user.getUsername());
		if(user1.getPassword()==user.getPassword())
			return true;
		else 
			return false;
*/		Criteria cr=session.createCriteria(User.class);
		cr.add(Restrictions.eq("username", user.getUsername()));
		cr.add(Restrictions.eq("password", user.getPassword()));
		tx.commit();
		session.close();
		return true;
		
		
	}
	
}
