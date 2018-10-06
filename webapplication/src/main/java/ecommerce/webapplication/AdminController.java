
package ecommerce.webapplication;

import java.security.Principal;
import java.util.Map;

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

import ecommerce.webdemo.dao.AdminDao;
import ecommerce.webdemo.dao.CategoryDao;
import ecommerce.webdemo.dao.VendorDao;
import ecommerce.webdemo.model.Admin;
import ecommerce.webdemo.model.AdminLogin;
import ecommerce.webdemo.model.Category;
import ecommerce.webdemo.model.Customer;
import ecommerce.webdemo.model.Vendor;

@Controller

public class AdminController 
{
	
	@Autowired
	private Admin admin;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AdminLogin adminLogin;
	@Autowired
	private Vendor vendor;
	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private Category category;
	@Autowired
	private CategoryDao categoryDao;
	

	@GetMapping("/adminlogin")
	public String adminlogin()
	{
		return "adminlogin";
	}

	@GetMapping("/admin/adminpage")
	public ModelAndView openAdminIndex() {
		ModelAndView modelAndView = new ModelAndView("adminpage");
		return modelAndView;
	}

	

	@GetMapping("admin/adminprofile")
	public ModelAndView getAdminProfile(Principal principal)
	{
		ModelAndView view=new ModelAndView("adminprofile");
		view.addObject("admin",adminDao.getAdminByEmail(principal.getName()));
		return view;
	}

	/*@GetMapping("/admin/editadmin")
	public String editprofile(HttpSession session, Model model) {
		model.addAttribute("admin", session.getAttribute("admin"));
		return "editadmin";
	}

	@PostMapping("/admin/updateadmin")
    public String update(@ModelAttribute("admin")Admin admin,HttpSession httpSession)
    {
        System.out.println(admin);
        httpSession.setAttribute("admin",admin);
      adminDao.updateAdmin(admin);
        return "adminprofile";
        
    }*/
	
	@GetMapping("admin/accept/{id}")
	public String acceptUser(@PathVariable("id") int id) {

		Vendor vendor = vendorDao.getVendor(id);
		vendor.setStatus(true);
		vendorDao.updateVendor(vendor);
		return "redirect:/admin/vendordetails";

	}

	@GetMapping("admin/reject/{id}")
	public String rejectUser(@PathVariable("id") int id) {

		Vendor vendor = vendorDao.getVendor(id);
		vendor.setStatus(false);
		vendorDao.updateVendor(vendor);
		return "redirect:/admin/vendordetails";

	}
	@GetMapping("admin/vendordetails")
	public String getVendorDetails(Map<String, Object> vendors) {
		vendors.put("vendorList", adminDao.getAllVendors());
		return "vendordetails";
	}

	/*@GetMapping("vendor/categories")
	public String getCategories(Map<String, Object> categories) {
		categories.put("categoryList", categoryDao.getCategoryDetails());

		return "categories";
	}
	*/


}



