package com.app.adminregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.adminregistration.model.AdminRegistration;
import com.app.adminregistration.repository.AdminRegistrationRepo;


@Service
public class AdminRegistrationService 
{
	@Autowired
	private AdminRegistrationRepo repo;
	
	public AdminRegistration saveAdmin(AdminRegistration admin)
	{
		return repo.save(admin);
		
	}
	
	public AdminRegistration validateId(Integer eid)
	{
		return repo.findByEid(eid);
	}
	
	public AdminRegistration validateLogin(Integer eid,String password)
	{
		return repo.findByEidAndPassword(eid, password);
	}
	
}
