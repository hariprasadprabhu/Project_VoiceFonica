package com.app.adminregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.adminregistration.model.AdminRegistration;


public interface AdminRegistrationRepo extends JpaRepository<AdminRegistration, Integer> 
{

	public AdminRegistration findByEid(Integer eid );
	
	
	public AdminRegistration findByEidAndPassword(Integer eid,String password);
}
