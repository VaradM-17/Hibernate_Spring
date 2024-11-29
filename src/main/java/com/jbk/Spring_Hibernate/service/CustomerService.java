package com.jbk.Spring_Hibernate.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Spring_Hibernate.dao.CustomerDao;
import com.jbk.Spring_Hibernate.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerdao;

	public String insertData(Customer c) {
		String msg = customerdao.insertData(c);

		if (Objects.isNull(msg)) {
			msg = "Data insertion failed. Please verify the input and try again later.";
		}

		return msg;
	}

	public String updateData(Customer c, int cid) {
		String msg = customerdao.updateData(c, cid);

		if (Objects.isNull(msg)) {
			msg = "Data update failed. Unable to apply changes. Please check the input or try again later.";
		}
		
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
