package ecommerce.webdemo.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.ProductDao;
import ecommerce.webdemo.model.Products;

@Component
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public boolean addProduct(Products products) {
		try
		{
			factory.getCurrentSession().save(products);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	
	
	@Override
	public boolean deleteProduct(Products products) {
	
		try {
			factory.getCurrentSession().delete(products);
			return true;			
		} catch (HibernateException e) {
		
			return false;
		}
	}

	@Override
	public boolean updateProduct(Products products) {
		
		try {
			factory.getCurrentSession().update(products);
			return true;			
		} catch (HibernateException e) {
			
			return false;
		}

	}
}
