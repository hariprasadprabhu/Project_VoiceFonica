package com.voizfonica.admin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.voizfonica.admin.model.Admin;
import com.voizfonica.admin.model.Queries;
import com.voizfonica.admin.service.AdminService;

@RestController
public class AdminController
{
	@Autowired
	public AdminService service;
	
	@ResponseBody
	@PostMapping("/login")
	@CrossOrigin("http://localhost:4200")
	public Admin login(@RequestBody Admin admin)
	{
		Admin aobj = null;
		Integer tid=admin.getid();
		String tpwd=admin.getPassword();
		if(tid!=null && tpwd != null)
		{
			aobj=service.validate(tid,tpwd);
		}
		if(aobj==null)
		{
			System.out.println("no details");;
		}
		return aobj;
	}
	
	@ResponseBody
	@PostMapping("/reg")
	@CrossOrigin("http://localhost:4200")
	public Admin registration(@RequestBody Admin admin) throws Exception
	{
		Integer eid=admin.getid();
		String email=admin.getEmail();
		Admin adminobj=null;
		Admin obj=null;
		if(email!=null)
		{
			adminobj=service.validateEmail(email);
			if(adminobj !=null)
			{
				throw new Exception("user with "+eid+" is already exists ");
				
			}
			else
			{
				obj = service.saveAdmin(admin);
			}
		}
		
		return obj;
		
	}
	
	
}
