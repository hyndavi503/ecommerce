package ecommerce.webdemo.dao;

import ecommerce.webdemo.model.Vendor;

public interface VendorDao 
{
public boolean addVendor(Vendor vendor);
public boolean deleteVendor(Vendor vendor);
public boolean updateVendor(Vendor vendor);
public Vendor getVendor(long id);
public Vendor getEmail(String email);
public Vendor login(String email,String password);
}
