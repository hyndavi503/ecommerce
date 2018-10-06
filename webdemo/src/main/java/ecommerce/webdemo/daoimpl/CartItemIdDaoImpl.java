package ecommerce.webdemo.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.CartItemIdDao;
import ecommerce.webdemo.model.CartItemId;
@Component
@Transactional
public class CartItemIdDaoImpl implements CartItemIdDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addCartItemId(CartItemId cartItemId) {
		try {
			sessionFactory.getCurrentSession().save(cartItemId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCartItemId(CartItemId cartItemId) {
		try {
			sessionFactory.getCurrentSession().delete(cartItemId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCartItemId(CartItemId cartItemId) {
		try {
			sessionFactory.getCurrentSession().update(cartItemId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteAllCartItemId(int cartItem_id) {
		try {
			sessionFactory.getCurrentSession().createQuery("delete from CartItemId where cartItems_cartItem_id=:id")
					.setParameter("id", cartItem_id);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public List<CartItemId> getAllCartItemId(int cartItem_id) {
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from CartItemId where cartItems_cartItem_id=:id", CartItemId.class)
					.setParameter("id", cartItem_id).getResultList();
		} catch (Exception e) {
			
			return null;
		}
	}

}
