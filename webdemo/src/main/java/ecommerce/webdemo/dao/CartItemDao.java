package ecommerce.webdemo.dao;

import java.util.List;

import ecommerce.webdemo.model.Cart;
import ecommerce.webdemo.model.CartItem;

public interface CartItemDao {

	public boolean addCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public boolean deleteCartItem(CartItem cartItem);
	public List<CartItem> getCartItemByCartId(int cartId);

	
}
