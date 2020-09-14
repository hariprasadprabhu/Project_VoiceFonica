package com.app.customeradmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.customeradmin.model.AddCustomer;
import com.app.customeradmin.service.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired
	private CustomerService service;
	
	@ResponseBody
	@PostMapping("/addcustomer")
	public AddCustomer addCustomer(@RequestBody AddCustomer customer) throws Exception
	{
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
