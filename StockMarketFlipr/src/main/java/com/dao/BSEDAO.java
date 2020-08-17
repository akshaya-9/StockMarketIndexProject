package com.dao;

import com.db.HibernateTemplate;
import com.dto.BSE;

public class BSEDAO {



	public BSE getBseByDate() {
		// TODO Auto-generated method stub
		return HibernateTemplate.bseByDate();
	}
       
}
