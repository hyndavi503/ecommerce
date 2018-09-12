package ecommerce.webapplication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.webdemo.dao.CategoryDao;
import ecommerce.webdemo.dao.LaptopDao;
import ecommerce.webdemo.dao.MixerDao;
import ecommerce.webdemo.dao.MobileDao;
import ecommerce.webdemo.dao.SubCategoryDao;
import ecommerce.webdemo.daoimpl.SubCategoryDaoImpl;
import ecommerce.webdemo.model.Laptop;
import ecommerce.webdemo.model.Mixer;
import ecommerce.webdemo.model.Mobile;
import ecommerce.webdemo.model.SubCategory;

@Controller
public class ProductController {
	
	@Autowired
	private SubCategoryDao subCategoryDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private LaptopDao laptopDao;
	@Autowired
	private MobileDao mobileDao;
	/*@Autowired
	private MixerDao mixerDao;*/
	
	
	
	@PostMapping("subcategory")
	public String getSubCategory(@RequestParam("cid")int cid,Model model) {
		 
		model.addAttribute("subCategoryList",subCategoryDao.getSubCategoryById(cid));
		model.addAttribute("cname",categoryDao.getCategoryId(cid));
		return "subcategory";
		
	}
	@PostMapping("getModel")
	public String  addProducts(HttpServletRequest request,Model model) {
		
		switch(request.getParameter("subcategoryname")) 
		{
		  case "laptop": model.addAttribute("laptop" ,new Laptop());
		  return "laptop";
		  
		  case "mobile": model.addAttribute("mobile" ,new Mobile());
		   return "mobile";
		   
		  /*case "Mixer": model.addAttribute("mixer" ,new Mixer());
		   return "mixer";*/
		default: return "subcategory";
		}
		
	}
	
	@PostMapping("laptopprocess")
	public String addLaptopProcess(@ModelAttribute("laptop")Laptop laptop) {
		
		laptopDao.addLaptop(laptop);
		return "vendorindex";
	}
	
	@PostMapping("mobileprocess")
	public String addMobileProcess(@ModelAttribute("mobile")Mobile mobile) {
		
		mobileDao.addMobile(mobile);
		return "vendorindex";
	}
	
	/*@PostMapping("mixerprocess")
	public String addMixerProcess(@ModelAttribute("mixer")Mixer mixer) {
		
		mixerDao.addMixer(mixer);
		return "vendorindex";
	}*/
}

	