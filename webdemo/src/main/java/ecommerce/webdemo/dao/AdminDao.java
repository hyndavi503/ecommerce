package ecommerce.webdemo.dao;

import java.util.List;

import ecommerce.webdemo.model.Admin;
import ecommerce.webdemo.model.Vendor;


public interface AdminDao 
{
public boolean addAdmin(Admin admin);
public boolean updateAdmin(Admin admin);
public boolean deleteAdmin(Admin admin);
public Admin adminlogin(String email,String password);
/*public Admin getAdminDetailsById(int id);
public List<Vendor>  getAllVendors();*/
public Admin getAdminByEmail(String email);
}
