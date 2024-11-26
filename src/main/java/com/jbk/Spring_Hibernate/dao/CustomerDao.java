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

	// insert data
	public String insertData(Customer c) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(c);
		tr.commit();
		ss.close();

		return "Data Inserted";
	}

	// update data
//	public String updateData(Customer c) {
//		Session ss = factory.openSession();
//		Transaction tr = ss.beginTransaction();
//
//		String hqlQuery = "update Customer set cname = :name, ccity = :city, pname = :product where cid = :id";
//
//		Query<Customer> query = ss.createQuery(hqlQuery);
//
//		query.setParameter("name", c.getCname());
//		query.setParameter("city", c.getCcity());
//		query.setParameter("product", c.getPname());
//		query.setParameter("id", c.getCid());
//
//		query.executeUpdate();
//
//		tr.commit();
//		ss.close();
//
//		return "Data Updated";
//	}

	// delete data
	public String deleteData(int cid) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		Customer c = ss.get(Customer.class, cid);

		ss.remove(c);

		tr.commit();
		ss.close();

		return "Record Deleted";
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
