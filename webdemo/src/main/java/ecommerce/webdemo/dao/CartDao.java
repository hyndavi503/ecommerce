package ecommerce.webdemo.dao;

import ecommerce.webdemo.model.Cart;

public interface CartDao {
	public boolean addCart(Cart cart);

	public boolean updateCart(Cart cart);

	public boolean deleteCart(Cart cart);
     public Cart getCart(long id);
}
