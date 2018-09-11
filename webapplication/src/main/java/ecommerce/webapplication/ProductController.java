package ecommerce.webapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.webdemo.dao.CategoryDao;
import ecommerce.webdemo.dao.SubCategoryDao;
import ecommerce.webdemo.daoimpl.SubCategoryDaoImpl;
import ecommerce.webdemo.model.SubCategory;

@Controller
public class ProductController {
	
	@Autowired
	private SubCategoryDao subCategoryDao;
	@Autowired
	private CategoryDao categoryDao;
	
	@PostMapping("subcategory")
	public String getSubCategory(@RequestParam("category")int cid, Model model) {
		 
		model.addAttribute("subCategoryList",subCategoryDao.getSubCategory(cid));
		model.addAttribute("categoryName",categoryDao.getCategoryId(cid));
		return "subcategory";
		
	}
	/*@PostMapping("getModel")
	public String  addProducts() {
		
	}*/
	
}
	