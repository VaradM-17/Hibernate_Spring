package com.jbk.Spring_Hibernate.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Spring_Hibernate.dao.CustomerDao;
import com.jbk.Spring_Hibernate.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerdao;

	Scanner sc = new Scanner(System.in);

	public String insertData(Customer c) {
		String msg = customerdao.insertData(c);
		return msg;
	}

	public String updateData(Customer c, int cid) {
		String msg = customerdao.updateData(c, cid);
		return msg;
	}

	public String deleteData(int cid) {
		String msg = customerdao.deleteData(cid);
		return msg;
	}

	public List<Customer> displayallData() {
		List<Customer> list = customerdao.displayallData();
		return list;
	}

	public Customer fetchsingleData(int cid) {
		Customer c = customerdao.fetchsingleData(cid);
		return c;
	}

}
