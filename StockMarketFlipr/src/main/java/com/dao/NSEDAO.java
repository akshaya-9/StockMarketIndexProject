package com.dao;

import java.sql.Date;

import org.hibernate.Hibernate;

import com.db.HibernateTemplate;
import com.dto.NSE;

public class NSEDAO {

	public NSE getNseByDate() {
		return HibernateTemplate.nseByDate();
	}

}
