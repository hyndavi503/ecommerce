package ecommerce.webdemo.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.webdemo.dao.AdminDao;
import ecommerce.webdemo.model.Admin;

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

}
