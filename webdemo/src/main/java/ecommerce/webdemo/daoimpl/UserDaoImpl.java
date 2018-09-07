package ecommerce.webdemo.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.webdemo.dao.UserDao;
import ecommerce.webdemo.model.User;


@Component
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public boolean addUser(User user) {
		try {
			factory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
	}

	@Override
	public boolean updateUser(User user) {
		try {
			factory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			factory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
	}

	@Override
	public User login(String email, String password) {
		try
		{
		Query<User> query=factory.getCurrentSession().createQuery("from User where email=:email and password=:password",User.class)
				.setParameter("email", email)
				.setParameter("password", password);
		return query.getSingleResult();
		}
		catch(Exception e)
		{
		return null;
	}
	}

	@Override
	public User getAllUserDetails(long id) {
		try {
			User user=factory.getCurrentSession().get(User.class,id);
			return user;
		} catch (Exception e) {
			return null;
		}
		
	}
	@Override
	public User getUser(long user_id) {
		// TODO Auto-generated method stub
		try {
			return factory.getCurrentSession().get(User.class, user_id);
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public User getUserByEmail(String email) {
		try
		{
			Query<User> query=factory.getCurrentSession().createQuery("from User where email=:email", User.class)
					.setParameter("email", email);
			return query.getSingleResult();
		}
		catch(Exception e)
		{
		return null;
		}
	}

	@Override
	public List<User> getVendorDetails() {
		try {
			Query<User> query=factory.getCurrentSession().createQuery("from User where role='vendor'",User.class);
			return query.getResultList();
		}
	   catch (Exception e) {
		     e.printStackTrace();
		     return null;
		}
	
	}

}
