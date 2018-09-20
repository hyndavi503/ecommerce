package ecommerce.webdemo.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.CartDao;
import ecommerce.webdemo.model.Cart;

@Transactional
@Component
public class CartDaoImpl implements CartDao{

	@Autowired
	private SessionFactory factory;
	@Override
	public boolean addCart(Cart cart) {
		try {
			factory.getCurrentSession().save(cart);
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			factory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}

	@Override
	public boolean deleteCart(Cart cart) {
		try {
			factory.getCurrentSession().delete(cart);
			return true;
		} catch (Exception e) {
		
			return false;
		}
	
	}

	@Override
	public Cart getCartById(int cartId) {
		try {
			return factory.getCurrentSession().get(Cart.class,cartId);
			
		} catch (Exception e) {
			return null;
		}
		
	}

}
