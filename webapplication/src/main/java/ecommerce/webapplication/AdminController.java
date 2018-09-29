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

@PostMapping("adminlogin")
public String adminlogin(@ModelAttribute("adminlogin") AdminLogin adminLogin,HttpSession httpSession)
{
	if(adminDao.adminlogin(adminLogin.getEmail(),adminLogin.getPassword())!=null)
	{
admin=adminDao.adminlogin(adminLogin.getEmail(),adminLogin.getPassword());
httpSession.setAttribute("admin",admin);
return "adminpage";
	}
		else
		{
		return "adminlogin";
		}
}
@GetMapping("adminpage")
public String adminpage()
{
	return "adminpage";
}

@GetMapping("adminprofile")
public String adminprofile()
{
	return "adminprofile";
}

@GetMapping("editadmin")
public String editadmin(HttpSession httpSession,Model model)
{
	model.addAttribute("admin", httpSession.getAttribute("admin"));
	return "editadmin";
}

@PostMapping("/updateadmin")
public String updateadmin(@ModelAttribute("admin") Admin admin,HttpSession httpSession)
{
	httpSession.setAttribute("admin", admin);
	adminDao.updateAdmin(admin);
	return "adminprofile";
}
}
