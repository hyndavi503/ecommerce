package ecommerce.webapplication;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.webdemo.dao.CategoryDao;
import ecommerce.webdemo.dao.LaptopDao;
import ecommerce.webdemo.dao.MixerDao;
import ecommerce.webdemo.dao.MobileDao;
import ecommerce.webdemo.dao.SubCategoryDao;
import ecommerce.webdemo.dao.VendorDao;
import ecommerce.webdemo.daoimpl.SubCategoryDaoImpl;
import ecommerce.webdemo.model.Laptop;
import ecommerce.webdemo.model.Mixer;
import ecommerce.webdemo.model.Mobile;
import ecommerce.webdemo.model.NoOfProducts;
import ecommerce.webdemo.model.Products;
import ecommerce.webdemo.model.SubCategory;
import ecommerce.webdemo.model.Vendor;

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
	@Autowired
	private MixerDao mixerDao;
	@Autowired
	private VendorDao vendorDao;
	
	
	
	
	@PostMapping("subcategory")
	public String getSubCategory(@RequestParam("cid")int cid,Model model) {
		 
		model.addAttribute("subCategoryList",subCategoryDao.getSubCategoryById(cid));
		model.addAttribute("cname",categoryDao.getCategoryId(cid));
		return "subcategory";
		
	}
	@PostMapping("getModel")
	

	public String  addProducts(HttpServletRequest request,Model model,HttpSession session) {
		SubCategory subCategory=subCategoryDao.getSubCategory(Integer.parseInt(request.getParameter("sid")));
		model.addAttribute("sid", subCategory.getSid());
		Vendor vendor=(Vendor)session.getAttribute("vendor");
		
		
		model.addAttribute("id",vendor.getId());
		
		  switch(subCategory.getSubcategoryname())  
		{
		  case "laptop": model.addAttribute("laptop" ,new Laptop());
		  return "laptop";
		  
		  case "mobiles": model.addAttribute("mobile" ,new Mobile());
		   return "mobile";
		   
		  /*case "Mixer": model.addAttribute("mixer" ,new Mixer());
		   return "mixer";*/
		default: return "subcategory";
		}
				
}
	
	@PostMapping("laptop")
	public String addLaptop(@ModelAttribute("laptop")Laptop laptop) {
		
		laptopDao.addLaptop(laptop);
		return "vendorindex";
	}
	
	@PostMapping("mobile")
	public String addMobile(@ModelAttribute("mobile")Mobile mobile) {
		
		mobileDao.addMobile(mobile);
		return "vendorindex";
	}
	
	@PostMapping("mixer")
	public String addMixer(@ModelAttribute("mixer")Mixer mixer) {
		
		mixerDao.addMixer(mixer);
		return "vendorindex";
	}
	
	private List<NoOfProducts> listOfProducts(Products products)
	{
		List<NoOfProducts> noOfProductsList=new ArrayList<NoOfProducts>();
		for(int i=1;i<=products.getNumberOfProducts();i++)
		{
			NoOfProducts noOfProducts=new NoOfProducts();
			noOfProducts.setProducts(products);
			noOfProductsList.add(noOfProducts);
		}	
		return noOfProductsList;
}
	
	
	
	@GetMapping("productdetails")
	public String getProducts(HttpSession session,Model model) {
		Vendor vendor=(Vendor)session.getAttribute("vendorDetails");
		List<Products> products=vendorDao.getProducts(vendor.getId());
	    session.setAttribute("products",products);
		return "productdetails";	
	}
	
}

	