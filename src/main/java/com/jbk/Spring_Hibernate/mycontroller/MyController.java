package com.jbk.Spring_Hibernate.mycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Spring_Hibernate.entity.Customer;
import com.jbk.Spring_Hibernate.service.CustomerService;

@RestController
public class MyController {

	@Autowired
	CustomerService service;

	@PostMapping("/insertdata")
	public String insertData(@RequestBody Customer c) {
		String msg = service.insertData(c);
		return msg;
	}

//	@PutMapping("/updatedata")
//	public String updateData(@RequestBody Customer c) {
//		String msg = service.updateData(c);
//		return msg;
//	}

	@DeleteMapping("/deletedata/{cid}")
	public String deleteData(@PathVariable int cid) {
		String msg = service.deleteData(cid);
		return msg;
	}

	@GetMapping("/fetchsingledata/{cid}")
	public Customer fetchsingleData(@PathVariable int cid) {
		Customer c = service.fetchsingleData(cid);
		return c;
	}

}
