package com.app.customeradmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customeradmin.model.AddCustomer;
import com.app.customeradmin.repository.CustomerRepository;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepository repo;
	
	public AddCustomer addCustomer(AddCustomer customer)
	{
		return repo.save(customer);
	}
	
	public AddCustomer validateNumber(long customer)
	{
		return repo.findByPhno(customer);
	}
}
