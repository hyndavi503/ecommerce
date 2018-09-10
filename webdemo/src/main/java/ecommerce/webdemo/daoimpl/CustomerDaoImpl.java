package ecommerce.webdemo.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.webdemo.dao.CustomerDao;
import ecommerce.webdemo.model.Customer;


@Component
@Transactional
public class CustomerDaoImpl implements CustomerDao{

	
	@Autowired
	private SessionFactory factory;
	@Override
	public boolean addCustomer(Customer customer) {
		try {
			factory.getCurrentSession().save(customer);
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try {
			factory.getCurrentSession().update(customer);
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		try {
			factory.getCurrentSession().update(customer);
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}

}
