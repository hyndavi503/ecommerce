package ecommerce.webdemo.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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


	@Override
	public Customer loginCustomer(String customer_email, String customer_password) {
		
		try {
			Query<Customer> query=factory.getCurrentSession().createQuery("from Customer where email=:email and password=:password ",Customer.class);
			query.setParameter("email",email);
			query.setParameter("password",password);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Customer getCustomerById(int customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByEmail(String customer_email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomerDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}


