package ecommerce.webdemo.dao;

import java.util.List;

import ecommerce.webdemo.model.SubCategory;



public interface SubCategoryDao {
	public SubCategory getSubCategory(int sid);
	public List<SubCategory> getSubCategoryById(int cid);
	public List<SubCategory> getAllSubCategoryList();
	public List<SubCategory> getElectronics();
	public List<SubCategory> getMens();
	public List<SubCategory> getWomens();
	
}

