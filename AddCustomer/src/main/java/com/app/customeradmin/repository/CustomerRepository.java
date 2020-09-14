package com.app.customeradmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.customeradmin.model.AddCustomer;

public interface CustomerRepository extends JpaRepository<AddCustomer, Long> 
{

	public AddCustomer findByPhno(Long number);
	
}
