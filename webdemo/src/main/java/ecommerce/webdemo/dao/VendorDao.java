package ecommerce.webdemo.dao;

import java.util.List;

import ecommerce.webdemo.model.Vendor;



public interface VendorDao 
{
public boolean addVendor(Vendor vendor);
public boolean updateVendor(Vendor vendor);
public boolean deleteVendor(Vendor vendor);
public Vendor login(String email,String password);
public Vendor getVendor(long user_id);
public Vendor getVendorByEmail(String email);
/*public Vendor getAllVendorDetails(long id);*/
public List<Vendor>  getVendorDetails();
}


