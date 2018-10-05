package ecommerce.webdemo.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.webdemo.dao.AdminDao;
import ecommerce.webdemo.model.Admin;
import ecommerce.webdemo.model.Vendor;

@Component
@Transactional
public class AdminDaoImpl implements AdminDao
{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public boolean addAdmin(Admin admin) 
	{
	try
	{
		factory.getCurrentSession().save(admin);
		return true;
	}catch(Exception e)
	{
		return false;
	}
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		try {
			factory.getCurrentSession().update(admin);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean deleteAdmin(Admin admin) {
		try {
			factory.getCurrentSession().delete(admin);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public Admin adminlogin(String email, String password) {
		try {
			Query<Admin> query=factory.getCurrentSession().createQuery("from Admin where email=:email and password=:password",Admin.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
		
	}

	@Override
	public Admin getAdminByEmail(String email) {
		try
		{
			Query<Admin> query=factory.getCurrentSession().createQuery("from Admin where email=:email",Admin.class)
					.setParameter("email", email);
			return query.getSingleResult();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	public List<Vendor> getAllVendors() {
		try {
			Query<Vendor> query=factory.getCurrentSession().createQuery("from Vendor",Vendor.class);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}

