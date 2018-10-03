package ecommerce.webapplication;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.webdemo.dao.CustomerDao;
import ecommerce.webdemo.dao.LaptopDao;
import ecommerce.webdemo.dao.ProductDao;
import ecommerce.webdemo.dao.SubCategoryDao;
import ecommerce.webdemo.model.Customer;
import ecommerce.webdemo.model.CustomerLogin;
import ecommerce.webdemo.model.Laptop;
import ecommerce.webdemo.model.Login;
import ecommerce.webdemo.model.Products;
import ecommerce.webdemo.model.SubCategory;
import ecommerce.webdemo.model.Vendor;

@Controller
public class CustomerController 
{
	
	@Autowired
	private CustomerLogin customerLogin;
	@Autowired
	private Customer customer;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private Laptop laptop;
	@Autowired
	private LaptopDao laptopDao;
	
	@Autowired
	private Products products;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private SubCategory subCategory;
	@Autowired
	private SubCategoryDao subCategoryDao;
	
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
		return "redirect:/customerlogin";
	}
	else
	{
		return "customersignup";
	}
}
@GetMapping("customerlogin")
public String customerlogin(Model model) {
	model.addAttribute("customerlogin", new Customer());
	return "customerlogin";
}

/*@PostMapping("customerloginprocess")
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
*/


@GetMapping("customer/customerpage")
public ModelAndView CustomerIndex() {
	ModelAndView modelAndView = new ModelAndView("customerpage");
	return modelAndView;
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

@PostMapping("updatecustomer")
public String updatecustomer(@ModelAttribute("customer") Customer customer,HttpSession httpSession)
{
	httpSession.setAttribute("customer", customer);
	customerDao.updateCustomer(customer);
	return "customerprofile";
}




}
