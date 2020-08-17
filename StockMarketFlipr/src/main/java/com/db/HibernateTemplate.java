package com.db;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.dto.BSE;
import com.dto.NSE;
import com.dto.User;






public class HibernateTemplate {

	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static int addObject(Object obj){
		System.out.println("Inside Template...");
		int result=0;
		Transaction tx=null;	
		try {
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			session.save(obj);
			tx.commit();
			result=1;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;
		try {			
			return sessionFactory.openSession().get(c,serializable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	/*
	public static List<Companies> getObjectListByIddd(int serviceId) {
		String queryString = "select * from Companies where serviceId = :serviceId";
		String hql = "from Companies where serviceId = :serviceId";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		query.setInteger("serviceId", serviceId);
		List<Companies> logEntries = query.list();
		return logEntries;
}
*/
	public static NSE nseByDate() {
		// TODO Auto-generated method stub
		String queryString = "from NSE where date = '2020-08-13'";
		Session session=sessionFactory.openSession();
		Query query = session.createQuery(queryString);
		Object queryResult = query.uniqueResult();
		NSE user = (NSE)queryResult;
		return user;	
		}
	
	public static BSE bseByDate() {
		// TODO Auto-generated method stub
		String queryString = "from BSE where date = '2020-08-13'";
		Session session=sessionFactory.openSession();
		Query query = session.createQuery(queryString);
		Object queryResult = query.uniqueResult();
		BSE user = (BSE)queryResult;
		return user;	
		}
	
	public static User getObjectByUserPass(String email, String password) {
		// TODO Auto-generated method stub
		String queryString = "from User where email = :email and password =:password";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("email", email);
		query.setString("password", password);
		Object queryResult = query.uniqueResult();
		User user = (User)queryResult;
		return user; 
	}
}
