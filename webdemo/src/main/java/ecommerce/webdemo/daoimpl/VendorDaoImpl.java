package ecommerce.webdemo.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.VendorDao;
import ecommerce.webdemo.model.Vendor;

@Component
@Transactional
public class VendorDaoImpl implements VendorDao
{
@Autowired
private SessionFactory factory;

	@Override
	public boolean addVendor(Vendor vendor) {
		try
		{
			factory.getCurrentSession().save(vendor);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean deleteVendor(Vendor vendor) {
		try
		{
			factory.getCurrentSession().delete(vendor);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean updateVendor(Vendor vendor) {
		try
		{
			factory.getCurrentSession().update(vendor);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public Vendor getVendor(long id) {
	try
	{
		return factory.getCurrentSession().get(Vendor.class, id);
	}
	catch(Exception e)
	{
		return null;
	}
}

	@Override
	public Vendor login(String email, String password) 
	{
	Query<Vendor> query=factory.getCurrentSession().createQuery("from Vendor where email=:email and password=:password", Vendor.class);
	query.setParameter("email", email);
	query.setParameter("password", password);
	
		return query.getSingleResult();
	}

}
