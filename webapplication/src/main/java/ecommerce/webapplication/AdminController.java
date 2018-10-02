package ecommerce.webapplication;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ecommerce.webdemo.dao.AdminDao;
import ecommerce.webdemo.model.Admin;
import ecommerce.webdemo.model.AdminLogin;
import ecommerce.webdemo.model.Customer;

@Controller

public class AdminController 
{
	
	@Autowired
	private Admin admin;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AdminLogin adminLogin;
@GetMapping("/adminlogin")
public String adminlogin()
{
	return "adminlogin";
}


@PostMapping("/updateadmin")
public String updateadmin(@ModelAttribute("admin") Admin admin,HttpSession httpSession)
{
	httpSession.setAttribute("admin", admin);
	adminDao.updateAdmin(admin);
	return "adminprofile";
}
}
