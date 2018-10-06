package ecommerce.webdemo.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.CartDao;
import ecommerce.webdemo.model.Cart;


@Component
@Transactional
public class CartDaoImpl implements CartDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (Exception e) {
			return false;
		}	}
	

	@Override
	public Cart getCart(long id) {
		try {
			return (Cart) sessionFactory.getCurrentSession().createQuery("from Cart where customer_id=:id")
					.setParameter("id",id).getSingleResult();
		} catch (Exception e) {
              e.printStackTrace();
			return null;
		}
	}


	
}