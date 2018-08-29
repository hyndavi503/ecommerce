package ecommerce.webdemo.dao;

import ecommerce.webdemo.model.Account;

public interface AccountDao {
	
	public boolean addAccount(Account account);
	public boolean deleteAccount(Account account);

}
