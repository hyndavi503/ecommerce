package ecommerce.webdemo.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.webdemo.dao.CartItemIdDao;
import ecommerce.webdemo.model.CartItemId;

@Transactional
@Component
public class CartItemIdDaoImpl implements CartItemIdDao{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public boolean addCartItemId(CartItemId cartItemId) {
	try {
		factory.getCurrentSession().save(cartItemId);
		return true;
	} catch (Exception e) {
		return false;
	}
		
	}

	@Override
	public boolean updateCartItemId(CartItemId cartItemId) {
		
		try {
			factory.getCurrentSession().update(cartItemId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCartItemId(CartItemId cartItemId) {
		
		try {
			factory.getCurrentSession().delete(cartItemId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	@Override
	public CartItemId getIdByCartItemId(int cartItemId) {
		try {
			Query<CartItemId> query=factory.getCurrentSession().createQuery("from CartItemId where CartItem_cartItemId=:cartItemId",CartItemId.class);
			query.setParameter("cartItemId",cartItemId);
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
