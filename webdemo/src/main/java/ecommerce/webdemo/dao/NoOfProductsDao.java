package ecommerce.webdemo.dao;

import java.util.List;

import ecommerce.webdemo.model.NoOfProducts;

public interface NoOfProductsDao {
	public  boolean addNoOfProducts(NoOfProducts noOfProducts);
	public List<NoOfProducts> getNoOfProducts(int pid);
	public NoOfProducts  getNoOfProductsByNoOfproductsId(int itemNo);
}
