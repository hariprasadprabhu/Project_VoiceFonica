package com.app.customeradmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


import com.app.customeradmin.model.AddCustomer;
import com.app.customeradmin.model.AddOffer;
import com.app.customeradmin.model.AdminRegistration;
import com.app.customeradmin.repository.AdminRegistrationRepo;
import com.app.customeradmin.repository.CustomerRepository;
import com.app.customeradmin.repository.OfferRepository;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private AdminRegistrationRepo repo1;
	
	@Autowired
	private OfferRepository repo2;
	
	public AdminRegistration saveAdmin(AdminRegistration admin)
	{
		return repo1.save(admin);
		
	}
	
	public AdminRegistration validateId(Integer eid)
	{
		return repo1.findByEid(eid);
	}
	
	public AdminRegistration validateLogin(Integer eid,String password)
	{
		return repo1.findByEidAndPassword(eid, password);
	}
	
	public AddCustomer addCustomer(AddCustomer customer)
	{
		return repo.save(customer);
	}
	
	public AddCustomer validateNumber(long customer)
	{
		return repo.findByPhno(customer);
	}
	
	public AddOffer addOffer(AddOffer offer)
	{
		return repo2.save(offer);
	}
}
