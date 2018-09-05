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
import ecommerce.webdemo.dao.LaptopDao;
import ecommerce.webdemo.dao.ProductDao;
import ecommerce.webdemo.dao.SubCategoryDao;
import ecommerce.webdemo.dao.UserDao;
import ecommerce.webdemo.model.Account;
import ecommerce.webdemo.model.Address;
import ecommerce.webdemo.model.Admin;
import ecommerce.webdemo.model.Category;
import ecommerce.webdemo.model.Laptop;
import ecommerce.webdemo.model.Products;
import ecommerce.webdemo.model.SubCategory;
import ecommerce.webdemo.model.User;
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
	private User user;
	@Autowired
	private UserDao userDao;
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
	

	@Before
	public void setup() {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(HibernateConfig.class);
		
		
		/*admin.setAdmin_name("sudheer");
		admin.setAdmin_email("sudheer@gmail.com");
		admin.setAdmin_password("sudheer");*/
		

		user.setName("hyndavi");
		user.setEmail("hyndavi@gmail.com");
		user.setMobile("9966293705");
		user.setPassword("hyndavi");
		user.setRole("customer");
		
		
		laptop = new Laptop();
		laptop.setRam(4);
		laptop.setRom(4);
		laptop.setQuantity("2pieces");
		laptop.setOs("windows 8.1");
		laptop.setPrice("20000");
	}
	
	@Test
	public void addUser()
	{
		assertEquals("test is failed",true,userDao.addUser(user));
		/*deleteUser();*/
	}
	
	public void getUser()
	{
		userDao.addUser(user);
		assertEquals("test is failed", user, userDao.getUser(user.getId()));
	}
	
	
	public void getUserByEmail()
	{
		userDao.addUser(user);
		assertEquals("test is failed", user, userDao.getUserByEmail(user.getEmail()));
	}
	public void updateUser()
	{
		userDao.addUser(user);
		user.setName("reshma");
		user.setEmail("reshma@gmail.com");
		user.setMobile("34567890");
		user.setPassword("reshma");
		user.setRole("customer");
		assertEquals("test is failed",true,userDao.updateUser(user));
		/*deleteUser();*/
	}
	@After
	public void deleteUser()
	{
		userDao.deleteUser(user);
	}
	
	
	
	
	@Test
	public void addLaptop() {
		subCategory = subCategoryDao.getSubCategory(1);
		userDao.addUser(user);
		laptop.setUser(user);
		laptop.setSubCategory(subCategory);
		assertEquals("test is failed", true, laptopDao.addLaptop(laptop));
		deleteLaptop();
		
	}

	
	
	public void deleteLaptop() 
	{
		assertEquals("test is failed", true, laptopDao.deleteLaptop(laptop));
	}
	
	
}
