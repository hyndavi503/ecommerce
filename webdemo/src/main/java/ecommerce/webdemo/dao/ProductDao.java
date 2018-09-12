package ecommerce.webdemo.dao;


import ecommerce.webdemo.model.Products;

public interface ProductDao 
{
public boolean addProduct(Products products);
public boolean deleteProduct(Products products);
public boolean updateProduct(Products products);
}
