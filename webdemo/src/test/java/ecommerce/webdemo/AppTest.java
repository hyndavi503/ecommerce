package ecommerce.webdemo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ecommerce.webdemo.dao.AccountDao;
import ecommerce.webdemo.dao.AddressDao;
import ecommerce.webdemo.dao.AdminDao;
import ecommerce.webdemo.dao.CategoryDao;
import ecommerce.webdemo.dao.CustomerDao;
import ecommerce.webdemo.dao.LaptopDao;
import ecommerce.webdemo.dao.ProductDao;
import ecommerce.webdemo.dao.SubCategoryDao;
import ecommerce.webdemo.dao.VendorDao;
import ecommerce.webdemo.model.Account;
import ecommerce.webdemo.model.Address;
import ecommerce.webdemo.model.Admin;
import ecommerce.webdemo.model.Category;
import ecommerce.webdemo.model.Customer;
import ecommerce.webdemo.model.Laptop;
import ecommerce.webdemo.model.Products;
import ecommerce.webdemo.model.SubCategory;
import ecommerce.webdemo.model.Vendor;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ecommerce.webdemo.HibernateConfig;

@SpringJUnitConfig(classes = (HibernateConfig.class))
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {

	
	/*@Autowired
	private Admin admin;
	@Autowired
	private AdminDao adminDao;*/
	@Autowired
	private Vendor vendor;
	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private Products products;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private Category category;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private SubCategory subCategory;
	@Autowired
	private SubCategoryDao subCategoryDao;
	@Autowired
	private Laptop laptop;
	@Autowired
	private LaptopDao laptopDao;
	@Autowired
	private Customer customer;
	@Autowired
	private CustomerDao customerDao;
	

	@Before
	public void setup() 
	{
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(HibernateConfig.class);
		
		
		/*admin.setAdmin_name("sudheer");
		admin.setAdmin_email("sudheer@gmail.com");
		admin.setAdmin_password("sudheer");*/
		
		customer.setName("shyam");
		customer.setEmail("shyam@gmail.com");
		customer.setMobile("9666069549");
		customer.setPassword("shyam");

		vendor.setName("hyndavi");
		vendor.setEmail("hyndavi@gmail.com");
		vendor.setMobile("9966293705");
		vendor.setPassword("hyndavi");
		vendor.setCompanyname("flipkart");
	
		
		laptop = new Laptop();
		laptop.setRam(4);
		laptop.setRom(4);
		laptop.setNumberOfProducts(6);
		laptop.setOs("windows 8.1");
		laptop.setPrice("20000");
	}
	
	
	
	@Test
	public void addCustomer()
	{
		assertEquals("test is failed",true,customerDao.addCustomer(customer));
		/*deleteCustomer();*/
	}
	
	/*public void updateCustomer()
	{
		customerDao.addCustomer(customer);
		customer.setName("sudheer");
		customer.setEmail("sudheer@gmail.com");
		customer.setMobile("9989873796");
		customer.setPassword("sudheer");
		assertEquals("test is failed",true,customerDao.updateCustomer(customer));
		deleteCustomer();
	}*/
	@Test
	public void addVendor()
	{
		assertEquals("test is failed",true,vendorDao.addVendor(vendor));

	}
	
	public void getVendor()
	{
		vendorDao.addVendor(vendor);
		assertEquals("test is failed",vendor,vendorDao.getVendor(vendor.getId()));
	}
	
	
	public void getVendorByEmail()
	{
		vendorDao.addVendor(vendor);
		assertEquals("test is failed",vendor,vendorDao.getVendorByEmail(vendor.getEmail()));
	}
	public void updateVendor()
	{
		vendorDao.addVendor(vendor);
		vendor.setName("reshma");
		vendor.setEmail("reshma@gmail.com");
		vendor.setMobile("34567890");
		vendor.setPassword("reshma");
		vendor.setCompanyname("amazon");
		assertEquals("test is failed",true,vendorDao.updateVendor(vendor));
		/*deleteUser();*/
	}
	
	public void getCustomerById()
	{
		customerDao.addCustomer(customer);
		assertEquals("test is failed",customer,customerDao.getCustomerById(customer.getId()));
	}
	
	
	public void getCustomerByEmail()
	{
		customerDao.addCustomer(customer);
		assertEquals("test is failed",customer,customerDao.getCustomerByEmail(customer.getEmail()));
	}
	@After
	public void deleteVendor()
	{
		vendorDao.deleteVendor(vendor);
	}
	
	@After
	public void deleteCustomer()
	{
		customerDao.deleteCustomer(customer);
	}
	
	
	@Test
	public void addLaptop() {
		subCategory = subCategoryDao.getSubCategory(1);
		vendorDao.addVendor(vendor);
		laptop.setVendor(vendor);
		laptop.setSubCategory(subCategory);
		assertEquals("test is failed", true, laptopDao.addLaptop(laptop));
		deleteLaptop();
		
	}

	
	
	public void deleteLaptop() 
	{
		assertEquals("test is failed", true, laptopDao.deleteLaptop(laptop));
	}
	
}
