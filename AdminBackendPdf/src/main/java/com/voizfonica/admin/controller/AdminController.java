package com.voizfonica.admin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.mail.Message; import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.html2pdf.HtmlConverter;
import com.voizfonica.admin.model.AddCustomer;
import com.voizfonica.admin.model.Admin;
import com.voizfonica.admin.model.Email;
import com.voizfonica.admin.model.Queries;
import com.voizfonica.admin.service.AdminService;



@RestController
public class AdminController
{
	@Autowired
	public AdminService service;
	
	@Autowired
	JdbcTemplate jdbcTemplate; 
	
	@Autowired
	public JavaMailSender javaMailSender;

	
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
	
	@GetMapping("/search/{phno}")
	@CrossOrigin("http://localhost:4200")
	public List<AddCustomer> viewCustomer(@PathVariable("phno") long number)
	{
		System.out.println(1);
		String query;
		
		query="select * from my_data.customer_admin where phno="+number;
		
		List<AddCustomer> list=jdbcTemplate.query(query,BeanPropertyRowMapper.newInstance(AddCustomer.class));
		System.out.println(list);
		return list;
		
	}
	
	
	
	@PostMapping("/sendEmail")
	public void sendEmail(@RequestBody Email email) throws MessagingException
	{
		MimeMessage message=javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		helper.setTo("lshariprasadp@gmail.com");
		helper.setSubject("Voizfonica Bill generation");
		helper.setText("hi here is the attached copy of bill");
		
		
		ClassPathResource path=new ClassPathResource("hello.pdf");
		helper.addAttachment("hello.pdf", path);
		
		
		javaMailSender.send(message);
		
		
	}
	
	@RequestMapping("/genpdf")
	public void generatePdf() throws FileNotFoundException, IOException
	{
		HtmlConverter.convertToPdf(new FileInputStream("src/main/resources/templates/hello.html"), 
	            new FileOutputStream("src/main/resources/hello.pdf"));

	        System.out.println( "PDF Created!" );
	}
	
	
	
}
