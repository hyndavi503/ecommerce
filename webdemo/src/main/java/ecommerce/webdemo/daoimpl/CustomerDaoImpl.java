package ecommerce.webdemo.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.webdemo.dao.CustomerDao;
import ecommerce.webdemo.model.Customer;
import ecommerce.webdemo.model.Vendor;


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
			factory.getCurrentSession().delete(customer);
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}


	@Override
	public Customer customerLogin(String email, String password) {
		
		try {
			Query<Customer> query=factory.getCurrentSession().createQuery("from Customer where email=:email and password=:password",Customer.class)
					.setParameter("email", email)
					.setParameter("password", password);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

	@Override
	public Customer getCustomerById(long id) 
	{
		try {
			return factory.getCurrentSession().get(Customer.class,id);
		} catch (Exception e) {
			
		return null;
	}
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		
		try
		{
			Query<Customer> query=factory.getCurrentSession().createQuery("from Customer where email=:email",Customer.class)
					.setParameter("email", email);
			return query.getSingleResult();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	public List<Customer> getAllCustomerDetails() {
		try
		{
			Query<Customer> query=factory.getCurrentSession().createQuery("from Customer ",Customer.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}


