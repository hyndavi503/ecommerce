package ecommerce.webdemo.dao;

import java.util.List;

import ecommerce.webdemo.model.SubCategory;



public interface SubCategoryDao {
	public SubCategory getSubCategory(int sid);
	public List<SubCategory> getSubCategoryById(int cid);
	
	
}

