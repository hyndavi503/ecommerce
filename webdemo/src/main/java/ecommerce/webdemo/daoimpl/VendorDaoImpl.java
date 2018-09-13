package ecommerce.webdemo.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.webdemo.dao.VendorDao;
import ecommerce.webdemo.model.Products;
import ecommerce.webdemo.model.Vendor;




@Component
@Transactional
public class VendorDaoImpl implements VendorDao{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public boolean addVendor(Vendor vendor) {
		try {
			factory.getCurrentSession().save(vendor);
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
	}

	@Override
	public boolean updateVendor(Vendor vendor) {
		try {
			factory.getCurrentSession().update(vendor);
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
	}

	@Override
	public boolean deleteVendor(Vendor vendor) {
		try {
			factory.getCurrentSession().delete(vendor);
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
	}

	@Override
	public Vendor login(String email, String password) {
		try
		{
		Query<Vendor> query=factory.getCurrentSession().createQuery("from Vendor where email=:email and password=:password",Vendor.class)
				.setParameter("email", email)
				.setParameter("password", password);
		return query.getSingleResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		return null;
	}
	}

	/*@Override
	public Venodr getAllVendorDetails(long id) {
		try {
			User user=factory.getCurrentSession().get(User.class,id);
			return user;
		} catch (Exception e) {
			return null;
		}
		
	}*/
	@Override
	public Vendor getVendor(long id) {
		// TODO Auto-generated method stub
		try {
			return factory.getCurrentSession().get(Vendor.class,id);
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public Vendor getVendorByEmail(String email) {
		try
		{
			Query<Vendor> query=factory.getCurrentSession().createQuery("from Vendor where email=:email", Vendor.class)
					.setParameter("email", email);
			return query.getSingleResult();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	
	
	
	@Override
	public List<Vendor> getVendorDetails() {
		
		try {
			Query<Vendor> query=factory.getCurrentSession().createQuery("from Vendor ",Vendor.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Products> getProducts(int Vendor_id) {
		
		try {
			Query<Products> query=factory.getCurrentSession().createQuery("form Products where vendor_id=:id", Products.class);
			return query.getResultList();
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
	}

}
