package ecommerce.webdemo.dao;

import ecommerce.webdemo.model.Laptop;

public interface LaptopDao 
{
public boolean addLaptop(Laptop laptop);
public boolean deleteLaptop(Laptop laptop);
public boolean updateLaptop(Laptop laptop);
public Laptop getLaptopDetails(int pid);
}
