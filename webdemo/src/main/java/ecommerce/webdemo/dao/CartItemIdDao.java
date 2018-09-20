package ecommerce.webdemo.dao;

import ecommerce.webdemo.model.Cart;
import ecommerce.webdemo.model.CartItemId;

public interface CartItemIdDao {

	public boolean addCartItemId(CartItemId cartItemId);
	public boolean updateCartItemId(CartItemId cartItemId);
	public boolean deleteCartItemId(CartItemId cartItemId);
	public CartItemId getIdByCartItemId(int cartItemId);
	
	
	}
