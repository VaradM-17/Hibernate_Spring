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

			msg = "Data Successfully Inserted...";
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

	// Update Data
	public String updateData(Customer c, int cid) {

		Session ss = null;
		Transaction tx = null;
		String msg = null;

		try {
			ss = factory.openSession();
			tx = ss.beginTransaction();

			Customer cust = ss.get(Customer.class, cid);

			cust.setCname(cust.getCname());
			cust.setCcity(cust.getCcity());
			cust.setPname(cust.getPname());

			ss.merge(cust);
			tx.commit();
			msg = "Data Successfully Updated...";

		} catch (Exception e) {
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

	// Delete data
	public String deleteData(int cid) {

		Session ss = null;
		Transaction tx = null;
		String msg = null;

		try {
			ss = factory.openSession();
			tx = ss.beginTransaction();

			Customer c = ss.get(Customer.class, cid);

			ss.remove(c);
			tx.commit();

			msg = "Data Successfully Deleted...";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			if (ss != null) {
				ss.close();
			}
		}

		return msg;
	}

	// Display All Data
	public List<Customer> displayallData() {

		Session ss = null;
		Transaction tx = null;
		List<Customer> list = null;

		try {
			ss = factory.openSession();
			tx = ss.beginTransaction();

			String hqlQuery = "from Customer";
			Query<Customer> query = ss.createQuery(hqlQuery, Customer.class);
			list = query.list();

			tx.commit();

			return list;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return list;
	}

	// Fetch Single Record data
	public Customer fetchsingleData(int cid) {

		Session ss = null;
		Transaction tx = null;
		Customer c = null;

		try {
			ss = factory.openSession();
			tx = ss.beginTransaction();

			String hqlQuery = "from Customer where cid = :myid";
			Query<Customer> query = ss.createQuery(hqlQuery, Customer.class);
			query.setParameter("myid", cid);

			c = query.getSingleResult();

			tx.commit();

			return c;

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return c;
	}
}
