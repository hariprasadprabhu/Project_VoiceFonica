package com.voizfonica.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voizfonica.admin.model.AddCustomer;
import com.voizfonica.admin.model.AddOffer;
import com.voizfonica.admin.repository.CustomerRepository;
import com.voizfonica.admin.repository.OfferRepository;


@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private OfferRepository repo2;
	
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
