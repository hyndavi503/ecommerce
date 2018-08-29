package ecommerce.webdemo.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.AddressDao;
import ecommerce.webdemo.model.Address;

@Component
@Transactional
public class AddressDaoImpl implements AddressDao {
@Autowired
private SessionFactory factory;
	@Override
	public boolean addAddress(Address address) {
		try
		{
			factory.getCurrentSession().save(address);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	@Override
	public boolean deleteAddress(Address address) {
		try
		{
			factory.getCurrentSession().delete(address);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	

}
