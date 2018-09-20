package ecommerce.webdemo.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.CartItemDao;
import ecommerce.webdemo.model.CartItem;

@Transactional
@Component
public class CartItemDaoImpl implements CartItemDao{

	@Autowired
	private SessionFactory factory;
	@Override
	public boolean addCartItem(CartItem cartItem) {
		try {
			factory.getCurrentSession().save(cartItem);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		try {
			factory.getCurrentSession().update(cartItem);
			return true;
		} catch (Exception e) {
			return false;
		}
	
	}

	@Override
	public boolean deleteCartItem(CartItem cartItem) {
		try {
			factory.getCurrentSession().delete(cartItem);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public List<CartItem> getCartItemByCartId(int cartId) {
		try {
			Query<CartItem> query=factory.getCurrentSession().createQuery("from CartItem where Cart_cartId=cartId",CartItem.class);
			query.setParameter("cartId", cartId);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
		
	}

}
