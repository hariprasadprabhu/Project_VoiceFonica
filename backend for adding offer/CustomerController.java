package com.app.customeradmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.customeradmin.model.AddCustomer;
import com.app.customeradmin.model.AddOffer;
import com.app.customeradmin.model.AdminRegistration;
import com.app.customeradmin.service.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired
	private CustomerService service;
	
	
	
	@ResponseBody
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
				throw new Exception("User with "+eid+" is already exists ");
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
	
	
	@ResponseBody
	@PostMapping("/addcustomer")
	@CrossOrigin(origins = "http://localhost:4200")
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
	
	
	@ResponseBody
	@PostMapping("/addoffer")
	@CrossOrigin(origins = "http://localhost:4200")
	public AddOffer addOffer(@RequestBody AddOffer offer) throws Exception
	{
		String planname=offer.getPlanName();
		/*if(planname!=null &&!"".equals(planname))
		{
			AddOffer addoffer=service.validateNumber(phno);
			if(addcust!=null)
			{
				throw new Exception("User with PhoneNumber "+phno+" already exists");
			}
		}*/
		
		service.addOffer(offer);
		return offer;
	}
}
