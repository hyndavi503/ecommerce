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

import ecommerce.webdemo.dao.CustomerDao;
import ecommerce.webdemo.dao.VendorDao;
import ecommerce.webdemo.daoimpl.CustomerDaoImpl;
import ecommerce.webdemo.daoimpl.VendorDaoImpl;
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
			return "redirect:/profile";
		} 
		else 
		{
			return "login";
		}
	}
	
	@GetMapping("profile")
	public String getVendorDetails() 
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
	
	
	@GetMapping("/customersignup")
	public String signupCustomer(Model model)
	{
		model.addAttribute("customer", new Customer());
		
		return "customersignup";
	}
	
	@PostMapping("customersignup")
	public String singupVendorProcess(@ModelAttribute("customer")Customer customer) {
	
		if((customerDao.getCustomerByEmail(customer.getEmail()))!=null) {
		
			 return "customerlogin";
		}
		else {
			customerDao.addCustomer(customer);
			return "index";
		}
	}
	
	@GetMapping("/customerlogin")
	public String loginCustomer(Model model)
	{
		model.addAttribute("login", new Login());
		return "customerlogin";
	}
	
	@PostMapping("customerlogin")
	public  String  loginCustomer(HttpServletRequest request,HttpSession session)
	{
		
	   if((customerDao.loginCustomer(request.getParameter("email"),request.getParameter("password")))!=null) {
		   
		   Customer customer=customerDao.loginCustomer(request.getParameter("email"),request.getParameter("password"));
		   
		   session.setAttribute("customerDetails",customer);
		   
		    return "redirect:customerindex";
		 
	   }
	   else {
		   
		   return "customerlogin";
	   }
	}
	

@GetMapping("vendordetails")
	public String getVendorDetails(Map<String, Object> vendor) {
		vendor.put("vendorList",vendorDao.getVendorDetails());
		return "vendordetails";
	}

	

	/*@GetMapping("accept/{id}")
	public String acceptUser(@PathVariable("id") long id) {

		Vendor vendor =vendorDao.getVendorDetails(id);
		user.setStatus(true);
		userDao.updateUser(user);
		return "index";

	}

	@GetMapping("reject/{id}")
	public String rejectUser(@PathVariable("id") long id) {

		User user = userDao.getAllUserDetails(id);
		user.setStatus(false);
		userDao.updateUser(user);
		return "index";

	}*/
}
