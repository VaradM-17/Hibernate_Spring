package com.jbk.Spring_Hibernate.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Spring_Hibernate.dao.CustomerDao;
import com.jbk.Spring_Hibernate.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerDao dao;

	Scanner sc = new Scanner(System.in);

	public String insertData(Customer c) {
		String msg = dao.insertData(c);
		return msg;
	}

//	public String updateData(Customer c) {
//		String msg = dao.insertData(c);
//		return msg;
//	}

	public String deleteData(int cid) {
		String msg = dao.deleteData(cid);
		return msg;
	}

	public Customer fetchsingleData(int cid) {
		Customer c = dao.fetchsingleData(cid);
		return c;
	}

}
