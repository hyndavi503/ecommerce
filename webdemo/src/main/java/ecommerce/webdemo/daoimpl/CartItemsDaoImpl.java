package ecommerce.webdemo.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.CartItemsDao;
import ecommerce.webdemo.model.CartItems;
@Component
@Transactional
public class CartItemsDaoImpl implements CartItemsDao{

	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCartItem(CartItems cartItems) {

		try {
			sessionFactory.getCurrentSession().save(cartItems);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean deleteCartItem(CartItems cartItems) {

		try {
			sessionFactory.getCurrentSession().delete(cartItems);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCartItem(CartItems cartItems) {

		try {
			sessionFactory.getCurrentSession().update(cartItems);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<CartItems> getAllCartItemsByCartId(int cart_id) {

		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from CartItems where cart_cart_id=:id", CartItems.class).setParameter("id", cart_id)
					.getResultList();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public CartItems getCartItemByCartId(int cart_id) {
		try {
			return (CartItems) sessionFactory.getCurrentSession().createQuery("from CartItems where cart_cart_id=:id")
					.setParameter("id", cart_id).getSingleResult();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public boolean deleteAllCartItems(int cart_id) {
		try {
			sessionFactory.getCurrentSession().createQuery("delete from CartItems where cart_cart_id=:id")
					.setParameter("id", cart_id);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public CartItems getCartItems(int cartItems_id) {
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from CartItems where cartItem_id=:id", CartItems.class).setParameter("id", cartItems_id)
					.getSingleResult();
		} catch (Exception e) {

			return null;
		}
	}

}

