package com.app.adminregistration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminRegistration
{
	
	@Id
	private int eid;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private long phno;
	
	public AdminRegistration() {
		
	}
	public AdminRegistration(String fname, String lname, String email, int eid, String password,long phno) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.eid = eid;
		this.password = password;
		this.phno=phno;
	}
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	
	
	
	
}
