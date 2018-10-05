package ecommerce.webapplication;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
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
import ecommerce.webdemo.dao.SubCategoryDao;
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
	private SessionFactory session;
	@Autowired
	private Vendor vendor;
	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private Mail mail;
	@Autowired
	private Category category;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private SubCategoryDao subCategoryDao;

	@RequestMapping(value = { "/", "/index" })
	public ModelAndView index(HttpSession session) {
		ModelAndView view = new ModelAndView("index");
		view.addObject("myName", "hyndavi");

		session.setAttribute("electronics", subCategoryDao.getElectronics());
		/*
		 * session.setAttribute("men", subCategoryDao.getMens());
		 * session.setAttribute("women", subCategoryDao.getWomens());
		 */
		return view;
	}

	@RequestMapping("/demo")
	public String demo() {
		return "demo";
	}

	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView modelAndView = new ModelAndView("contact");

		return modelAndView;
	}

	@GetMapping("vendorsignup")

	public String signup(Model model) {
		model.addAttribute("vendor", new Vendor());
		return "vendorsignup";
	}

	@PostMapping("vendorsignup")
	public String signup(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult bindingResult) {
		System.out.println(bindingResult.hasErrors());
		/*
		 * if (!bindingResult.hasErrors()) {
		 */
		if (vendorDao.getVendorByEmail(vendor.getEmail()) == null) {
			vendorDao.addVendor(vendor);
			/*
			 * mail=new Mail(); mail.sendingMail(vendor.getEmail(),vendor.getPassword());
			 */
			return "redirect:/vendorlogin";

		} else {
			return "vendorsignup";
		}
		/*
		 * } else { return "signup"; }
		 */
	}

	@GetMapping("vendorlogin")
	public String login(Principal principal) {

		return "vendorlogin";
	}

	@GetMapping("vendor/vendorindex")
	public String vendor() {
		return "vendorindex";
	}
	// login process
	/*
	 * @PostMapping("/vendor/vendorlogin") public String
	 * loginVendor(@ModelAttribute("login") Login login, HttpSession session,Vendor
	 * vendor) { System.out.println(login.getEmail() + "  " + login.getPassword());
	 * if ((vendorDao.login(login.getEmail(), login.getPassword())) != null) {
	 * vendor =vendorDao.login(login.getEmail(), login.getPassword());
	 * session.setAttribute("vendor",vendor); return "vendorindex"; } else { return
	 * "vendorlogin"; } }
	 */

	@GetMapping("/vendor/profile")
	public ModelAndView profile(Principal principal, HttpSession httpSession) {
		ModelAndView view = new ModelAndView("profile");
		Vendor vendor = vendorDao.getVendorByEmail(principal.getName());
		httpSession.setAttribute("vendor", vendor);
		return view;
	}

	@GetMapping("/vendor/editprofile")
	public String editprofile(HttpSession session, Model model) {
		model.addAttribute("vendor", session.getAttribute("vendor"));
		return "editprofile";
	}

	@PostMapping("/vendor/update")
	public String update(@ModelAttribute("vendor") Vendor vendor, HttpSession httpSession) {
		System.out.println(vendor);
		httpSession.setAttribute("vendor", vendor);
		vendorDao.updateVendor(vendor);
		return "profile";

	}

	/*
	 * @GetMapping("/vendor/vendordetails") public String
	 * getVendorDetails(Map<String, Object> vendor) {
	 * vendor.put("vendorList",vendorDao.getVendorDetails()); return
	 * "vendordetails"; }
	 */
	@GetMapping("/vendor/categorydetails")
	public String getCategoryDetails(Map<String, Object> category) {
		category.put("categorylist", categoryDao.getCategoryDetails());
		return "categorydetails";
	}

}
