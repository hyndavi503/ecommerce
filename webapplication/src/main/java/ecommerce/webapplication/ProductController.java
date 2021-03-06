package ecommerce.webapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.GenericTableMetaDataProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.webdemo.dao.CategoryDao;
import ecommerce.webdemo.dao.LaptopDao;
import ecommerce.webdemo.dao.MobileDao;
import ecommerce.webdemo.dao.ProductDao;
import ecommerce.webdemo.dao.SubCategoryDao;
import ecommerce.webdemo.dao.VendorDao;
import ecommerce.webdemo.daoimpl.SubCategoryDaoImpl;
import ecommerce.webdemo.model.Laptop;
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
	private VendorDao vendorDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private Image image;
	
	
	@PostMapping("vendor/subcategory")
	public String getSubCategory(@RequestParam("cid")int cid,Model model) {
		 
		model.addAttribute("subCategoryList",subCategoryDao.getSubCategoryById(cid));
		model.addAttribute("cname",categoryDao.getCategoryId(cid));
		return "subcategory";
		
		
	}
	@PostMapping("vendor/getModel")
	

	public String  addProducts(HttpServletRequest request,Model model,HttpSession session,Principal principal) {
		SubCategory subCategory=subCategoryDao.getSubCategory(Integer.parseInt(request.getParameter("sid")));
		model.addAttribute("sid", subCategory.getSid());
		/*Vendor vendor=(Vendor)session.getAttribute("vendor");*/
		Vendor vendor=vendorDao.getVendorByEmail(principal.getName());
		session.setAttribute("vendorDetails", vendor);
		model.addAttribute("id",vendor.getId());
		
		  switch(subCategory.getSubcategoryname())  
		{
		  case "laptop": model.addAttribute("laptop" ,new Laptop());
		  return "laptop";
		  
		  case "mobile": model.addAttribute("mobile" ,new Mobile());
		   return "mobile";
		  
		default: return "subcategory";
		}
				
}

	@PostMapping("vendor/laptop")
	public String addLaptop(@ModelAttribute("laptop")Laptop laptop,HttpSession session,HttpServletRequest request) {
	   List<NoOfProducts> noOfProducts=listOfProducts(laptop);
		laptop.setNoOfProducts(noOfProducts);
		
		if(laptopDao.addLaptop(laptop)) 
		{
			image.uploadImage(laptop, request);
			return "redirect:/vendor/vendorindex";
			}
		   else {
			return "vendor/getModel";
		   }
		}
	
	@PostMapping("vendor/mobile")
	public String addMobile(@ModelAttribute("mobile")Mobile mobile,HttpServletRequest request) 
	{	
		
		 List<NoOfProducts> noOfProducts=listOfProducts(mobile);
			mobile.setNoOfProducts(noOfProducts);
		
		if(mobileDao.addMobile(mobile))
		{
			image.uploadImage(mobile, request);
			return "redirect:/vendor/vendorindex";
		}
		
		return "vendor/getModel";
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
	
	@GetMapping("vendor/productdetails")
	public String getProducts(HttpSession session,Model model,Map<String,Object> products,Principal principal) {	
		Vendor vendor=vendorDao.getVendorByEmail(principal.getName());
		products.put("productList", productDao.getAllProducts(vendor.getId()));

		return "productdetails";	
	}

	@GetMapping("vendor/viewproductdetails/{pid}")
	public String viewProducts(@PathVariable("pid")int pid,Model model) 
	{
		String name=subCategoryDao.getSubCategory(productDao.getSid(pid)).getSubcategoryname();
		System.out.println(name);
		switch(name)
		{
		case "mobile":model.addAttribute("mobile",mobileDao.getMobileDetails(pid));
			return "mobiledetails";
		case "laptop": model.addAttribute("laptop",laptopDao.getLaptopDetails(pid));
			return "laptopdetails";
			
		default:return "vendorindex";
       }
	}
	
	
	@GetMapping("productspecifications/{pid}")
	public String viewproductspecifications(@PathVariable("pid") int pid,Model model)
	{
		String name=subCategoryDao.getSubCategory(productDao.getSid(pid)).getSubcategoryname();
		System.out.println(name);
		switch(name)
		{
		case "mobile":model.addAttribute("mobile",mobileDao.getMobileDetails(pid));
			return "viewmobile";
		case "laptop": model.addAttribute("laptop",laptopDao.getLaptopDetails(pid));
			return "viewlaptop";
			
		default:return "vendorindex";
       }
		
	}
@GetMapping("vendor/editproducts/{pid}")
	public String editProducts(@PathVariable("pid") int pid, Model model,HttpServletRequest request) {

		String name = subCategoryDao.getSubCategory(productDao.getSid(pid)).getSubcategoryname();
		switch (name) {
case "mobile":
			model.addAttribute("contextPath",request.getContextPath());
			model.addAttribute("mobile", mobileDao.getMobileDetails(pid));
			return "editmobile";

		case "laptop":
			model.addAttribute("contextPath",request.getContextPath());
			model.addAttribute("laptop", laptopDao.getLaptopDetails(pid));
			return "editlaptop";

		default:
			return "productdetails";
		}
	}
    @PostMapping("editlaptop")
	public String editLaptopProductDetails(@ModelAttribute("laptop")Laptop laptop,HttpServletRequest request) {
        if(!laptop.getImage().isEmpty()) {
        	image.uploadImage(laptop,request);
        }
		laptopDao.updateLaptop(laptop);
		
		return "vendorindex";
	}

	@PostMapping("editmobile")
	public String editMobileProductDetails(@ModelAttribute("mobile") Mobile mobile,HttpServletRequest request) {
		if(!mobile.getImage().isEmpty()) {
        	image.uploadImage(mobile,request);
        }
		mobileDao.updateMobile(mobile);
		return "vendorindex";
	}
	
	
	@GetMapping("products/{sid}")
	public String getProducts(@PathVariable("sid")int sid,Map<String,Object> products,HttpSession session) {
		
		session.setAttribute("electronics",subCategoryDao.getElectronics());
		products.put("productList",productDao.getProducts(sid));
		return "products";
	}
	
	
	@GetMapping("buyproducts/{pid}")
	public String buyProducts(@PathVariable("pid") int pid, Model model) {

		String name = subCategoryDao.getSubCategory(productDao.getSid(pid)).getSubcategoryname();
		System.out.println(name);
		switch (name) 
		{
		case "mobile":
			model.addAttribute("mobile", mobileDao.getMobileDetails(pid));
			return "buymobile";

		case "laptop":
			model.addAttribute("laptop", laptopDao.getLaptopDetails(pid));
			return "buylaptop";
		
		default:
			return "vendor/vendorindex";
		}
	}
}

