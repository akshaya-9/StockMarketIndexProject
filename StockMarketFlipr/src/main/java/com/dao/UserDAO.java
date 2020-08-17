package com.dao;

import org.hibernate.SessionFactory;

import com.db.HibernateTemplate;

import com.dto.User;

public class UserDAO {
	private SessionFactory factory = null;
	public int register(User user) { 
		return HibernateTemplate.addObject(user);
	}
	
	public User getUserByUserPass(String email,String password) {
		return (User)HibernateTemplate.getObjectByUserPass(email,password);
	}
	
}
