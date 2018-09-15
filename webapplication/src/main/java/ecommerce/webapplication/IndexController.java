package ecommerce.webapplication;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.webdemo.dao.AdminDao;
import ecommerce.webdemo.dao.CategoryDao;
import ecommerce.webdemo.dao.CustomerDao;
import ecommerce.webdemo.dao.VendorDao;
import ecommerce.webdemo.daoimpl.CustomerDaoImpl;
import ecommerce.webdemo.daoimpl.VendorDaoImpl;
import ecommerce.webdemo.model.Admin;
import ecommerce.webdemo.model.Category;
import ecommerce.webdemo.model.Customer;
import ecommerce.webdemo.model.Login;
import ecommerce.webdemo.model.Vendor;

@Controller
public class IndexController {
	@Autowired
	private Vendor vendor;
	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private Customer customer;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private Mail mail;
	@Autowired
	private Category category;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private AdminDao adminDao;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("index");
		/* view.addObject("myName", "hyndavi"); */
		return view;
	}


	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView modelAndView = new ModelAndView("contact");

		return modelAndView;
	}

	@GetMapping("/signup")
	
	public String signup(Model model) {
		model.addAttribute("vendor", new Vendor());
		return "signup";
	}

	@PostMapping("/signup")
	public String signup(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult bindingResult)
	{
		System.out.println(bindingResult.hasErrors());
		/*if (!bindingResult.hasErrors()) 
		{*/
			if (vendorDao.getVendorByEmail(vendor.getEmail()) == null) 
			{
				vendorDao.addVendor(vendor);
				/*mail=new Mail();
				mail.sendingMail(vendor.getEmail(),vendor.getPassword());*/
				return "redirect:/login";

			} 
			else 
			{
				return "signup";
			}
		/*} 
		else 
		{
			return "signup";
		}*/
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}

	// login process

	@PostMapping("/login")
	public String loginVendor(@ModelAttribute("login") Login login, HttpSession session,Vendor vendor) 
	{
System.out.println(login.getEmail() + "  " + login.getPassword());
		if ((vendorDao.login(login.getEmail(), login.getPassword())) != null) 
		{
			vendor =vendorDao.login(login.getEmail(), login.getPassword());
			session.setAttribute("vendor",vendor);
			return "vendorindex";
		} 
		else 
		{
			return "login";
		}
	}
	
	@GetMapping("profile")
	public String profile() 
	{
		return "profile";
	}

	@GetMapping("/editprofile")
	public String editprofile(HttpSession session, Model model) {
		model.addAttribute("vendor", session.getAttribute("vendor"));
		return "editprofile";
	}

	@PostMapping("/update")
    public String update(@ModelAttribute("vendor")Vendor vendor,HttpSession httpSession)
    {
        System.out.println(vendor);
        httpSession.setAttribute("vendor", vendor);
        vendorDao.updateVendor(vendor);
        return "profile";
        
    }
	
	@GetMapping("vendordetails")
	public String getVendorDetails(Map<String, Object> vendor) {
		vendor.put("vendorList",vendorDao.getVendorDetails());
		return "vendordetails";
	}
	
	@GetMapping("categorydetails")
	public String getCategoryDetails(Map<String,Object> category )
	{
		category.put("categorylist",categoryDao.getCategoryDetails());
		return "categorydetails";
	}
	

	
@GetMapping("accept/{id}")
public String acceptUser(@PathVariable("id")long id) {
	
	Vendor vendor=vendorDao.getVendor(id);
	vendor.setStatus(true);
	vendorDao.updateVendor(vendor);
	return "index";
	
}

@GetMapping("reject/{id}")
public String rejectUser(@PathVariable("id")long id) {
	
	Vendor vendor=vendorDao.getVendor(id);
	vendor.setStatus(false);
	vendorDao.updateVendor(vendor);
	return "index";
	
}
	
/*@GetMapping("adminlogin")
public String adminlogin()
{
	return "adminlogin";
}


@PostMapping("adminlogin")
public String adminlogin(@ModelAttribute("login") Login login,HttpSession session,Admin admin)
{
	if(adminDao.adminlogin(login.getEmail(),login.getPassword())!=null)
	{
		admin=adminDao.adminlogin(login.getEmail(),login.getPassword());
		session.setAttribute("admin", admin);
		return "admin";
	}
	else
	{
		return "adminlogin";
	}
}*/


//customer signup process
	
	@GetMapping("/customersignup")
	public String signupCustomer(Model model)
	{
		model.addAttribute("customer", new Customer());
		
		return "customersignup";
	}
	
	@PostMapping("customersignup")
	public String singupCustomer(@ModelAttribute("customer")Customer customer) {
	
		if((customerDao.getCustomerByEmail(customer.getEmail()))!=null) {
		
			 return "customerlogin";
		}
		else {
			customerDao.addCustomer(customer);
			return "customersignup";
		}
	}
	
	
	
	@GetMapping("/customerlogin")
	public String loginCustomer(Model model)
	{
		model.addAttribute("login", new Login());
		return "customerlogin";
	}
	
	@PostMapping("/customerlogin")
	public String loginCustomer(HttpServletRequest request, HttpSession session,Customer customer) 
	{
/*System.out.println(login.getEmail() + "  " + login.getPassword());*/
		if ((customerDao.login(request.getParameter("email"),request.getParameter("password"))) != null) 
		{
			customer =customerDao.login(request.getParameter("email"),request.getParameter("password"));
			session.setAttribute("customer",customer);
			return "customerindex";
		} 
		else 
		{
			return "customerlogin";
		}
	}
	
	@GetMapping("customerindex")
	public String customerindex(Model model)
	{
		return "customerindex";
	}


}
