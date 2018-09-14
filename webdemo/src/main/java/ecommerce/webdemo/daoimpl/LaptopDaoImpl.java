package ecommerce.webdemo.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.LaptopDao;
import ecommerce.webdemo.model.Laptop;

@Component
@Transactional

public class LaptopDaoImpl implements LaptopDao {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public boolean addLaptop(Laptop laptop) {
		try
		{
			 factory.getCurrentSession().save(laptop);
			 return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean deleteLaptop(Laptop laptop) {
		try
		{
			factory.getCurrentSession().delete(laptop);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public Laptop getLaptopDetails(int pid) {
		try {
			return factory.getCurrentSession().get(Laptop.class, pid);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public boolean updateLaptop(Laptop laptop) {
		try {
			factory.getCurrentSession().update(laptop);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	
}
