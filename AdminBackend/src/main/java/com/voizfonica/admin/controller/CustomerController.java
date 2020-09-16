package com.voizfonica.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.voizfonica.admin.model.AddCustomer;
import com.voizfonica.admin.service.CustomerService;



@RestController
public class CustomerController 
{
	@Autowired
	private CustomerService service;
	
	@ResponseBody
	@PostMapping("/addcustomer")
	@CrossOrigin("http://localhost:4200")
	public AddCustomer addCustomer(@RequestBody AddCustomer customer) throws Exception
	{
		System.out.println("enter here");
		long phno=customer.getPhno();
		if(!"".equals(phno))
		{
			AddCustomer addcust=service.validateNumber(phno);
			if(addcust!=null)
			{
				throw new Exception("User with PhoneNumber "+phno+" already exists");
			}
		}
		
		service.addCustomer(customer);
		return customer;
	}
}
