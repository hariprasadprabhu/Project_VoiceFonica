package com.example.demo.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ActivePlans;
import com.example.demo.model.Chat;
import com.example.demo.model.Cust_Admin;
import com.example.demo.model.Cust_sub;
import com.example.demo.model.Customer;
import com.example.demo.model.Details;
import com.example.demo.model.Plan;
import com.example.demo.model.PostActivePlans;
import com.example.demo.model.Post_details;
import com.example.demo.model.PrepaidPlans;
import com.example.demo.model.Query;
import com.example.demo.service.RegistrationService;


@RestController
public class RegistrationController 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private RegistrationService service;
	@PostMapping(path = "/registercustomer")
	@CrossOrigin(origins = "http://localhost:4200")
	public Customer registerCustomer(@RequestBody Customer cust) throws Exception
	{
		long num=cust.getPhoneNum();
		if(num!=0)
		{
			Customer custObje=service.fetchCustByNumber(num);
			if(custObje!=null)
			{
				throw new Exception("User with "+num+" is already exist");
			}
		}
		String id1=Long.toString(num);
		String sql="SELECT * FROM my_data.customer_admin WHERE phno="+id1;
		List<Cust_Admin> list=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Cust_Admin.class));
		try {
			list.get(0);
		}
		catch(Exception e)
		{
			throw new Exception(num+" This Number is not subscribed to our service");
		}
		Customer custObje=null;
		custObje=service.saveCustomer(cust);
		return custObje;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public Cust_Admin loginCustomer(@RequestBody Customer cust) throws Exception
	{
		long tempNumber=cust.getPhoneNum();
		String tempPass=cust.getPassword();
		Customer custObj=null;
		if(tempNumber!=0 && tempPass!=null)
		{
			custObj= service.fetchCustByNumberAndPassword(tempNumber, tempPass);
			
		}
		if(custObj==null)
			throw new Exception("User Does not Exist with the given Credentials");
		String id1=Long.toString(tempNumber);
		String sql="SELECT * FROM my_data.customer_admin WHERE phno="+id1;
		List<Cust_Admin> list=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Cust_Admin.class));
		
		return list.get(0);
	}
	@PostMapping("/getall")
	public List<Customer> showall()
	{
		String sql="SELECT * FROM my_data.CUST01";
		List<Customer> list= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));
		
		return list;
	}
	@GetMapping("/getallPlans")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Plan> showallPlans()
	{
		String sql="SELECT * FROM my_data.plan";
		List<Plan> list= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Plan.class));
		
		return list;
	}
	@GetMapping("/query/{mobNum}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Query> showAllQueries(@PathVariable("mobNum") long mob)
	{
		String mobn=Long.toString(mob);
		String sql="SELECT * FROM my_data.cust_emp_query where cust_Num="+mobn;
		System.out.println("hi");
		List<Query> list= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Query.class));
		System.out.println(list.get(0).getCustQuery());
		return list;
	}
	
	@GetMapping("/history/{mobNum}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Details> showHistory(@PathVariable("mobNum") long mob)
	{
		String mobn=Long.toString(mob);
		String sql="SELECT * FROM my_data.details where phone_Num="+mobn;
		List<Details> list= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Details.class));
		return list;
		
	}
	
	
	@GetMapping("/getplan/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Plan> selectPlanById(@PathVariable("id") long id)
	{
		String id1=Long.toString(id);
		String sql="SELECT * FROM my_data.plan where id="+id1;
		List<Plan> list=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Plan.class));
		return list;
		
	}
	
	@GetMapping("/getActiveplan/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Plan findActivePlan(@PathVariable("id") long id)
	{
		String id1=Long.toString(id);
		String sql="SELECT * FROM my_data.plan where id IN (SELECT plan_id FROM my_data.activeplans WHERE phone_num="+id1+")";
		List<Plan> list=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Plan.class));
		System.out.println(list.get(0));
		return list.get(0);
		
	}
	
	@GetMapping("/getActiveplanDate/{phno}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ActivePlans findActiveDate(@PathVariable("phno") long phno)
	{
		String id1=Long.toString(phno);
		String sql="SELECT * FROM my_data.activeplans where phone_num="+id1;
		List<ActivePlans> list=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ActivePlans.class));
		System.out.println(list.get(0));
		System.out.println("hio");
		return list.get(0);
		
	}
	
	
	@GetMapping("/getAllChats/{phno}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Chat> findAllchats(@PathVariable("phno") long phno)
	{
		String id1=Long.toString(phno);
		String sql="SELECT * FROM my_data.chat where phone_num="+id1+" order by id";
		List<Chat> list=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Chat.class));
		return list;
		
	}
	
	
	@GetMapping("/getAlChats/{phno}")
	@CrossOrigin(origins = "http://localhost:4201")
	public List<Chat> findAllchat(@PathVariable("phno") long phno)
	{
		String id1=Long.toString(phno);
		String sql="SELECT * FROM my_data.chat where phone_num="+id1+" order by id";
		List<Chat> list=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Chat.class));
		return list;
		
	}
	
	@PostMapping("/getAlChatContact")
	@CrossOrigin(origins = "http://localhost:4201")
	public List<Chat> findAllchatContact(@RequestBody Chat chat)
	{
		String sql="select distinct phone_num from (select phone_num,id from my_data.chat order by id DESC)";
		List<Chat> list=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Chat.class));
		return list;
		
	}
	
	@PostMapping("/insertChats")
	@CrossOrigin(origins = "http://localhost:4200")
	public Chat inserchats(@RequestBody Chat chat)
	{
		Chat cobj=service.saveChat(chat);
		return cobj;
		
	}


	@PostMapping("/insertChat")
	@CrossOrigin(origins = "http://localhost:4201")
	public Chat insertchats(@RequestBody Chat chat)
	{
		Chat cobj=service.saveChat(chat);
		return cobj;
		
	}
	
	
	@PostMapping("/updateActivePlan")
	@CrossOrigin(origins = "http://localhost:4200")
	public ActivePlans updateActivePlan(@RequestBody ActivePlans act)
	{
		
		ActivePlans ap=service.saveACtive(act);
		
		return ap;
		
		
	}
	
	/*            admin side                */
	
	@GetMapping("/getBill/{number}")
	@CrossOrigin(origins = "http://localhost:4201")
	public List getBill(@PathVariable("number") long mob)
	{
		String id1=Long.toString(mob);
		String sql="SELECT * FROM my_data.customer_admin where phno="+id1;
		List list=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Cust_Admin.class));
		String sql1="SELECT * FROM my_data.cust_sub where phno="+id1;
		List list2=jdbcTemplate.query(sql1, BeanPropertyRowMapper.newInstance(Cust_sub.class));
		System.out.println(list.get(0));
		System.out.println(list2.get(0));
		System.out.println("hio");
		list.add(list2.get(0));
		return list;
	}
	
	@GetMapping("/getallPostpaidPlans")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Cust_Admin> showallPostpaidPlans()
	{
		String sql="SELECT * FROM my_data.customer_admin where type='postpaid'";
		List<Cust_Admin> list= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Cust_Admin.class));
		
		return list;
	}
	
	
	@GetMapping("/postpaidHistory/{mobNum}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Post_details> showHistorypostpaid(@PathVariable("mobNum") long mob)
	{
		String mobn=Long.toString(mob);
		String sql="SELECT * FROM my_data.post_details where phno="+mobn;
		List<Post_details> list= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Post_details.class));
		return list;
		
	}
	
	@GetMapping("/getpostActiveplan/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public PostActivePlans findPostActivePlan(@PathVariable("id") long id)
	{
		String id1=Long.toString(id);
		String sql="SELECT * FROM my_data.post_active WHERE phno="+id1;
		List<PostActivePlans> list=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PostActivePlans.class));
		System.out.println(list.get(0));
		return list.get(0);
		
	}
	
	
	
	@PostMapping("/updatepostpaid")
	@CrossOrigin(origins = "http://localhost:4200")
	public PostActivePlans updateActivepostplan(@RequestBody PostActivePlans postAplan)
	{	
		postAplan.setPaid(1);
		System.out.println(postAplan.getPaid());
		return service.savePostPlan(postAplan);
		
	}
	
}
