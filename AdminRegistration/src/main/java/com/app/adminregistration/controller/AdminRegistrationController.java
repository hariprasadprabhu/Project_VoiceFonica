package com.app.adminregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.adminregistration.model.AdminRegistration;
import com.app.adminregistration.service.AdminRegistrationService;

@RestController
public class AdminRegistrationController 
{
	@Autowired
	private AdminRegistrationService service;
	
	@PostMapping("/registeradmin")
	@CrossOrigin(origins="http://localhost:4200")
	public AdminRegistration registerAdmin(@RequestBody AdminRegistration admin) throws Exception
	{
		
		Integer eid=admin.getEid();
		if(eid!=null && !"".equals(eid))
		{
			AdminRegistration adminobject=service.validateId(eid);
			if(adminobject!=null)
			{
				throw new Exception("user with "+eid+" is already exists ");
			}
		}
		
		service.saveAdmin(admin);
		return admin;
		
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public AdminRegistration loginAdmin(@RequestBody AdminRegistration admin) throws Exception
	{
		Integer tempId=admin.getEid();
		String tempPass=admin.getPassword();
		AdminRegistration adobj=null;
		if(tempId!=null && tempPass!=null)
		{
			adobj = service.validateLogin(tempId, tempPass);
		}
		if(adobj==null)
		{
			throw new Exception("bad credentials");
		}
		return adobj;
	}
}
