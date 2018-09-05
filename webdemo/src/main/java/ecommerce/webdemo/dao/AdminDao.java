package ecommerce.webdemo.dao;

import ecommerce.webdemo.model.Admin;


public interface AdminDao 
{
public boolean addAdmin(Admin admin);
public boolean updateAdmin(Admin admin);
public boolean deleteAdmin(Admin admin);

}
