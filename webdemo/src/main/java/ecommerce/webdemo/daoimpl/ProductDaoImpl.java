package ecommerce.webdemo.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

@Override
	public List<Products> getAllProducts(int id) {
		try {
			Query<Products> query=factory.getCurrentSession().createQuery("from Products where vendor_id =: id", Products.class);
			query.setParameter("id",id);
			return query.getResultList();
		} 
		catch (Exception e) 
		{
		e.printStackTrace();
		return null;
		}
	}
	
	@Override
	public int getSid(int pid) {
		
		try {
			Query<Products> query=factory.getCurrentSession().createQuery("from Products where pid =:id",Products.class);
			query.setParameter("id",pid);
			Products products=query.getSingleResult();
			return products.getSubCategory().getSid();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public List<Products> getProducts(int sid) {
		try {
			Query<Products> query=factory.getCurrentSession().createQuery("from Products where SubCategory_sid =: sid", Products.class);
			query.setParameter("sid", sid);
			return query.getResultList();
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}	
		}


	@Override
	public int getSubCategoryId(int pid) {
		
		try {
			Query<Products> query=factory.getCurrentSession().createQuery("from Products where pid =:pid" , Products.class);
			query.setParameter("pid",pid);
			Products product=query.getSingleResult();
			System.out.println(product.getSubCategory().getSid());
			return product.getSubCategory().getSid();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}


	@Override
	public Products getProduct(int pid) {
		try {
			Query<Products> query=factory.getCurrentSession().createQuery("from Products where pid:=pid",Products.class);
			query.setParameter("pid", pid);
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
}
