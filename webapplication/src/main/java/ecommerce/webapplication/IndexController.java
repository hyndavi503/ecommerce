package ecommerce.webapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.webdemo.dao.VendorDao;
import ecommerce.webdemo.model.Login;
import ecommerce.webdemo.model.Vendor;

@Controller
public class IndexController {
	@Autowired
	private VendorDao vendorDao;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("index");
		view.addObject("myName", "hyndavi");
		return view;
	}

	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView modelAndView = new ModelAndView("contact");
		modelAndView.addObject("myContact", "9966293705");
		return modelAndView;
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("vendor", new Vendor());
		return "signup";
	}

	@PostMapping("/signup")
	public String signup(@ModelAttribute("vendor") Vendor vendor) {
		if (vendorDao.getEmail(vendor.getEmail()) == null) {
			vendorDao.addVendor(vendor);
			
			return "redirect:/login";
		} else {
			return "signup";
		}
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}
	

	@PostMapping("/login")
	public String login(@ModelAttribute("login") Login login,Model model,Vendor vendor) {
		if (vendorDao.login(login.getEmail(),login.getPassword()) != null) 
		{
			 vendor=vendorDao.login(login.getEmail(),login.getPassword());
			model.addAttribute("vendor", vendor);
			return "profile";
		} else {
			return "login";
		}
	}

	@GetMapping("/profile")
	public String profile(Model model) 
	{
		return "profile";
	}
	
	@GetMapping("/update")
	public String updation(Model model)
	{
		return "update";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute("vendor") Vendor vendor)
	{
		if(vendorDao.updateVendor(vendor))
		{
		return "redirect:/success";
		}
		else
		{
			return "update";
		}
	}
	
}
