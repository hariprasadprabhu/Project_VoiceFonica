package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.RegistrationRepository;


@Service
public class RegistrationService 
{
	@Autowired
	private RegistrationRepository repo;
	
	public Customer saveCustomer(Customer cust)
	{
		return repo.save(cust);
	}
	
	public Customer fetchCustByNumber(long num)
	{
		return repo.findByphoneNum(num);
	}
	public Customer fetchCustByNumberAndPassword(long num,String password)
	{
		return repo.findByphoneNumAndPassword(num, password);
	}
	public Customer fetchAll(long num) {
		return repo.findByphoneNum(num);
	}
}
