package ecommerce.webdemo.dao;

import ecommerce.webdemo.model.Customer;


public interface CustomerDao 
{
	public boolean addCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public boolean deleteCustomer(Customer customer);
}
