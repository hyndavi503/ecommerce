package ecommerce.webapplication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ecommerce.webdemo.dao.CustomerDao;
import ecommerce.webdemo.model.Customer;
import ecommerce.webdemo.model.CustomerLogin;
import ecommerce.webdemo.model.Login;

@Controller
public class CustomerController 
{
	
	@Autowired
	private CustomerLogin customerLogin;
	@Autowired
	private Customer customer;
	@Autowired
	private CustomerDao customerDao;
	
@GetMapping("/customersignup")
public String customersignup(Model model)
{
	model.addAttribute("customer", new Customer());
	return "customersignup";
}

@PostMapping("/customerregister")
public String customersignup(@ModelAttribute("customer") Customer customer,Model model )
{
	System.out.println(customer.getEmail()+" "+customer.getPassword());
	if(customerDao.getCustomerByEmail(customer.getEmail())== null)
	{
		customerDao.addCustomer(customer);
		return "customerlogin";
	}
	else
	{
		return "customersignup";
	}
}
@GetMapping("/customerlogin")
public String customerlogin(Model model) {
	model.addAttribute("customerlogin", new Customer());
	return "customerlogin";
}

@PostMapping("customerloginprocess")
public String customerlogin(@ModelAttribute("customerlogin") CustomerLogin customerLogin,HttpSession httpSession)
{
	if(customerDao.customerLogin(customerLogin.getEmail(),customerLogin.getPassword())!=null)
			{
		customer=customerDao.customerLogin(customerLogin.getEmail(), customerLogin.getPassword());
		httpSession.setAttribute("customer", customer);
		return "customerpage";
			}
	else
	{
		return "customerlogin";
	}
}

@GetMapping("customerprofile")
public String customerprofile()
{
	return "customerprofile";
}

@GetMapping("editcustomer")
public String editcustomer(HttpSession httpSession,Model model)
{
	model.addAttribute("customer", httpSession.getAttribute("customer"));
	return "editcustomer";
}

@PostMapping("/updatecustomer")
public String updatecustomer(@ModelAttribute("customer") Customer customer,HttpSession httpSession)
{
	httpSession.setAttribute("customer", customer);
	customerDao.updateCustomer(customer);
	return "customerprofile";
}


}
