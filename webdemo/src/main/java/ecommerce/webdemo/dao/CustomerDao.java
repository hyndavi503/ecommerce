package ecommerce.webdemo.dao;

import java.util.List;

import ecommerce.webdemo.model.Customer;



public interface CustomerDao {
	
	
	public boolean addCustomer(Customer customer);
	public Customer login(String email,String password);
	public boolean deleteCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public Customer getCustomerById(long id);
	public Customer getCustomerByEmail(String email);
	public List<Customer> getAllCustomerDetails();

	
	
}
