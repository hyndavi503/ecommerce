package ecommerce.webdemo.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
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

}
