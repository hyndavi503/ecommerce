package ecommerce.webdemo.dao;


import java.util.List;

import ecommerce.webdemo.model.Products;

public interface ProductDao 
{
public boolean addProduct(Products products);
public boolean deleteProduct(Products products);
public boolean updateProduct(Products products);
public List<Products> getAllProducts(int id);
}
