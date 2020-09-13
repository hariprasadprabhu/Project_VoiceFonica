package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(schema = "my_data",name = "Cust01")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
    
	private int id;
	private long phoneNum;
	private String emailId;
	private String userName; 
	private String password;
	public Customer()
	{
		
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Customer(int id, long phonNum, String emailId, String userName, String password) {
		super();
		this.id = id;
		this.phoneNum = phonNum;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
	}


	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
