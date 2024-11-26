package com.jbk.Spring_Hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer 
{
	@Id
	private int cid;
	
	private String cname;
	private String ccity;
	private String pname;

	public Customer() 
	{
		super();
	}

	public Customer(int cid, String cname, String ccity, String pname) 
	{
		super();
		this.cid = cid;
		this.cname = cname;
		this.ccity = ccity;
		this.pname = pname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCcity() {
		return ccity;
	}

	public void setCcity(String ccity) {
		this.ccity = ccity;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Override
	public String toString() 
	{
		return "CustomerEntity [cid=" + cid + ", cname=" + cname + ", ccity=" + ccity + ", pname=" + pname + "]";
	}
}
