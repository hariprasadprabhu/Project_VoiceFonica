package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.PrepaidPlans;
import com.example.demo.service.RegistrationService;


@RestController
public class RegistrationController 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private RegistrationService service;
	@PostMapping(path = "/registercustomer")
	@CrossOrigin(origins = "http://localhost:4200")
	public Customer registerCustomer(@RequestBody Customer cust) throws Exception
	{
		long num=cust.getPhoneNum();
		if(num!=0)
		{
			Customer custObje=service.fetchCustByNumber(num);
			if(custObje!=null)
			{
				throw new Exception("User with "+num+" is already exist");
			}
		}
		Customer custObje=null;
		custObje=service.saveCustomer(cust);
		return custObje;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public Customer loginCustomer(@RequestBody Customer cust) throws Exception
	{
		long tempNumber=cust.getPhoneNum();
		String tempPass=cust.getPassword();
		Customer custObj=null;
		if(tempNumber!=0 && tempPass!=null)
		{
			custObj= service.fetchCustByNumberAndPassword(tempNumber, tempPass);
			
		}
		if(custObj==null)
			throw new Exception("User Does not Exist with the given Credentials");
		return custObj;
	}
	@PostMapping("/getall")
	public List<Customer> showall()
	{
		String sql="SELECT * FROM my_data.CUST01";
		List<Customer> list= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));
		
		return list;
	}
	@GetMapping("/getallPlans")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<PrepaidPlans> showallPlans()
	{
		String sql="SELECT * FROM my_data.plans";
		List<PrepaidPlans> list= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PrepaidPlans.class));
		
		return list;
	}
	

}
