package ecommerce.webdemo.dao;

import java.util.List;

import ecommerce.webdemo.model.Category;

public interface CategoryDao {
	public boolean addCategory(Category category);
	public List<Category> getCategoryDetails();
	public Category getCategoryId(int cid);
	
	
}
