package ecommerce.webdemo.dao;

import java.util.List;

import ecommerce.webdemo.model.CartItemId;

public interface CartItemIdDao {

	public boolean addCartItemId(CartItemId cartItemId);

	public boolean deleteCartItemId(CartItemId cartItemId);

	public boolean updateCartItemId(CartItemId cartItemId);

	public boolean deleteAllCartItemId(int cartItem_id);

	public List<CartItemId> getAllCartItemId(int cartItem_id);
}
