package com.jbk.Spring_Hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Spring_Hibernate.entity.Customer;

@Repository
public class CustomerDao {
	@Autowired
	SessionFactory factory;

	// Insert data
	public String insertData(Customer c) {

		Session ss = null;
		Transaction tx = null;
		String msg = null;

		try {
			ss = factory.openSession();
			tx = ss.beginTransaction();

			ss.persist(c);
			tx.commit();

			msg = "Data Inserted";
		}

		catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return msg;

	}

	
}
