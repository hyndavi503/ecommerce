package ecommerce.webdemo.dao;

import java.util.List;

import ecommerce.webdemo.model.CartItems;

public interface CartItemsDao {

	
	public boolean addCartItem(CartItems cartItems);

	public boolean deleteCartItem(CartItems cartItems);

	public boolean updateCartItem(CartItems cartItems);

	public List<CartItems> getAllCartItemsByCartId(int cart_id);

	public CartItems getCartItemByCartId(int cart_id);

	public boolean deleteAllCartItems(int cart_id);
	public CartItems getCartItems(int cartItems_id);
	
}
