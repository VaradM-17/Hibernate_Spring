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
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(c);
		tr.commit();
		ss.close();

		return "Data Inserted";
	}

	// Update Data

	public String updateData(Customer c, int cid) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		Customer cust = ss.get(Customer.class, cid);

		cust.setCname(cust.getCname());
		cust.setCcity(cust.getCcity());
		cust.setPname(cust.getPname());

		tr.commit();
		ss.close();

		return "Data Updated";
	}

	// Delete data
	public String deleteData(int cid) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		Customer c = ss.get(Customer.class, cid);

		ss.remove(c);

		tr.commit();
		ss.close();

		return "Record Deleted";
	}

	// Display All Data
	public List<Customer> displayallData() {
		Session ss = factory.openSession();
		Transaction t = ss.beginTransaction();

		String hqlQuery = "from Customer";
		Query<Customer> query = ss.createQuery(hqlQuery, Customer.class);
		List<Customer> list = query.list();

		return list;

	}

	// Fetch Single Record data
	public Customer fetchsingleData(int cid) {
		Session ss = factory.openSession();
		Transaction t = ss.beginTransaction();

		String hqlQuery = "from Customer where cid = :myid";
		Query<Customer> query = ss.createQuery(hqlQuery, Customer.class);
		query.setParameter("myid", cid);

		Customer c = query.getSingleResult();

		t.commit();
		ss.close();

		return c;
	}
}
