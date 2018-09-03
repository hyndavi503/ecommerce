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
import ecommerce.webdemo.dao.CategoryDao;
import ecommerce.webdemo.dao.LaptopDao;
import ecommerce.webdemo.dao.ProductDao;
import ecommerce.webdemo.dao.SubCategoryDao;
import ecommerce.webdemo.dao.VendorDao;
import ecommerce.webdemo.model.Account;
import ecommerce.webdemo.model.Address;
import ecommerce.webdemo.model.Category;
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
private Address address;
@Autowired
private AddressDao addressDao;

	@Autowired
	private Account account;
	@Autowired
	private AccountDao accountDao;

	@Before
	public void setup() {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(HibernateConfig.class);
		vendor = new Vendor();
		vendor.setUsername("hyndavi");
		vendor.setEmail("hyndavi@gmail.com");
		vendor.setPassword("hyndavi");
		vendor.setMobile("9966293705");
		vendor.setCompanyName("flipkart");
		
		HashSet<Address> addresses=new HashSet<Address>();
		Address address1=new Address();
		address1.setStreet("watertank");
		address1.setCity("guntur");
		address1.setPincode("522003");
		addresses.add(address1);
		address1.setVendor(vendor);
		
	
		Address address2=new Address();
		address2.setStreet("gandhinagar");
		address2.setCity("tenali");
		address2.setPincode("522001");
		addresses.add(address2);
		address2.setVendor(vendor);
		
		
		account.setAccountNumber("9848022338");
		account.setAccountNumber("sbi");
		
		laptop = new Laptop();
		laptop.setRam(4);
		laptop.setRom(4);
		laptop.setQuantity("2pieces");
		laptop.setOs("windows 8.1");
		laptop.setPrice("20000");
	}

	@Test
	public void addVendor() 
	{
		assertEquals("test is failed", true, vendorDao.addVendor(vendor));

	}

	public void getVendor()
	{
		vendorDao.addVendor(vendor);
		assertEquals("test is failed",vendor,vendorDao.getVendor(vendor.getId()));
	}
	public void getEmail()
	{
		vendorDao.addVendor(vendor);
		assertEquals("test is failed", vendor, vendorDao.getEmail(vendor.getEmail()));
	}
	@Test
	public void updateVendor() {
		vendorDao.addVendor(vendor);
		vendor.setUsername("shyam");
		vendor.setEmail("shyam@gmail.com");
		vendor.setMobile("9666069549");
		vendor.setPassword("shyam");
		vendor.setCompanyName("amazon");
		assertEquals("test vendor updation failed", true, vendorDao.updateVendor(vendor));

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

	@Test
	public void addAddress()
	{
		vendorDao.addVendor(vendor);
		address.setVendor(vendor);
	
		
		assertEquals("test is failed",true,addressDao.addAddress(address));
		deleteAddress();
	}
	
	@Test
	public void addAccount() {
		vendorDao.addVendor(vendor);
		account.setVendor(vendor);
		assertEquals("Test Failed", true, accountDao.addAccount(account));
		deleteAccount();
		
	}
	
	@After
	public void deleteVendor() {
		assertEquals("test is failed", true, vendorDao.deleteVendor(vendor));
	}

	public void deleteLaptop() {
		assertEquals("test is failed", true, laptopDao.deleteLaptop(laptop));
	}
	public void deleteAddress()
	{
		assertEquals("test is failed",true,addressDao.deleteAddress(address));
	}
	public void deleteAccount() {
		assertEquals("Test Failed", true, accountDao.deleteAccount(account));
	}
	
}
